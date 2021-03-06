package com.rservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Button;

public class MyService extends Service { // stub

	int counter;
	Handler handler;

	@Override
	public IBinder onBind(Intent intent) {

		return stub;  //return that stub to the client when he demands for binding
	}

	MyAidl.Stub stub = new MyAidl.Stub() {   // helper method that was generated by android after saving .aidl file

		public int getCount() throws RemoteException {
			return counter;
		}

		
	};

	@Override
	public void onCreate() {
		super.onCreate();
		handler = new Handler();
		handler.postDelayed(new MyRunnable(), 1000);
	}

	class MyRunnable implements Runnable {

		public void run() {
			counter++;
			handler.postDelayed(this, 1000);
		}

	}

}
