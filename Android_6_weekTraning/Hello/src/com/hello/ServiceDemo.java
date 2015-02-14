package com.hello;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceDemo extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "on create", 3000).show();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Toast.makeText(this, "on start", 3000).show();
	}

}
