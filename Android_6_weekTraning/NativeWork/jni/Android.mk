LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_LDLIBS := -llog

LOCAL_MODULE := nativetest
LOCAL_SRC_FILES := native.c

include $(BUILD_SHARED_LIBRARY)
