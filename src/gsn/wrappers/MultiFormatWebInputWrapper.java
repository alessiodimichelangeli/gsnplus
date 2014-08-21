/*
* File: src/gsn/wrappers/tinyos/MultiFormatWebInputWrapper.java
*
* author Alessio Di Michelangeli
*
*/

//THIS WRAPPER IS A MULTIFORMATWRAPPER + POSSIBILITY TO EDIT VIA WEB THE PACKET TYPE.


/********************************************	README	********************************************

This wrapper presents a MultiFormat protocol in which the data comes from the
system clock. Think about a sensor network which produces packets with
several different formats. In this example we have 3 different packets
produced by three different types of sensors. Here are the packet structures: 
[temperature:double] , 
[light:double] , 
[temperature:double, light:double]
 
The first packet is for sensors which can only measure temperature while the
latter is for the sensors equipped with both temperature and light sensors.

Well:
- if packet type=1 --> we will return temperature
- if packet type=2 --> we will return light
- if packet type=3 --> we will return temperarure and light

Remember it is possible to switch the packet type via web interface.

****************************************************************************************************/

package gsn.wrappers;

import gsn.beans.AddressBean;
import gsn.beans.DataField;
import java.io.Serializable;
import org.apache.log4j.Logger;

//
import javax.naming.OperationNotSupportedException;
//


public class MultiFormatWebInputWrapper extends AbstractWrapper {
  	
  	private DataField[] collection = new DataField[] { new DataField("packet_type", "int", "packet type"),
      new DataField("temperature", "double", "Presents the temperature sensor."), new DataField("light", "double", "Presents the light sensor.") };
  	
  	private final transient Logger logger = Logger.getLogger(MultiFormatWrapper.class);
  	
  	private int counter;
  	
  	private AddressBean params;
  	
  	private long rate= 1000;
  	
  	//we assume at the beginning that packet type is 1, of course could be changed via web interface
  	private int packet_type= 1;

  	
  	
  	
  	public boolean initialize() {
    		setName("MultiFormatwebInputWrapper" + counter++);
    
    		params = getActiveAddressBean();
    
    		if ( params.getPredicateValue( "rate" ) != null ) {
      			rate = (long) Integer.parseInt( params.getPredicateValue( "rate"));
      
      			logger.info("Sampling rate set to " + params.getPredicateValue( "rate") + " msec.");
    		}
    
    		return true;
  	}

 	
 	//in this function there is also a simulation data
 	public void run() {
    		Double light = 0.0, temperature = 0.0;
    
    		while (isActive()) {
      			try {
        			// delay 
        			Thread.sleep(rate);
      			} 
      			catch (InterruptedException e) {
        			logger.error(e.getMessage(), e);
      			}
      
      		
      			// create some random readings
      			light = ((int) (Math.random() * 10000)) / 10.0;
      			temperature = ((int) (Math.random() * 1000)) / 10.0;
      		

      			// post the data to GSN
      			if (packet_type==1){
      				postStreamElement(new Serializable[] { packet_type, temperature, null });
      			}       
      			if (packet_type==2){
      				postStreamElement(new Serializable[] { packet_type, null, light });
      			}
      			if (packet_type==3){
      				postStreamElement(new Serializable[] { packet_type, temperature, light });
      			}
      			
    		}
  	}


  	public DataField[] getOutputFormat() {
    		return collection;
  	}


  	public String getWrapperName() {
    		return "MultiFormatWebInputWrapper";
  	}  


  	public void dispose() {
    		counter--;
  	}
  	
  	
  	public boolean sendToWrapper(String action, String[] paramNames, Object[] paramValues) throws OperationNotSupportedException {
		
				System.out.println("BEGIN SEND !!!");
				System.out.print(paramNames[0]+ "= ");
				System.out.println(paramValues[0]);
				
				String updatedPacketTypeString= paramValues[0].toString();
				int updatedPacketType= Integer.parseInt(updatedPacketTypeString);
				
				//is not necessary to send a message over an interface because i only have to change a local value
				//in this example
				packet_type= updatedPacketType;
				
				System.out.println("NEW PACKET TYE= "+packet_type);
				System.out.println("END SEND !!!");
				
			
				return true;
		
  	}

}
