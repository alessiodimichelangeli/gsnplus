/**
 * TelosbSensorReading application. This app reads data from the on board sensors of Telosb mote.
 *
 * See README.txt file in this directory for usage instructions.
 *
 * @author Alessio Di Michelangeli
 */

configuration TelosbSensorReadingAppC { }

implementation {

  //classic operations components
  components  TelosbSensorReadingC, MainC, ActiveMessageC, LedsC,
              new TimerMilliC() as TimerSampling, 
              new TimerMilliC() as TimerLedRec,
              new TimerMilliC() as TimerWebCommandLed,
              new AMSenderC(AM_TELOSBSENSORREADING), 
              new AMReceiverC(AM_TELOSBSENSORREADING); 

  //sensors components
  components  new SensirionSht11C() as TempAndHumid,
              new HamamatsuS10871TsrC() as LigthSensor,  
              new HamamatsuS1087ParC() as Photosensor;
              //new Msp430InternalVoltageC() as InternalVoltage,
              //new Msp430InternalTemperatureC() as InternalTemperature;


  /***list of interfaces implemented in the TelosbSensorReadingC related file***/
  TelosbSensorReadingC.Boot -> MainC;
  TelosbSensorReadingC.RadioControl -> ActiveMessageC;
  TelosbSensorReadingC.AMSend -> AMSenderC;
  TelosbSensorReadingC.Receive -> AMReceiverC;
  
  //we need three timers 
  TelosbSensorReadingC.TimerSampling -> TimerSampling;
  TelosbSensorReadingC.TimerLedRec -> TimerLedRec;
  TelosbSensorReadingC.TimerWebCommandLed -> TimerWebCommandLed;

  //we need to use led
  TelosbSensorReadingC.Leds -> LedsC;

  //we need to read temp, hum, lum and photo sensor
  TelosbSensorReadingC.TempRead -> TempAndHumid.Temperature;
  TelosbSensorReadingC.HumRead -> TempAndHumid.Humidity;
  TelosbSensorReadingC.LumRead -> LigthSensor;
  TelosbSensorReadingC.PhotoRead -> Photosensor;
  //TelosbSensorReadingC.Read -> InternalVoltage;
  //TelosbSensorReadingC.Read -> InternalTemperature;
  /******************************************************************************/
  
}