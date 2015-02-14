package com.faceboo;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.Facebook;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;

public class MainActivity extends Activity {
	 private static String APP_ID = "429106350519792";
	 private Facebook facebook;
	    private AsyncFacebookRunner mAsyncRunner;
	    String FILENAME = "AndroidSSO_data";
	    private SharedPreferences mPrefs;
	 
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	 
	        facebook = new Facebook(APP_ID);
	        mAsyncRunner = new AsyncFacebookRunner(facebook);
    }
}
