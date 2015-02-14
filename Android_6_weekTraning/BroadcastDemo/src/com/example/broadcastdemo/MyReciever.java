package com.example.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle b= intent.getExtras();
		if(b != null){
			String str= b.getString(TelephonyManager.EXTRA_STATE);
			System.out.println(str);
			Toast.makeText(context, str, Toast.LENGTH_LONG).show();
			if(str.equals(TelephonyManager.EXTRA_STATE_RINGING) ){
			String str2= b.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
			System.out.println(str2);
			Toast.makeText(context, str2, Toast.LENGTH_LONG).show();
			}
		}
		
	}

}
