package com.mcq.test;

import java.util.ArrayList;
import java.util.HashMap;

import com.mcq.login.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SubmitTest extends Activity{
	
	Test_Activity activity=null;
	Context context=this;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.submit_test);
	       	activity = getIntent().getExtras().getParcelable("activity");
	        Button summary_btn=(Button) findViewById(R.id.summary_btn);
	        Button evaluate_btn=(Button) findViewById(R.id.evaluate_btn);
	        summary_btn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View arg0) {			
					 Intent i=new Intent(context,ViewSummary.class);
					i.putExtra("activity", activity);	
					 startActivity(i);					
				}
	        	
	        });
	        evaluate_btn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent i=new Intent(context,EvaluateTest.class);
					i.putExtra("activity", activity);			
					startActivity(i);					
				}
	        	
	        });
	        }

}
