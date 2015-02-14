package com.example.activitylife;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	 
	 @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Intent i;
		setContentView(R.layout.activity_main);
		
	}
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
