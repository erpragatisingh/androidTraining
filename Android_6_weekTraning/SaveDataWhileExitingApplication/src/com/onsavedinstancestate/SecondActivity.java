package com.onsavedinstancestate;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends Activity{
	Calendar startTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		    startTime = Calendar.getInstance();
		  
		  Log.v("TAG", "Inside of onCreate");
		          
		       // timeTV = (TextView) findViewById(R.id.time_tv);
		  
		        if ((savedInstanceState != null)
		                && (savedInstanceState.getSerializable("starttime") != null)) {
		            startTime = (Calendar) savedInstanceState
		                   .getSerializable("starttime");
		            
		            
		            
		            
		        }
		
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.v("TAG", "Inside of onRestoreInstanceState");
	    startTime = (Calendar) savedInstanceState.getSerializable("starttime");
	}
	
}
