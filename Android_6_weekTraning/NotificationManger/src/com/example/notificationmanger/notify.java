package com.example.notificationmanger;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

public class notify extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notify);
	 NotificationManager nm= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	 nm.cancel(getIntent().getExtras().getInt("notification id"));
	
	
	}
}
