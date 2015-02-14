package com.example.attendancemaster;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewttMenu extends Activity {

	Button b1,b2,b3,b4,b5,b6,back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewttmenu);
		b1=(Button)findViewById(R.id.viewmon);
		b2=(Button)findViewById(R.id.viewtues);
		b3=(Button)findViewById(R.id.viewwed);
		b4=(Button)findViewById(R.id.viewthurs);
		b5=(Button)findViewById(R.id.viewfri);
		b6=(Button)findViewById(R.id.viewsat);
		back=(Button)findViewById(R.id.back3);
		
		String fontpath="fonts/JOKERMAN.TTF";
        Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
        b1.setTypeface(tf);
        b2.setTypeface(tf);
        b3.setTypeface(tf);
        b4.setTypeface(tf);
        b5.setTypeface(tf);
        b6.setTypeface(tf);
        
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
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
		
		b6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
