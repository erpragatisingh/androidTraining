#include <jni.h>
#include <string.h>
#include <android/log.h>

#define DEBUG_TAG "NDK_AndroidNDKSampleActivity"

void Java_com_test_nativetest_androidActivity_helloLog(JNIEnv * env, jobject this, jstring logThis)
{
    jboolean isCopy;
    const char * szLogThis = (*env)->GetStringUTFChars(env, logThis, &isCopy);

    __android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "Native Message: %s", szLogThis);

    (*env)->ReleaseStringUTFChars(env, logThis, szLogThis);
}

jstring Java_com_test_nativetest_androidActivity_getString(JNIEnv * env, jobject this, jint value1, jint value2)
{
    char *szFormat = "The sum of the two numbers is: %i";
    char *szResult;

    // add the two values
    jlong sum = value1+value2;

    // malloc room for the resulting string
    szResult = malloc(sizeof(szFormat) + 20);

    // standard sprintf
    sprintf(szResult, szFormat, sum);

    // get an object string
    jstring result = (*env)->NewStringUTF(env, szResult);

    // cleanup
    free(szResult);

    return result;
}

void Java_com_test_nativetest_androidActivity_countToThree()
{
	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "Native Message: %s", "1...");
	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "Native Message: %s", "2...");
	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "Native Message: %s", "3!!");
}

void Java_com_test_nativetest_androidActivity_countToO()
{
	__android_log_print(ANDROID_LOG_DEBUG, DEBUG_TAG, "Button2");

}
