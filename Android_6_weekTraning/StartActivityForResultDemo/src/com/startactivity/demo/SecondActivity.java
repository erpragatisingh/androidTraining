package com.startactivity.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		Intent intent = new Intent();
		intent.putExtra("mydata", "hello from B");
		intent.putExtra("mydata2", "Hello User");
		setResult(200, intent);
	}

}
