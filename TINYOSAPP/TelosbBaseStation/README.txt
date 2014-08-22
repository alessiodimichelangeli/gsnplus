README for TelosbBaseStation

**** AUTHOR: **** 

Alessio Di Michelangeli


**** DESCRIPTION: ****

TelosbBaseStation is an application that acts as a simple Active Message
bridge between the serial and radio links. It replaces the BaseStation
app tinyos bundle apps.

On the serial link, TelosbBaseStation sends and receives simple active
messages (not particular radio packets): on the radio link, it sends
radio active messages, whose format depends on the network stack being
used. BaseStation will copy its compiled-in group ID to messages
moving from the serial link to the radio, and will filter out incoming
radio messages that do not contain that group ID.

TelosbBaseStation includes queues in both directions, with a guarantee that
once a message enters a queue, it will eventually leave on the other
interface. The queues allow the BaseStation to handle load spikes more
gracefully.

BaseStation acknowledges a message arriving over the serial link only if
that message was successfully enqueued for delivery to the radio link.

(N.B. the following is the only different between 
 TelosBaseStation and BaseStation original version)
The LEDS are programmed to toggle as follows:
BLUE Toggle         - Message bridged from serial to radio
YELLOW Toggle       - Message bridged from radio to serial


When using a CC2420 radio, several default preprocessor configurations
are defined in the Makefile:
  * CC2420_NO_ACKNOWLEDGEMENTS
    - Prevents the base station from falsly acknowledging packets
  * CC2420_NO_ADDRESS_RECOGNITION
    - Allows the base station to sniff packets from any transmitter

Other combinations can be defined to meet your application's needs:
  * CC2420_NO_ADDRESS_RECOGNITION only
    - Sniff all packets, but acknowledge packets only if they
      are sent to the base station's address

  * Removing all preprocessor definitions in the Makefile
    - Only accept packets destined for the base station's address,
      and acknowledge those packets


**** HOW TO COMPILE: **** 

You can compile TelosbBaseStation with a telosb mote by compiling
as follows (from the TelosbBaseStation folder):	

--> make telosb

You can also install the app into the telosb mote. Do it as follow:
(from the TelosbBaseStation folder, with the telosb mote plugged)

--> motelist
(see under the device column, the device name i.e. /dev/ttyUSB0)
--> sudo chmod 666 /dev/ttyUSB0
--> make telosb reinstall bsl,/dev/ttyUSB0


**** HOW TO USE IT: ****

Please see the README of the TelosbSensorReading app.
