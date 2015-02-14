package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;

public class MyService extends Service {
	int count=0;
	Boolean b1= true;
	

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				count++;
				new Handler().postDelayed(this, 1000);
				
			}
		}, 30000);
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	class MyBinder extends Binder implements MyInterface{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return count;
		}
		
	}
}
