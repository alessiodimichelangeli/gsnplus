/**
*
* File: src/gsn/wrappers/WebInputWrapper.java
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


public class WebInputWrapper extends AbstractWrapper {
  private DataField[] collection = new DataField[] { new DataField("switcher", "int", "switcher") };
  private final transient Logger logger = Logger.getLogger(MultiFormatWrapper.class);
  private int counter;
  private AddressBean params;
  private long rate = 100000; 


  public boolean initialize() {
    setName("WebInputWrapper" + counter++);
    
    params = getActiveAddressBean();
    
    /*if ( params.getPredicateValue( "rate" ) != null ) {
      rate = (long) Integer.parseInt( params.getPredicateValue( "rate"));
      
      logger.info("Sampling rate set to " + params.getPredicateValue( "rate") + " msec.");
    }*/
    
    
    
    return true;
  }

  public void run() {
  
    //Double field1=0.0;
    //params = getActiveAddressBean();
    
    //Double field1=0.0;
    
    //if ( params.getPredicateValue( "field1" ) != null ) {
      //int field1 = Integer.parseInt( params.getPredicateValue( "field1") );  
    //}
    
    int switcher=0;
    
    while (isActive()) {
      try {
        // delay 
        Thread.sleep(rate);
      } catch (InterruptedException e) {
        logger.error(e.getMessage(), e);
      }
      
      
   
      
      
      	// create some random readings
      	//field = ((int) (Math.random() * 10000)) / 10.0;

      	// post the data to GSN
      	postStreamElement(new Serializable[] { switcher });  
      
     
      
          
    }
  }

  public DataField[] getOutputFormat() {
    return collection;
  }

  public String getWrapperName() {
    return "WebInput Sample Wrapper";
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
				PrintWriter pw = new PrintWriter( "field1" );
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
				System.out.println("BEGIN TEST !!!");
				 
				
				System.out.println(paramNames[0]);
				System.out.println(paramValues[0]);
				
				String updatedSwitcherString= paramValues[0].toString();
				int updatedSwitcher= Integer.parseInt(updatedSwitcherString);
				
				
				postStreamElement(new Serializable[] { updatedSwitcher });  
				
				
				/*PrintWriter pw = new PrintWriter( "switcher" );
				pw.write( dataItem.toString( ) );
				pw.flush( );
				pw.close( );*/
				System.out.println("END TEST !!!");
				
			
			return true;
		//} catch ( IOException e ) {
		//	logger.warn( "OutputStream write error. " , e );
		//	return false;
		//}
  }
  
  //fine esperimenti
  
  }
  
