package com.example.nativecode;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;

public class NativeDemo extends Activity {

	 // declare the native code function - must match ndkfoo.c

	  private native void countToThree();
	  // load the library - name matches jni/Android.mk 
	  static {
	    System.loadLibrary("NativeCode");
	  }
	   
	 
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_native_demo);
	    //	countToThree();
	    }
	}