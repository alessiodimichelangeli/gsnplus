/**
*
* File: src/gsn/wrappers/CommandFromWebWrapper.java
*
* Author: Alessio Di Michelangeli
*
*/

//THIS WRAPPER IS A SIMPLE COMMANDFROMWEB WRAPPER.


/********************************************	README	********************************************

Please remember, in this wrapper there is only one variable (switcher) in the DataField collection.
It will be shown that you can send a command from gsn to the related wrapper sensors via 
sendToWrapper function. In this template the command is simply: change the value of the 
field. In a real scenario this is not very useful. 
A good implementation of this function is send a message back to the sensor 
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


public class CommandFromWebWrapper extends AbstractWrapper {
  	
  	private DataField[] collection = new DataField[] { new DataField("switcher", "int", "switcher") };
  	
  	private final transient Logger logger = Logger.getLogger(MultiFormatWrapper.class);
  	
  	private int counter;
  	
  	private AddressBean params;

	private int switcher=0;


  	public boolean initialize() {
    		setName("CommandFromWebWrapper" + counter++);
    
    		params = getActiveAddressBean();
       
    		return true;
  	}

  
  	
  	public void run() {

			while (isActive()) {
      			try {
        			// delay 
        			Thread.sleep(100);
      			} catch (InterruptedException e) {
        			logger.error(e.getMessage(), e);
      			}

				// post the data to GSN
      			if (switcher==0){
      				postStreamElement(new Serializable[] { switcher });
      			}       
				    
    		}
    

    }
  

  	public DataField[] getOutputFormat() {
    		return collection;
  	}

  
  	public String getWrapperName() {
    		return "CommandFromWebWrapper";
  	}  

  	
  	public void dispose() {
    		counter--;
  	}
  
  	
  	//remember is only an example use of this function 
  	public boolean sendToWrapper(String action, String[] paramNames, Object[] paramValues) throws OperationNotSupportedException {
		
				System.out.println("BEGIN SEND !!!");
				System.out.println(paramNames[0]);
				System.out.println(paramValues[0]);
				
				String updatedSwitcherString= paramValues[0].toString();
				
				switcher= Integer.parseInt(updatedSwitcherString);				

				postStreamElement(new Serializable[] { switcher });
				
				System.out.println("END SEND !!!");
				
			
				return true;
		
  	}
  
 
}
