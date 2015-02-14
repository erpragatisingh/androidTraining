package com.example.sensoractivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener{

	private SensorManager sensorManager;
	private TextView tv;
	private boolean color=false;
	private long lastupdate;
	Intent i=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView1);
        tv.setBackgroundColor(Color.GREEN);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        		,sensorManager.SENSOR_DELAY_NORMAL);
        lastupdate=System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
		{
			float[] values=event.values;
			float x=values[0];
			float y=values[1];
			float z=values[2];
			float accelationSquareRoot=(x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
			long actualTime=System.currentTimeMillis();
			if(accelationSquareRoot>=2)
			{
				if(actualTime-lastupdate<200)
				{
					return;
				}
				lastupdate=actualTime;
				Toast.makeText(this, "Device was shuffled", Toast.LENGTH_SHORT).show();
				if(color)
				{
					tv.setBackgroundColor(Color.GREEN);
					i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:09015373330"));
					startActivity(i);
				}
				else
				{
					tv.setBackgroundColor(Color.RED);
					i=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:0"));
					startActivity(i);
					
				}
				color=!color;
			}
		}
	}
    
}
