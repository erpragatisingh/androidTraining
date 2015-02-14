package com.example.notificationmanger;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	int notifyId = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void onClick(View v) {
		displayNotification();

	}

	private void displayNotification() {
		// TODO Auto-generated method stub
		Intent i = new Intent(this, notify.class);
		i.putExtra("notification Id", notifyId);

		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);

		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		Notification notif = new Notification(R.drawable.ic_launcher,
				"Reminder: meeting starts in 2 mins",
				System.currentTimeMillis());

		CharSequence frm = "System Alarm";
		CharSequence msg = "Meet in 3 secs";
		notif.setLatestEventInfo(this, frm, msg, pi);
		notif.vibrate = new long[] { 100, 250, 100, 500 };
		nm.notify(notifyId, notif);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
