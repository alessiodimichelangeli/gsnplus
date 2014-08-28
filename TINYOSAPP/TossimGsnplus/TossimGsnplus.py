#!/usr/bin/python

#
# FILE: 	/opt/tinyos-2.1.2/apps/TossimGsnplus/TossimGsnplus.py
#
# AUTHOR:	Alessio Di Michelangeli
#
# DESCRIPTION: 	A simple Python script to simulate the integration between TinyOs and the Gsn+ Server. 
# 		This script uses the TOSSIM LIVE extensions. 
#		Full instructions to correctly run this script are written on the official project wiki. 
#		Link: https://github.com/alessiodimichelangeli/gsnplus/wiki
#


import sys
import time

from TOSSIM import *
from TossimGsnplusMsg import *

t = Tossim([])
m = t.mac()
r = t.radio()
sf = SerialForwarder(9002)
throttle = Throttle(t, 10)

t.addChannel("Serial", sys.stdout);
t.addChannel("TossimGsnplusC", sys.stdout);

for i in range(0, 1):
  m = t.getNode(i);
  m.bootAtTime((31 + t.ticksPerSecond() / 10) * i + 1);

sf.process();
throttle.initialize();

while 1 :
  throttle.checkThrottle();
  t.runNextEvent();
  sf.process();

