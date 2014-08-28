COMPONENT=TossimGsnplusAppC
BUILD_EXTRA_DEPS += TossimGsnplus.class

CLEAN_EXTRA = *.class TossimGsnplusMsg.java

CFLAGS += -I$(TOSDIR)/lib/T2Hack

TossimGsnplus.class: $(wildcard *.java) TossimGsnplusMsg.java
	javac -target 1.4 -source 1.4 *.java

TossimGsnplusMsg.java:
	mig java -target=null $(CFLAGS) -java-classname=TossimGsnplusMsg TossimGsnplus.h tossim_gsnplus_msg -o $@


include $(MAKERULES)

