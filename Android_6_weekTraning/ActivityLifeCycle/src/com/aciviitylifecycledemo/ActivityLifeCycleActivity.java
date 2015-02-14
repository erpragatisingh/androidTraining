package com.aciviitylifecycledemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityLifeCycleActivity extends Activity implements OnClickListener{
	Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();
    
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
}
    	
    @Override
    protected void onStart() {
    	super.onStart();
    	Toast.makeText(this, "onstart", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Toast.makeText(getApplicationContext(), "onresume", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    	//finish();
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onRestart() {
    	super.onRestart();
    	Toast.makeText(getBaseContext(), "onRestart", Toast.LENGTH_SHORT).show();
    }

	public void onClick(View v) {
		Intent  intent = new Intent(this,SecondActivity.class);
		Toast.makeText(getBaseContext(), "hello", Toast.LENGTH_SHORT).show();
		startActivity(intent);
	}
}