package com.example.brdrecieverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver{

	@Override
	public void onReceive(Context c, Intent i) {
		// TODO Auto-generated method stub
		System.out.println("ABCD");
		Toast.makeText(c, "Hello Broadcast", Toast.LENGTH_LONG).show();
	}

}
