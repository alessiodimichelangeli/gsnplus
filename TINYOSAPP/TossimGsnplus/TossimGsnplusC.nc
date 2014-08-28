/**
 * TossimGsnplus application. 
 * 
 * This is a simple app used to demonstrate the integration between TinyOs and the Gsn+ Server. 
 * More precisely the app simply count the messages sent from TinyOs to Gsn+. 
 * I also can send  a message back (from Gsn+ to TinyOs). 
 * This message will contain the new value whence restart the counter. 
 * A script will simulate this app via TOSSIM LIVE.
 *
 * See README.txt file in this directory.
 *
 * @author Alessio Di Michelangeli
 */


#include "Timer.h"
#include "TossimGsnplus.h"

//module declaration
module TossimGsnplusC {
	
	uses {
    	interface SplitControl as Control;
    	interface Leds;
    	interface Boot;
    	interface Receive;
    	interface AMSend;
    	interface Timer<TMilli> as MilliTimer;
    	interface Packet;
  	}
}
//

//core part
implementation {

	//variables
	message_t packet;

  	bool locked = FALSE;
  	
  	uint16_t counter = 0; //main variable
  	//

  	//boot the mote
  	event void Boot.booted() {
    	call Control.start();
  	}
  
  	
  	//when the timer is over
  	event void MilliTimer.fired() {
    	
    	counter++; //counter= counter+1
    	
    	if (locked) {
      		return;
    	}
    	else {
      		tossim_gsnplus_msg_t* rcm = (tossim_gsnplus_msg_t*)call Packet.getPayload(&packet, sizeof(tossim_gsnplus_msg_t));
      		
      		if (rcm == NULL) {
      			return;
      		}
      		
      		if (call Packet.maxPayloadLength() < sizeof(tossim_gsnplus_msg_t)) {
				return;
      		}

      		rcm->counter = counter;
      		
      		if (call AMSend.send(AM_BROADCAST_ADDR, &packet, sizeof(tossim_gsnplus_msg_t)) == SUCCESS) {
				locked = TRUE;
      		}
    	}
  	}

  	
  	//when a message is received
  	event message_t* Receive.receive(message_t* bufPtr, void* payload, uint8_t len) {
    
  		counter=1;

    	if (len != sizeof(tossim_gsnplus_msg_t)) {
    		return bufPtr;
    	}
    	else {
      		tossim_gsnplus_msg_t* rcm = (tossim_gsnplus_msg_t*)payload;

      		counter= rcm->counter;  //set the local counter as the message received counter variable 

      		counter= counter-1;  //because of the counter++ instruction at the first line of MilliTimer.fired()

      		return bufPtr;
    	}
  	}


  	//have sent the message
  	event void AMSend.sendDone(message_t* bufPtr, error_t error) {
    	if (&packet == bufPtr) {
      		locked = FALSE;
    	}
  	}


  	//when the radio starts, start the sampling
  	event void Control.startDone(error_t err) {
    	if (err == SUCCESS) {
      		call MilliTimer.startPeriodic(4000);  //send a message to the SF every 4s
    	}
  	}
  

  	//when the radio stops
  	event void Control.stopDone(error_t err) {}


}




