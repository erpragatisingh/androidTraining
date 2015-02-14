package com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

	
	
	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(this, "onBind()", Toast.LENGTH_LONG).show();
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
	}
	
	
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
