package com.example.handlerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private Handler handler;
	private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress=(ProgressBar)findViewById(R.id.progressBar1);
        handler=new Handler();
        
    }
    
    
    public void startProgress(View view)
    {
    	Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<=10;i++)
				{
					final int value=i;
					try
					{
						Thread.sleep(2000);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					handler.post(new Runnable()
					{
						public void run()
						{
							progress.setProgress(value);
							
						}
					});
					
				}
				Intent i=new Intent(MainActivity.this,Second.class);
				startActivity(i);
			}
		};
		new Thread(runnable).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
