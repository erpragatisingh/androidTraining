package com.example.sensorusingorientation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements SensorEventListener {

	Float azimut;
	public class CustomDrawableView extends View
	{
		Paint paint=new Paint();
		public CustomDrawableView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			paint.setColor(0xff00ff00);
			paint.setStyle(Style.STROKE);
			paint.setStrokeWidth(2);
			paint.setAntiAlias(true);
		}

		
	protected void onDraw(Canvas canvas)
	{
		int width=getWidth();
		int height=getHeight();
		int centerx=width/2;
		int centery=height/2;
		canvas.drawLine(centerx, 0, centerx, height, paint);
		canvas.drawLine(0, centery, width, centery, paint);
		if(azimut!=null)
		{
		canvas.rotate(-azimut*360/(2*3.141597f),centerx,centery);	
		}
		paint.setColor(0xff000ff);
		canvas.drawLine(centerx, -1000, centerx, +1000, paint);
		canvas.drawText("N", centerx+5, centery-10, paint);
		canvas.drawText("S", centerx-10, centery+5, paint);
		paint.setColor(0xff00ff00);
		
		
	}
  }
	
	CustomDrawableView mCustomDrawableView;
	private SensorManager mSensorManager;
	Sensor accelerometer;
	Sensor magnetometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCustomDrawableView=new CustomDrawableView(this);
        setContentView(R.layout.activity_main);
        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer=mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }
    
    protected void onResume()
    {
    	super.onResume();
    	mSensorManager.registerListener(this, accelerometer,SensorManager.SENSOR_DELAY_UI);
    	mSensorManager.registerListener(this, magnetometer,SensorManager.SENSOR_DELAY_UI);
    }
    
    protected void onPause()
    {
    	super.onPause();
    	mSensorManager.unregisterListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public void onAccuracyChanged(Sensor senser, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	float[] mGravity;
	float[] mGeomagnetic;

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
			mGravity=event.values;
		if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD)
			mGeomagnetic=event.values;
		if(mGravity!=null&&mGeomagnetic!=null)
		{
			float R[]=new float[9];
			float I[]=new float[9];
			boolean success=SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
			if(success)
			{
				float orientation[]=new float[3];
				SensorManager.getOrientation(R, orientation);
				azimut=orientation[0];
				
			}
		}
		mCustomDrawableView.invalidate();
	}
    
}
