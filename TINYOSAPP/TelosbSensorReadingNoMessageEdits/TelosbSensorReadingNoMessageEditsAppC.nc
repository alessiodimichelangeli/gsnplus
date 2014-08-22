/**
 * TelosbSensorReadingNoMessageEdits application. This app reads data from the on board sensors of Telosb mote.
 * This app does not allow the message editing.
 *
 * See README.txt file in this directory for usage instructions.
 *
 * @author Alessio Di Michelangeli
 */

configuration TelosbSensorReadingNoMessageEditsAppC { }

implementation {

  //classic operations components
  components  TelosbSensorReadingNoMessageEditsC, MainC, ActiveMessageC, LedsC,
              new TimerMilliC() as TimerSampling, 
              new TimerMilliC() as TimerLedRec,
              new TimerMilliC() as TimerWebCommandLed,
              new AMSenderC(AM_TELOSBSENSORREADINGNOMESSAGEEDITS);
              //new AMReceiverC(AM_TELOSBSENSORREADINGNOMESSAGEEDITS); 

  //sensors components
  components  new SensirionSht11C() as TempAndHumid,
              new HamamatsuS10871TsrC() as LigthSensor,  
              new HamamatsuS1087ParC() as Photosensor;
              //new Msp430InternalVoltageC() as InternalVoltage,
              //new Msp430InternalTemperatureC() as InternalTemperature;


  /***list of interfaces implemented in the TelosbSensorReadingC related file***/
  TelosbSensorReadingNoMessageEditsC.Boot -> MainC;
  TelosbSensorReadingNoMessageEditsC.RadioControl -> ActiveMessageC;
  TelosbSensorReadingNoMessageEditsC.AMSend -> AMSenderC;
  //TelosbSensorReadingCNoMessageEdits.Receive -> AMReceiverC;
  
  //we need three timers 
  TelosbSensorReadingNoMessageEditsC.TimerSampling -> TimerSampling;

  //we need to use led
  TelosbSensorReadingNoMessageEditsC.Leds -> LedsC;

  //we need to read temp, hum, lum and photo sensor
  TelosbSensorReadingNoMessageEditsC.TempRead -> TempAndHumid.Temperature;
  TelosbSensorReadingNoMessageEditsC.HumRead -> TempAndHumid.Humidity;
  TelosbSensorReadingNoMessageEditsC.LumRead -> LigthSensor;
  TelosbSensorReadingNoMessageEditsC.PhotoRead -> Photosensor;
  //TelosbSensorReadingNoMessageEditsC.Read -> InternalVoltage;
  //TelosbSensorReadingNoMessageEditsC.Read -> InternalTemperature;
  /******************************************************************************/
  
}