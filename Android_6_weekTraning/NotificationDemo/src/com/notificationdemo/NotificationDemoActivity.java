package com.notificationdemo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationDemoActivity extends Activity {
	Button button;
	NotificationManager manager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				getNotification();
			}
		});
	}

	private void getNotification(){
		Notification notification = new Notification(R.drawable.icon, "Hi from notification", System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 111, new Intent(this,SecondActivity.class), 0);
		notification.setLatestEventInfo(this, "Welcome!!!", "This is text from notification", pendingIntent);
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		manager.notify(100, notification);
	}

}












