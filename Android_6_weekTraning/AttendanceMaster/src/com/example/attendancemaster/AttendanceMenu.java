package com.example.attendancemaster;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
//import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AttendanceMenu extends Activity{

	Button b1,b2,b3,b4,b5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.attendancemenu);
		b1=(Button)findViewById(R.id.set);
		b2=(Button)findViewById(R.id.view);
		b3=(Button)findViewById(R.id.mark);
		b4=(Button)findViewById(R.id.check);
		b5=(Button)findViewById(R.id.backone);
		String fontpath="fonts/BRADHITC.TTF";
        Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
        b1.setTypeface(tf);
        b2.setTypeface(tf);
        b3.setTypeface(tf);
        b4.setTypeface(tf);
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(AttendanceMenu.this,CreateTtMenu.class);
				startActivity(i);
			}
		});
        
       b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
       
       b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
       
       b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
       
       b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        
	}
}
