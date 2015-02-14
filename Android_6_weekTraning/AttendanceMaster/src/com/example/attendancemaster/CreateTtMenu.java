package com.example.attendancemaster;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CreateTtMenu extends Activity{

	Button a,b,c;
	TextView p,q,r;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createmenu);
		a=(Button)findViewById(R.id.addtt);
		b=(Button)findViewById(R.id.updatett);
		c=(Button)findViewById(R.id.deltt);
		p=(TextView)findViewById(R.id.textView1);
		q=(TextView)findViewById(R.id.textView2);
		r=(TextView)findViewById(R.id.textView3);
		
		String fontpath="fonts/GOUDYSTO.TTF";
        Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
        p.setTypeface(tf);
        q.setTypeface(tf);
        r.setTypeface(tf);
        
        a.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(CreateTtMenu.this,AddTimeTable.class);
				startActivity(i);
			}
		});
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(CreateTtMenu.this,UpdateTimeTable.class);
				startActivity(i);
			}
		});
        
        c.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
