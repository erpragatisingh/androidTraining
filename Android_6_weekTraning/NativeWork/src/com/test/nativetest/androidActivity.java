package com.test.nativetest;

import com.test.nativetest.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class androidActivity extends Activity {
	Button b1, b2, b3, b4;
	
	private native void helloLog(String logThis);
	private native String getString(int value1, int value2);
	private native void countToThree();
	private native void countToO();
	
	static {
		System.loadLibrary("nativetest");
	}
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
      
    	
    	Toast.makeText(this, "Hello", 3000).show();
    	
        setContentView(R.layout.main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				countToThree();
			}
		});
 
 b2.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			  helloLog("Hello native world Button 2");
		}
	});
 
 b3.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String s = getString(3,2);
	    	Log.v("JAVA STRING", s);
		}
	});
 
 b4.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			  helloLog("Hello native world  Button4");
		}
	});
 
        
        
        
    }
}