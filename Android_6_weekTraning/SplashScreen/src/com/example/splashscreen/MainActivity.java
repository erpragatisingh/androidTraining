package com.example.splashscreen;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ii=(ImageView)findViewById(R.id.imageView1);
        TimerTask tt=new TimerTask()
        {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,Second.class);
				startActivity(i);
			}
        	
        };
        Timer t=new Timer();
        t.schedule(tt, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
