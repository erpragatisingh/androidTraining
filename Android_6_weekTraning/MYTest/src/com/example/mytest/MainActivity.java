package com.example.mytest;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void Mytoast(View p) {
		
	Toast.makeText(getApplicationContext(), "This is My Toast", 0).show();	
		
		
	}
	
	 
@Override
public void onBackPressed() {
	// TODO Auto-generated method stub
	
	Toast.makeText(getApplicationContext(), "onBackPressed", 0).show();
	 //super.onBackPressed();
}
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	
	switch (keyCode) {
	case KeyEvent.KEYCODE_VOLUME_DOWN:
		Toast.makeText(getApplicationContext(), "VOLUME_DOWN", 0).show();
		break;

	default:
		break;
	}
	
	
	
	
	// TODO Auto-generated method stub
	return super.onKeyDown(keyCode, event);
	
	
}
}
