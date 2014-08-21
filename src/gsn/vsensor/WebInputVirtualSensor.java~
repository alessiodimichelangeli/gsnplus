/**
* 
* File: src/gsn/vsensor/WebInputVirtualSensor.java
*
*/

package gsn.vsensor;

import gsn.beans.StreamElement;

import gsn.beans.VSensorConfig;
import org.apache.log4j.Logger;
import java.util.TreeMap;

//
import java.io.Serializable;
import javax.naming.OperationNotSupportedException;
//



public class WebInputVirtualSensor extends AbstractVirtualSensor {


//
private final String                  INPUT_STREAM_NAME = "input1";

private VSensorConfig 		      vsensor;
//

    private static final transient Logger logger = Logger.getLogger(ProvaVirtualSensor.class);
    private boolean allow_nulls = true; // by default allow nulls

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
        if (logger.isDebugEnabled()) logger.debug("Data received under the name: " + inputStreamName);
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
    
    
    //esperimenti
    
    public boolean dataFromWeb ( String command, String[] paramNames, Serializable[] paramValues ) {
      String streamSourceAliasName = "source1";
      try {
      	System.out.println("*****************************");
      	System.out.println( vsensor.getInputStream( INPUT_STREAM_NAME ) );
      	System.out.println( vsensor.getInputStream( INPUT_STREAM_NAME ).getSource( streamSourceAliasName ) );
      	System.out.println( vsensor.getInputStream( INPUT_STREAM_NAME ).getSource( streamSourceAliasName ).getWrapper() );
        System.out.println("*****************************");
      
        return  vsensor.getInputStream( INPUT_STREAM_NAME ).getSource( streamSourceAliasName ).getWrapper().sendToWrapper( command , paramNames , paramValues );
      } catch ( OperationNotSupportedException e ) {
         logger.warn( new StringBuilder( ).append( "The virtual sensor : " ).append( vsensor.getName( ) ).append(
            " want to send data to a stream source which doesn't support receiving data." ).toString( ) );
         logger.warn( e.getMessage( ) , e );
         return false;
      }
   }
    
    //fine esperimenti

}
