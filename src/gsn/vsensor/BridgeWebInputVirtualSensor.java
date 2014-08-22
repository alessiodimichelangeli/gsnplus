/**
* 
* FILE: src/gsn/vsensor/BridgeWebInputVirtualSensor.java
*
* AUTHOR: Alessio Di Michelangeli
*
*
* DESCRIPTION:
*  	This class is a new version class of BridgeVirtualSensor. In particular, is the BridgeVirtualSensor class
*  	with the addition of catching data from web function.
*  	Remember that the BridgeVirtualSensor class does not perform any further processing on its input stream
*	thus it does not alter the data nor the structure of its input.
*	Since the structure of the virtual sensor output is not altered through using the BridgeVirtualSensor 
*	processing class hence the final structure of the virtual sensor’s output is determined through the SQL statement.
*	So, we need to make sure that, the data fields in the select clause matches the definition of the output structure. 
*	Regarding the web input functionality added with dataFromWeb function, as before, there is no processing therefore, 
*	the input structure is not altered.
*/

package gsn.vsensor;

import gsn.beans.StreamElement;

import gsn.beans.VSensorConfig;
import org.apache.log4j.Logger;
import java.util.TreeMap;

//To manage web input we need:
import java.io.Serializable;
import javax.naming.OperationNotSupportedException;
//



public class BridgeWebInputVirtualSensor extends AbstractVirtualSensor {


	/**** GLOBAL VARIABLES ****/
	private final String                  INPUT_STREAM_NAME = "input1";
	private VSensorConfig 		      vsensor;
	//
    	private static final transient Logger logger = Logger.getLogger(BridgeWebInputVirtualSensor.class);
    	private boolean allow_nulls = true; // by default allow nulls
	/**************************/
	
	//**** METHODS ****/
    	public boolean initialize() {
        	//prima vsensorconfig stava dichiarato qui
        	vsensor= getVirtualSensorConfiguration();
        	TreeMap<String, String> params = vsensor.getMainClassInitialParams();

        	String allow_nulls_str = params.get("allow-nulls");
        	if (allow_nulls_str != null)
            		allow_nulls = allow_nulls_str.equalsIgnoreCase("true");

        	return true;
    	}


    	public void dataAvailable(String inputStreamName, StreamElement data) {
        	if (allow_nulls)
            		dataProduced(data);
        	else {
            		if (!areAllFieldsNull(data))
                		dataProduced(data);
            		else {
                		if (logger.isDebugEnabled())
                    			logger.debug("Nulls received for timestamp (" + data.getTimeStamp() + "), discarded");
            		}
        	}
        	if (logger.isDebugEnabled()) 
        		logger.debug("Data received under the name: " + inputStreamName);
    	}


	public boolean areAllFieldsNull(StreamElement data) {
        	boolean allFieldsNull = false;
        	for (int i = 0; i < data.getData().length; i++)
            		if (data.getData()[i] == null) {
                		allFieldsNull = true;
                		break;
            		}

        	return allFieldsNull;
    	}


    	public void dispose() {

    	}
    
    
    	//to manage web input (upload section)
    	public boolean dataFromWeb ( String command, String[] paramNames, Serializable[] paramValues ) {
      		String streamSourceAliasName = "source1";
      		try {
      			System.out.println("*****************************");
      			System.out.println( vsensor.getInputStream( INPUT_STREAM_NAME ) );
      			System.out.println( vsensor.getInputStream( INPUT_STREAM_NAME ).getSource( streamSourceAliasName ) );
      			System.out.println( vsensor.getInputStream( INPUT_STREAM_NAME ).getSource( streamSourceAliasName ).getWrapper() );
        		System.out.println("*****************************");
      
        		return  vsensor.getInputStream( INPUT_STREAM_NAME ).getSource( streamSourceAliasName ).getWrapper().sendToWrapper( command , paramNames , paramValues );
      		} 
      		catch ( OperationNotSupportedException e ) {
         		logger.warn( new StringBuilder( ).append( "The virtual sensor : " ).append( vsensor.getName( ) ).append(
            " want to send data to a stream source which doesn't support receiving data." ).toString( ) );
         		logger.warn( e.getMessage( ) , e );
         		return false;
      		}
   	}
	/**************************/    	

}
