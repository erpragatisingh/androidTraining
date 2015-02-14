package com.intentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Second extends Activity{
	TextView t1, t2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		t1=(TextView)findViewById(R.id.textView1);
		t2=(TextView)findViewById(R.id.textView2);
		Bundle b= getIntent().getExtras();
		String a1= b.getString("name");
		String a2= b.getString("Pass");
		t1.setText(a1);
		t2.setText(a2);
	}
	
}
