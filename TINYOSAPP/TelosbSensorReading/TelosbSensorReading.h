// @author Alessio Di Michelangeli

#ifndef TELOSBSENSORREADING_H
#define TELOSBSENSORREADING_H

//#define TOSH_DATA_LENGTH 100
//#define TOSH_DATA_LENGTH 114
//#define TOSH_DATA_LENGTH 40

enum {
  /* Number of readings per message. If you increase this, you may have to
     increase the message_t size. */
  NREADINGS= 2,

  /* Default sampling period. */
  DEFAULT_INTERVAL = 6000,

  AM_TELOSBSENSORREADING = 0x93
};

typedef nx_struct telosbsensorreading {
  nx_uint16_t version; /* Version of the interval. */
  nx_uint16_t interval; /* Samping period. */	//THIS FIELD CAN BE MODIFIED VIA GSN SERVER
  nx_uint16_t id; /* Mote id of sending mote. */
  nx_uint16_t count; /* The readings are samples count * NREADINGS onwards. */
  
  nx_uint16_t webCommandLed; /* Command from web. */ //THIS FIELD IS MODIFIED ONLY VIA GSN SERVER
  
  nx_uint16_t readingsTemp[NREADINGS]; /* Array for temperature readings. */
  nx_uint16_t readingsHum[NREADINGS]; /* Array for humidity readings. */
  nx_uint16_t readingsLum[NREADINGS]; /* Array for luminance readings. */
  nx_uint16_t readingsPhoto[NREADINGS]; /* Array for photo readings. */
  
} telosbsensorreading_t; 

#endif
