
#ifndef TOSSIM_GSNPLUS_H
#define TOSSIM_GSNPLUS_H

typedef nx_struct tossim_gsnplus_msg {
  nx_uint16_t counter;
} tossim_gsnplus_msg_t;

enum {
  AM_TOSSIM_GSNPLUS_MSG = 0x89,
};

#endif
