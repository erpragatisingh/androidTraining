package com.remoteservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class RemoteServiceDemoActivity extends Activity {
	Button button, button2, button3;
	Intent intent;
	ServiceConnection connection;
	MyInterface myInterface;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);

		intent = new Intent(this, MyService.class);

		connection = new ServiceConnection() {

			public void onServiceDisconnected(ComponentName name) {

			}

			public void onServiceConnected(ComponentName name, IBinder service) {
				myInterface = (MyInterface)service;
			}
		};

		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				startService(intent);
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				bindService(intent, connection, BIND_AUTO_CREATE);
			}
		});
		
		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				int returnValue = myInterface.getCount1();
				Toast.makeText(getApplicationContext(), "Value : "+returnValue, Toast.LENGTH_SHORT).show();
				System.out.println(returnValue);
			}
		});
	}
}


