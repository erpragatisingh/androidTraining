package com.sensor.demo;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class AcceleratometerSensorDemoActivity extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
	long lastUpdatedTime;
	View view;
	private boolean color = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
		lastUpdatedTime = System.currentTimeMillis();
		view = findViewById(R.id.view);
		view.setBackgroundColor(Color.RED);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);
	}
	

	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}
	public void onSensorChanged(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			getAccEvent(event);
		}
	}

	private void getAccEvent(SensorEvent event){
		float[] values = event.values;
		float x = values[0];
		float y = values[1];
		float z = values[2];
		float sqrt = (x*x+y*y+z*z)/(SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
		long timeNow = System.currentTimeMillis();
		if (sqrt >= 2) {
			if (timeNow - lastUpdatedTime < 200) {
				return;
			}	
			lastUpdatedTime = timeNow;
			if (color) {
				view.setBackgroundColor(Color.GREEN);
			} else {
				view.setBackgroundColor(Color.RED);
			}
			color = !color;
		}
	}
}







