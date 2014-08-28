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

#include "TossimGsnplus.h"

configuration TossimGsnplusAppC { }

implementation {
  
  components TossimGsnplusC as App, LedsC, MainC;
  components SerialActiveMessageC as AM;
  components new TimerMilliC();

  App.Boot -> MainC.Boot;
  App.Control -> AM;
  App.Receive -> AM.Receive[AM_TOSSIM_GSNPLUS_MSG];
  App.AMSend -> AM.AMSend[AM_TOSSIM_GSNPLUS_MSG];
  App.Leds -> LedsC;
  App.MilliTimer -> TimerMilliC;
  App.Packet -> AM;

}


