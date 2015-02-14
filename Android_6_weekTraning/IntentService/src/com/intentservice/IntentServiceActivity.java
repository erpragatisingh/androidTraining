package com.intentservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class IntentServiceActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startService(new Intent(this,MyIntentService.class));
        new Thread(){
        	public void run() {
        		try {
					Thread.sleep(5000);
					Toast.makeText(getApplicationContext(), "ABC", Toast.LENGTH_LONG).show();
					startService(new Intent(IntentServiceActivity.this,MyIntentService.class));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	};
        }.start();
    }
}