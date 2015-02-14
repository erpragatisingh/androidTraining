package com.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloActivity extends Activity {
	
	Intent i;
	int x=20;
	double y=20.0;
	long[] a1={3,4,5};
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.button1);
        i=new Intent(HelloActivity.this,ServiceDemo.class);
        String s1= (x<15)?"small":(x<20)?"tiny":"huge";
        System.out.println(s1);
        if(x== y){
        System.out.println("true");}
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startService(i);
				stopService(i);
				
			}
		});
        
    }
}