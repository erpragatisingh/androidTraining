package com.brdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		Bundle extras = intent.getExtras();
		if (extras != null) {
			String state = extras.getString(TelephonyManager.EXTRA_STATE);
			System.out.println("State is : "+state);
			Toast.makeText(context, state, Toast.LENGTH_LONG).show();
			if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
				String number = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				System.out.println("Incoming number is : "+number);
				Toast.makeText(context, state+""+number, Toast.LENGTH_LONG).show();
				
			}
		}
	}
}