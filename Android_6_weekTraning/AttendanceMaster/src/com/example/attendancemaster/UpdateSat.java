package com.example.attendancemaster;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateSat extends Activity{

	TextView t1,t2,t3,t4,t5,t6,t7,t8;
	EditText e1,e2,e3,e4,e5,e6,e7,e8;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updatesat);
		t1=(TextView)findViewById(R.id.ulec111);
		t2=(TextView)findViewById(R.id.ulec222);
		t3=(TextView)findViewById(R.id.ulec333);
		t4=(TextView)findViewById(R.id.ulec444);
		t5=(TextView)findViewById(R.id.ulec555);
		t6=(TextView)findViewById(R.id.ulec666);
		t7=(TextView)findViewById(R.id.ulec777);
		t8=(TextView)findViewById(R.id.ulec888);
		
		e1=(EditText)findViewById(R.id.ueditLec111);
		e2=(EditText)findViewById(R.id.ueditLec222);
		e3=(EditText)findViewById(R.id.ueditLec333);
		e4=(EditText)findViewById(R.id.ueditLec444);
		e5=(EditText)findViewById(R.id.ueditLec555);
		e6=(EditText)findViewById(R.id.ueditLec666);
		e7=(EditText)findViewById(R.id.ueditLec777);
		e8=(EditText)findViewById(R.id.ueditLec888);
		b=(Button)findViewById(R.id.usubc111);
		
		String fontpath="fonts/BRADHITC.TTF";
        Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
        e1.setTypeface(tf);
        e2.setTypeface(tf);
        e3.setTypeface(tf);
        e4.setTypeface(tf);
        e5.setTypeface(tf);
        e6.setTypeface(tf);
        e7.setTypeface(tf);
        e8.setTypeface(tf);
        
        
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
