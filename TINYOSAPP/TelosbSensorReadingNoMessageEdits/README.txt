README for TelosbSensorReadingNoMessageEdits 

**** AUTHOR: **** 

Alessio Di Michelangeli


**** DESCRIPTION: ****

TelosbSensorReadingNoMessageEdits is a simple sensors-collection app.
It periodically samples the default sensors (temperature, humidity, luminance and photo) 
and broadcasts a message over the radio every 2 readings, for each sensor.
These readings can be received by a TelosbBaseStation mote and displayed, for example, 
by GSN+ Server.    


**** HOW TO COMPILE: **** 

You can compile TelosbSensorReadingNoMessageEdits with a telosb mote by compiling
as follows (from the TelosbSensorReadingNoMessageEdits folder):	

--> make telosb

You can also install the app into the telosb mote. Do it as follow:
(from the TelosbSensorReading folder, with the telosb mote plugged)

--> motelist
(see under the device column, the device name i.e. /dev/ttyUSB0)
--> sudo chmod 666 /dev/ttyUSB0
--> make telosb reinstall bsl,/dev/ttyUSB0

Please note, if you want to assign an id to the mote you have to use 
this command, insted of the last one:
--> make telosb install,<id number>
(ATTENTION: no space after the comma)


**** HOW TO SEE DATA FROM TELOSBREADINGSENSORNOMESSAGEEDITS: ****

N.B. Before starting, of course you have to have:
       (1) a running telosb mote (not plugged into your pc, so with batteries), 
	   previously compiled as shown in the previous readme point.
       (2) a gsn virtual sensor in the folder gsn/virtual-sensors that is setted to dispaly data from tinyos
	   Please see how to make a virtual sensor like this, opening the tinyos virtual sensor template 
	   in the folder gsn/virtual-sensors/TinyOsTEMPLATE.

To display the readings from TelosbSensorReadingNoMessageEdits motes, 
install the TelosbBaseStation app on a mote connected to your PC's serial port.
(see the related README.txt of that app)

Then, run the following command to generate the message:
--> mig -target=null -java-classname=TelosbSensorReadingNoMessageEditsMsg java TelosbSensorReadingNoMessageEdits.h telosbsensorreadingnomessageedits -o > TelosbSensorReadingNoMessageEditsMsg.java
You have to edit the generated file putting the string:
--> package gsn.wrappers.tinyos;
on top of it.

After, copy this file and paste it into the gsn/src/gsn/wrappers/tinyos/ folder and compile the gsn server like this:
(from the gsn folder)
--> ant build

It's almost finish :D 
Please run the serial forwarder application from another instance of your terminal:
--> java net.tinyos.sf.SerialForwarder -comm serial@/dev/ttyUSB0:telosb
(remember the mote with the TelosbBaseStation app plugged into)

You should see the packets sent, packets received flow.

Finally from the gsn folder (via terminal) run the gsn server:
--> ant gsn

At:
--> localhost:22001
you should see the gsn server so load the TelosbSensorReadingNoMessageEdits Virtual Sensor
and you will see the data from sensors. 
If you made a virtual sensor by yourself, having edited the tinyos template (2), load this one.
 
