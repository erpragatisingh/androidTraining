package com.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyIntentService extends IntentService {
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public MyIntentService() {
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		System.out.println("=========== service start =========");
		Toast.makeText(getApplicationContext(), "service start", Toast.LENGTH_LONG).show();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=========== going to stop ==========");
		Toast.makeText(getApplicationContext(), "service stop", Toast.LENGTH_LONG).show();
//		stopSelf();
	}

}
