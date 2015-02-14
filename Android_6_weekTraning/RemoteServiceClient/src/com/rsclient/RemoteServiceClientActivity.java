package com.rsclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.rservicedemo.MyAidl;

public class RemoteServiceClientActivity extends Activity {
	Button button,button2,button3;
	Intent intent;
	ServiceConnection serviceConnection;
	MyAidl myAidl;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);

		intent = new Intent();
		intent.setClassName("com.rservicedemo", "com.rservicedemo.MyService");

		serviceConnection = new  ServiceConnection() {

			public void onServiceDisconnected(ComponentName name) {

			}

			public void onServiceConnected(ComponentName name, IBinder service) {
				myAidl = MyAidl.Stub.asInterface(service);
			}
		};

		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				startService(intent);
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				bindService(intent, serviceConnection, BIND_AUTO_CREATE);
			}
		});

		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				try {
					int value = myAidl.getCount();
					Toast.makeText(RemoteServiceClientActivity.this, "Value "+value, 3000).show();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});

	}
}