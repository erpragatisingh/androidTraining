#include <string.h>
#include <jni.h>
#include <android/log.h>

#define DEBUG_TAG "NDK_AndroidNDKSampleActivity"


void Java_com_example_nativecode_NativeDemo__countToThree()
{
	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "Native Message: %s", "1...");

}
