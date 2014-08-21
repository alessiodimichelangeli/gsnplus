/*
* File: src/gsn/wrappers/tinyos/CommandFromWebWrapperTEMPLATE.java
*
* @author Alessio Di Michelangeli
*
*/

//THIS WRAPPER IS A COMMAND FROM WEB TEMPLATE WRAPPER.

/********************************************	README	********************************************

Please remember, in this template there is only one field in the DataField collection.
It will be shown that you can send a command from gsn to the related wrapper sensors via 
sendToWrapper function. In this template the command is simply: change the value of the 
field. In a real scenario this is not very useful, but you can edit this template as you 
want. A good implementation of this function is send a message back to the sensor 
(see the tinyos example /gsn/src/gsn/wrappers/tinyos/TinyOsWrapperTEMPLATE)  or
maybe a particular value known as command in the sensors side. 

****************************************************************************************************/


package gsn.wrappers;

import gsn.beans.AddressBean;
import gsn.beans.DataField;

import java.io.Serializable;

import org.apache.log4j.Logger;

//
import java.io.Serializable;
import javax.naming.OperationNotSupportedException;
import java.io.PrintWriter;
import java.io.IOException;
//


public class CommandFromWebWrapperTEMPLATE extends AbstractWrapper {

  	//remember only one field but you can add fields by yourself
  	private DataField[] collection = new DataField[] { new DataField("field1", "int", "field1") };

  	private final transient Logger logger = Logger.getLogger(MultiFormatWrapper.class);
  
  	private AddressBean params;

	private int counter;
	



  	public boolean initialize() {
    		setName("CommandFromWebWrapperTEMPLATE"+ counter++);
    
    		params = getActiveAddressBean();   
    
    		return true;
  	}
  	
  	
  	public void run() {
  
  	}


  	public DataField[] getOutputFormat() {
    		return collection;
  	}

  	
  	public String getWrapperName() {
    		return "CommandFromWebWrapperTEMPLATE";
  	}  


  	public void dispose() {
    		counter--;
  	}

  
	//remember is only an example use of this function  
  	public boolean sendToWrapper(String action, String[] paramNames, Object[] paramValues) throws OperationNotSupportedException {
		//could be necessary to catch the IOException
		
		//try {
				//debug stuff
				System.out.println("BEGIN SEND !!!");
				System.out.println(paramNames[0]);
				System.out.println(paramValues[0]);
				
				//get the updated field value from web interface
				String updatedFieldString= paramValues[0].toString();
				int updatedField= Integer.parseInt(updatedFieldString);
				
				//remember, the new field value will be sent to gsn --> NOT USEFUL
				postStreamElement(new Serializable[] { updatedField });  
				//is better to replace the latest command with a real send to sensors 
				//see /gsn/src/gsn/wrappers/tinyos/TinyOsWrapperTEMPLATE 
				
				System.out.println("END SEND !!!");
				
			
				return true;
		//} 
		//catch ( IOException e ) {
		//	logger.warn( "OutputStream write error. " , e );
		//	return false;
		//}
        }
  

}
  
