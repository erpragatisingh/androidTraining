package com.example.clivckaad;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
 String tag="Activity_life";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 
		
		Log.d(tag, "onCreate() called ");
		
		setContentView(R.layout.activity_main);
		Button bt=(Button) findViewById(R.id.button1);
		Button test=(Button) findViewById(R.id.button2);
		 EditText ed=(EditText) findViewById(R.id.textView1);
	
		 
		
		
		
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	Intent i=new Intent(MainActivity.this,Msecond.class);
	
	startActivity(i);
				
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
			Log.d(tag, "onStart() called ");
		}
	@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
			Log.d(tag, "onPause() called ");
		}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(tag, "onDestroy() called ");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(tag, "onRestart() called ");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(tag, "onResume() called ");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(tag, "onStop() called ");
	}
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
		
		 switch (keyCode) {
		case KeyEvent.KEYCODE_VOLUME_UP:
			Toast.makeText(getApplicationContext(),
					"You have pressed VOLUME_UP", 1).show();
			break;

		default:
			Toast.makeText(getApplicationContext(),
					"You have pressed other button", 1).show();
			break;
		}
		 
		
			return super.onKeyDown(keyCode, event);
		}
	
	@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
		
		Toast.makeText(getApplicationContext(), "Key onBackPressed pressed", 1).show();
		
			 super.onBackPressed();
		}
	
	
	
}
