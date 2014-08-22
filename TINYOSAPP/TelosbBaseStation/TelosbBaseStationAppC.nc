/**
 * TelosbBaseStation application. This app sends and receives simple active messages (not particular radio packets).
 *
 * See README.txt file in this directory for usage instructions.
 *
 * @author Alessio Di Michelangeli
 */


configuration TelosbBaseStationAppC { }

implementation {

  components MainC, TelosbBaseStationC, LedsC;
  components ActiveMessageC as Radio, SerialActiveMessageC as Serial;
  components new TimerMilliC() as TimerLedRec;
  
  MainC.Boot <- TelosbBaseStationC;

  TelosbBaseStationC.RadioControl -> Radio;
  TelosbBaseStationC.SerialControl -> Serial;
  
  TelosbBaseStationC.UartSend -> Serial;
  TelosbBaseStationC.UartReceive -> Serial.Receive;
  TelosbBaseStationC.UartPacket -> Serial;
  TelosbBaseStationC.UartAMPacket -> Serial;
  
  TelosbBaseStationC.RadioSend -> Radio;
  TelosbBaseStationC.RadioReceive -> Radio.Receive;
  TelosbBaseStationC.RadioSnoop -> Radio.Snoop;
  TelosbBaseStationC.RadioPacket -> Radio;
  TelosbBaseStationC.RadioAMPacket -> Radio;
  
  TelosbBaseStationC.Leds -> LedsC;

  TelosbBaseStationC.TimerLedRec -> TimerLedRec;

}