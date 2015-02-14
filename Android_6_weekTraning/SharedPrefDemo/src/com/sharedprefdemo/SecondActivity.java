package com.sharedprefdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends Activity{
	SharedPreferences sharedPreferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sharedPreferences = getSharedPreferences("pref1", MODE_PRIVATE);
		String name = sharedPreferences.getString("name", "");
		String password = sharedPreferences.getString("password", "");
		Toast.makeText(this, "Welcome Name : "+name+"  "+"Password : "+password, Toast.LENGTH_LONG).show();
	}
	
}
