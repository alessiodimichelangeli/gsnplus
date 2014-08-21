/**
*
* File: src/gsn/wrappers/ProvaWrapper.java
*
*/

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


public class ProvaWrapper extends AbstractWrapper {
  private DataField[] collection = new DataField[] { new DataField("campo", "double", "prova") };
  private final transient Logger logger = Logger.getLogger(MultiFormatWrapper.class);
  private int counter;
  private AddressBean params;
  private long rate = 1000;

  public boolean initialize() {
    setName("ProvaWrapper" + counter++);
    
    params = getActiveAddressBean();
    
    /*if ( params.getPredicateValue( "rate" ) != null ) {
      rate = (long) Integer.parseInt( params.getPredicateValue( "rate"));
      
      logger.info("Sampling rate set to " + params.getPredicateValue( "rate") + " msec.");
    }*/
    
    return true;
  }

  public void run() {
  
    Double campo=0.0;
    
    while (isActive()) {
      try {
        // delay 
        Thread.sleep(rate);
      } catch (InterruptedException e) {
        logger.error(e.getMessage(), e);
      }
      
      // create some random readings
      campo = ((int) (Math.random() * 10000)) / 10.0;

      // post the data to GSN
      postStreamElement(new Serializable[] { campo });       
    }
  }

  public DataField[] getOutputFormat() {
    return collection;
  }

  public String getWrapperName() {
    return "Prova Sample Wrapper";
  }  

  public void dispose() {
    counter--;
  }
  
  //esperimenti
  
  /*
  public boolean sendToWrapper ( Object dataItem ) throws OperationNotSupportedException {
		//if ( logger.isDebugEnabled( ) ) logger.debug( "Serial wrapper received a serial port sending..." );
		try {
				System.out.println("INIZIO TEST !!!");
				postStreamElement(new Serializable[] { 100 }); 
				PrintWriter pw = new PrintWriter( "campo" );
				pw.write( dataItem.toString( ) );
				pw.flush( );
				pw.close( );
				System.out.println("FINE test-test-test !!!");
				
			
			return true;
		} catch ( IOException e ) {
			logger.warn( "OutputStream write error. " , e );
			return false;
		}
  }*/
  
  
  public boolean sendToWrapper(String action, String[] paramNames, Object[] paramValues) throws OperationNotSupportedException {
		//try {
				System.out.println("INIZIO TEST !!!");
				 
				
				System.out.println(paramNames[0]);
				System.out.println(paramValues[0]);
				
				String updatedCampoString= paramValues[0].toString();
				Double updatedCampo= Double.parseDouble(updatedCampoString);
				
				
				postStreamElement(new Serializable[] { updatedCampo });  
				
				
				/*PrintWriter pw = new PrintWriter( "campo" );
				pw.write( dataItem.toString( ) );
				pw.flush( );
				pw.close( );*/
				System.out.println("FINE test-test-test !!!");
				
			
			return true;
		//} catch ( IOException e ) {
		//	logger.warn( "OutputStream write error. " , e );
		//	return false;
		//}
  }
  
  //fine esperimenti
  
  
  
  
}
