README for TossimGsnPlus

**** AUTHOR: **** 

Alessio Di Michelangeli


**** DESCRIPTION: ****

TossimGsnplus is a simple app used to demonstrate the integration between TinyOs and the Gsn+ Server. 
More precisely the app simply count the messages sent from TinyOs to Gsn+. 
I also can send  a message back (from Gsn+ to TinyOs). 
This message will contain the new value whence restart the counter. 
A script will simulate this app via TOSSIM LIVE.


**** HOW TO COMPILE: **** 

You have to compile TossimGsnPlus with TOSSIM LIVE because you use this app
only to verify the integration between TinyOs and Gsn+ without having real motes.	

--> make micaz sim-sf


**** HOW TO SEE DATA FROM TELOSBREADINGSENSOR: ****

To test the integration, after compile, make sure that the script TossimGsnplus.py 
is set to executable (if is not you can simply set executable in the file 
properties/permissions accessible with right click).

Now, open a new terminal and go to the folder of the app:

--> cd /opt/tinyos-2.1.2/apps/TossimGsnplus/

Run the script TossimGsnplus.py:

--> ./TossimGsnplus.py

You can see that the script is sending packets to the Serial Forwarder.

While the script is running you have to open a new terminal and launch the GSN+ server.

If wasn't builded type:

--> ant build

To start GSN+ type:

--> ant start

At:
--> localhost:22001
you should see the gsn server so load the Tossim Virtual Sensor
and you will see the data from sensors. 

You can send a message from GSN+ to TinyOs using the Upload function.
In particular the message will contain the new counter.

N.B. To immediately show the changes is better to set the refresh time at 1 second.

To stop the test you have to close first the GSN+ (CTRL+C on the related terminal instance)
and second the SCRIPT (CTRL+C on the related terminal instance).




