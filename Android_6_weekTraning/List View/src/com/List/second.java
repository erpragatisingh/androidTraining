package com.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class second extends Activity{
	String s;
	Long l;
	TextView t1;
	
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.second);
	        t1= (TextView)findViewById(R.id.textView1);
	        Intent intent = getIntent();
	        s = intent.getStringExtra("name78");
	        int a2= intent.getIntExtra("pass", 0);
	        	
	        	t1.setText(String.valueOf(a2));
			//l = Long.parseLong(s);
	       // t1.setText(s);
	        
	 }

}
