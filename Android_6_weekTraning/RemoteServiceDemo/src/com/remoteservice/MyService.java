package com.remoteservice;



import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
	int count = 0;
	Handler handler;
	private static boolean flag = true;

	@Override
	public IBinder onBind(Intent intent) {
		//Toast.makeText(getApplicationContext(), "onBind1", 3000).show();
		return new MyBinder();
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "oncreate", 3000).show();
//		Thread  thread = new Thread();
//		thread.start();
		
	/*	Thread thread = new Thread() {
			public void run() {
				
				while (flag) {
					count++;
					try {
						Thread.sleep(1000);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		thread.start();
	*/
		
		handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				count++;
				handler.postDelayed(this, 3000);
			}
		}, 1000);
		}

	

	

	class MyBinder extends Binder implements MyInterface {

		public int getCount1() {
			
			return count;
		}

	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Toast.makeText(getApplicationContext(), "onstart", 3000).show();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "onDestroy", 3000).show();
	}

}
