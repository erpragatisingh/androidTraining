package com.example.toast;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         
    }

    public void myToast(View v) {
    	
    	Toast.makeText(getApplicationContext(),
    			"Welcome", Toast.LENGTH_LONG).show();
    	
		
	}
    
    
    public void mycalender(View v) {
    	
  Intent i=new Intent(MainActivity.this,MyCalender.class);  	
    	
    startActivity(i);	
    	
		
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
