package com.example.services;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Services extends Activity {
	Button b1, b2, b3;
	Intent i;
	ServiceConnection conn;
	MyInterface inter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        i = new Intent(Services.this, MyService.class);
        conn= new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// TODO Auto-generated method stub
				inter= (MyInterface)service;
			}
		};
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startService(i);
			}
		});
       b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bindService(i, conn, BIND_AUTO_CREATE );
		}
	});
       b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int returnValue= inter.getCount();
			System.out.println(returnValue);
			Toast.makeText(Services.this, "return "+returnValue, Toast.LENGTH_LONG).show();
			
		}
	});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_services, menu);
        return true;
    }
}
