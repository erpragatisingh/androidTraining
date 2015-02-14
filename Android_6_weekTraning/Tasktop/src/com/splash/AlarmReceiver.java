package com.splash;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.provider.Contacts.People;
import android.provider.SyncStateContract.Helpers;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{
	private static final int NOTIFY_ME_ID=133;
    private int count=0;
    private NotificationManager notifyMgr=null;
	 

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		//Toast.makeText(arg0, "Alarm received!", 5000).show();
		
		notifyMgr=(NotificationManager)arg0.getSystemService(Context.NOTIFICATION_SERVICE);
		LayoutInflater mInflater = LayoutInflater.from(arg0);
		View layout = mInflater.inflate(R.layout.custom_toast, null);
				// set a dummy image
				ImageView image = (ImageView) layout.findViewById(R.id.image);
				image.setImageResource(R.drawable.info_button);

				// set a message
				TextView text = (TextView) layout.findViewById(R.id.text);
				text.setText("Alarm is recieved");

				// Toast...
				Toast toast = new Toast(arg0);
				toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
				toast.setDuration(Toast.LENGTH_LONG);
				toast.setView(layout);
				toast.show();
				 Notification notifyObj=new Notification(R.drawable.info_button,
                         "Alarm is Recieved",
                         System.currentTimeMillis());
			
				 PendingIntent contentIntent = PendingIntent.getActivity(arg0, 
						 NOTIFY_ME_ID, 
						 new Intent(arg0, NotifyActivity.class), 0);
				 
				 notifyObj.setLatestEventInfo(arg0, "New Alarm is Detected",
                         "Click to see the details", contentIntent);
 notifyObj.number=++count;
 notifyObj.defaults |= Notification.DEFAULT_VIBRATE;
 notifyObj.defaults |= Notification.DEFAULT_SOUND;
				 notifyMgr.notify(NOTIFY_ME_ID, notifyObj);
				 Toast.makeText(arg0, "jijjjjjjjjjjj", 3000).show();

	
		 Vibrator vibrator = (Vibrator) arg0.getSystemService(Context.VIBRATOR_SERVICE);
		    vibrator.vibrate(2000);
	}

	
}
