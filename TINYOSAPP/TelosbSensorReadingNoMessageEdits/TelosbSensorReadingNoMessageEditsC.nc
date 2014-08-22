/**
 * TelosbSensorReadingNoMessageEdits application. This app reads data from the on board sensors of Telosb mote. 
 * This app does not allow the message editing.
 *
 * See README.txt file in this directory.
 *
 * @author Alessio Di Michelangeli
 */


#include "Timer.h"
#include "TelosbSensorReadingNoMessageEdits.h"


//module declaration
module TelosbSensorReadingNoMessageEditsC @safe() {

  uses {
      interface Boot;
      interface SplitControl as RadioControl;
      interface AMSend;

      interface Timer<TMilli> as TimerSampling;

      interface Leds;

      interface Read<uint16_t> as TempRead;
      interface Read<uint16_t> as HumRead;
      interface Read<uint16_t> as LumRead;
      interface Read<uint16_t> as PhotoRead;

  }
 
}
//

//core part
implementation {
  
  message_t sendBuf;
  bool sendBusy;

  /* Current local state - interval, version and accumulated readings */
  telosbsensorreadingnomessageedits_t local;

  uint8_t readingTemp; /* 0 to NREADINGS */
  uint8_t readingHum; /* 0 to NREADINGS */
  uint8_t readingLum; /* 0 to NREADINGS */
  uint8_t readingPhoto; /* 0 to NREADINGS */

  
  uint16_t centigrade;
  uint16_t humidity;
  uint16_t luminance;
  uint16_t photo;
  
  

  /* When we head an TelosbSensorReadingNoMessageEdits message, we check it's sample count. If
     it's ahead of ours, we "jump" forwards (set our count to the received
     count). However, we must then suppress our next count increment. This
     is a very simple form of "time" synchronization (for an abstract
     notion of time). */

  bool suppressCountChange;

  // Use LEDs to report various status issues.
  void report_problem() { call Leds.led0Toggle(); }//N.B. this is used only in test phase otherwise,
                                                   //the red led is used to simulate a command from web
  void report_sent() { call Leds.led1Toggle(); }
  //

  //boot the mote
  event void Boot.booted() {
      local.interval = DEFAULT_INTERVAL;
      local.id = TOS_NODE_ID;
      if (call RadioControl.start() != SUCCESS)
        report_problem();
  }

  /**************** START/STOP TIMER ****************/
  //start the readings
  void startTimerSampling() {
      call TimerSampling.startPeriodic(local.interval / 2);
      readingTemp = 0;
      readingHum = 0;
      readingLum = 0;
      readingPhoto= 0;
  }

  /****************************************************/


  /**************** START/STOP RADIO CONTROL ****************/
  //when the radio starts, start the sampling
  event void RadioControl.startDone(error_t error) {
      startTimerSampling();
  }


  event void RadioControl.stopDone(error_t error) {

  }
  /**********************************************************/



  /* At each sample period:
     - if local sample buffer is full, send accumulated samples
     - read next sample
  */


  /**************** TIMERS FIRED ****************/
  event void TimerSampling.fired() {
          //if all the sensors have read all the values then reset the reading counters  
          if ((readingTemp == NREADINGS) && (readingHum == NREADINGS) && (readingLum == NREADINGS) && (readingPhoto == NREADINGS)) {
	           if (!sendBusy && sizeof local <= call AMSend.maxPayloadLength()) {
	               // Don't need to check for null because we've already checked length
	               // above
	               memcpy(call AMSend.getPayload(&sendBuf, sizeof(local)), &local, sizeof local);
	           
                 if (call AMSend.send(AM_BROADCAST_ADDR, &sendBuf, sizeof local) == SUCCESS)
	                   sendBusy = TRUE;
	           
             }
	     
             if (!sendBusy)
	               report_problem();

	           readingTemp = 0;
             readingHum = 0;
             readingLum = 0;
	           readingPhoto = 0;

            /* Part 2 of cheap "time sync": increment our count if we didn't
	           jump ahead. */
	     
            if (!suppressCountChange)
	             local.count++;
	         
            suppressCountChange = FALSE;
        }
    

          //debugging stuff
          if (call TempRead.read() != SUCCESS)
              report_problem();

          if (call HumRead.read() != SUCCESS)
              report_problem();

          if (call LumRead.read() != SUCCESS)
              report_problem();

          if (call PhotoRead.read() != SUCCESS)
              report_problem();

  }
  /*********************************************/


  /**************** SEND DONE/READ DONE ****************/

  //have sent the message
  event void AMSend.sendDone(message_t* msg, error_t error) {
      if (error == SUCCESS)
          report_sent();
      else
          report_problem();

      sendBusy = FALSE;
  }


  //temp read
  event void TempRead.readDone(error_t result, uint16_t data) {
      if (result != SUCCESS) {
          data = 0xffff;
          report_problem();
      }
    
      //if i have to complete the NREADINGS
      if (readingTemp < NREADINGS){
          centigrade= -39.60 + 0.01 * data; 
          local.readingsTemp[readingTemp++] = centigrade;
      }
  }

  //hum read
  event void HumRead.readDone(error_t result, uint16_t data) {
      if (result != SUCCESS) {
          data = 0xffff;
          report_problem();
      }
      
      //if i have to complete the NREADINGS
      if (readingHum < NREADINGS) {
          humidity= (-4.0 +0.0405*(data))+(-0.0000028*pow(data,2.0));
          local.readingsHum[readingHum++] = humidity;
      }
  }

  //lum read
  event void LumRead.readDone(error_t result, uint16_t data) {
      if (result != SUCCESS) {
          data = 0xffff;
          report_problem();
      }
      
      //if i have to complete the NREADINGS
      if (readingLum < NREADINGS) {
          luminance= (2.5 * (data / 4096.0) * 6250.0);
          local.readingsLum[readingLum++] = luminance;
      }
  }

  //photo read
  event void PhotoRead.readDone(error_t result, uint16_t data) {
      if (result != SUCCESS) {
          data = 0xffff;
          report_problem();
      }
      
      //if i have to complete the NREADINGS
      if (readingPhoto < NREADINGS) {
          photo= data;
          local.readingsPhoto[readingPhoto++] = data; 
      }
  }
  /**********************************************************/



}
