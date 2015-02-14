package com.example.custombroadcastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class CustomBroadcastDemo extends Activity {
	Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_broadcast_demo);
        button= (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			broad();	
			}

			public void broad() {
				// TODO Auto-generated method stub
				Intent i= new Intent("abcd");
				i.putExtra("name", "Miracle");
				sendBroadcast(i);
			}
		});
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	this.registerReceiver(brd, intentfilter);
    }
    IntentFilter intentfilter= new IntentFilter("abcd");
    
    BroadcastReceiver brd= new BroadcastReceiver(){
    	public void onReceive(Context context, Intent intent) {
    		
    		Bundle b= intent.getExtras();
    		String str= b.getString("name");
    		System.out.println(str);
    		Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    		
    	};
    };
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	this.unregisterReceiver(brd);
    	super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_custom_broadcast_demo, menu);
        return true;
    }
}
