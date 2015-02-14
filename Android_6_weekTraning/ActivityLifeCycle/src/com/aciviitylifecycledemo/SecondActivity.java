package com.aciviitylifecycledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends Activity{
	Button b1, b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "kkkkkkk- create start resume", 3000).show();
				Intent i;
				i=  new Intent(getApplication(), ActivityLifeCycleActivity.class);
				startActivity(i);
				
				
			}
		});
b2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "kkkkkkooooooooookk", 3000).show();
				Intent intent = new Intent(Intent.ACTION_MAIN);
			    intent.addCategory(Intent.CATEGORY_HOME);
			 //   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			    startActivity(intent);
				
			}
		});
	}
	
}
