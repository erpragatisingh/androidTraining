LOCAL_PATH := $(call my-dir)
 
include $(CLEAR_VARS)
 
# Here we give our module name and source file(s)
LOCAL_MODULE    := NativeCode
LOCAL_SRC_FILES := NativeCode.c
 
include $(BUILD_SHARED_LIBRARY)

