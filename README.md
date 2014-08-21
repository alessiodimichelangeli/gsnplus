# GSN+ Global Sensor Networks

GSN+ is an extension of the [GSN](https://github.com/LSIR/gsn) project.
GSN+ makes easy to send a message/command from the web interface to the sensors, but the real goal of this project is to make available a two communication-ways between TinyOs and GSN.

## Online Documentation

You can find the GSN+ documentation, including a deployment, installation, and programming
guide, on the project [wiki](https://github.com/mysite).
This README file only contains basic setup instructions.

## Building

First download the code from the git repository:

	git clone git@github.com:LSIR/gsn.git

GSN requires the following software for building:

* Jakarta apache ant version 1.7.x or higher.
* Java JDK 1.6.x .

To build GSN follow these steps:
* Add ANT_HOME/bin folder to your PATH
* Execute ant with the build task:
	``ant build``

To run GSN from the source code, you can run the following ant task:
	``ant gsn``

To stop GSN:
	``ant stop``

## Loading your first virtual sensor



