# GSN+ Global Sensor Networks

GSN+ is an extension of the [GSN](https://github.com/LSIR/gsn) project.
GSN+ makes easy to send a message/command from the web interface to the sensors, but the real goal of this project is to make available a two communication-ways between TinyOs and GSN.

More precisely this project provide:
- an easy way to upload data from the sensor to the gsn server with examples
- an easy way to connect a tinyos network with gsn with examples
- a simulated implementation with TOSSIM LIVE, basically you can test the integration between GSN+ and TinyOs without having the real sensors
- a real implementation with one/two telosb motes, as readers and one telosb mote, as base station that, through a serial forwarder, they send data to the gsn server. Of course is also possible to send data back to the telosb sensors (example change the interval value, play with the leds). 
There is also an alternative app very similar to the previous one.

For all of them there are templates and readme to easily understand how to build a new virtual sensor, a new wrapper and also a new tinyos based software for the sensors. 

Please, before use this project consider to play a little bit with the original GSN project and read its [gsn wiki](https://github.com/LSIR/gsn/wiki). 

## Installation and Online Documentation

You can find the GSN+ documentation, including a deployment, installation, and programming
guide, on the project [GSN+ WIKI](https://github.com/alessiodimichelangeli/gsnplus/wiki).

After the installation you can see the running server at: [http://localhost:22001](http://localhost:22001) .

## Easy way to test it

I created a virtual box machine to test GSN+. You can download instructions and the virtual machine at the following links:
- [Instructions](https://dl.dropboxusercontent.com/u/4915790/GSNPLUSvb/Instructions.pdf)
- [Virtual Machine](https://dl.dropboxusercontent.com/u/4915790/GSNPLUSvb/GSNPLUS%20clone.vdi.rar)

## Credits

Thanks to the original GSN Project.
See [https://github.com/LSIR/gsn/](https://github.com/LSIR/gsn/) .
