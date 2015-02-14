package com.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceDemoActivity extends Activity {
	Button button,button2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(ServiceDemoActivity.this,
						MyService.class);
				startService(intent);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(ServiceDemoActivity.this,
						MyService.class);
				stopService(intent);
			}
		});
	}
}






