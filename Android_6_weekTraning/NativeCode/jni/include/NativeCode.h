> javah --help
......
// Change directory to <project-root>/jni/include
> javah -classpath ../../bin/classes;<ANDROID_SDK_HOME>\platforms\android-<xx>\android.jar
  -o NativeCode.h com.example.nativecode.NativeDemo
