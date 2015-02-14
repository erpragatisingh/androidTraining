package com.datapassdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String val1 = extras.getString("myKey");
		String val2 = extras.getString("myKey1");
		String val3 = extras.getString("myKey2");
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
	}

}
