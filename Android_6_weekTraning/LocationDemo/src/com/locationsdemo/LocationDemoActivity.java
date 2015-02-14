package com.locationsdemo;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LocationDemoActivity extends Activity implements LocationListener {
	LocationManager locationManager;
	TextView t1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		t1=(TextView)findViewById(R.id.text);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, this);
	}

	public void onLocationChanged(Location location) {
		double latitude = location.getLatitude();
		double longitude = location.getLongitude();
		double altitude = location.getAltitude();
		float speed = location.getSpeed();
		long time = location.getTime();
		float accuracy = location.getAccuracy();
		String finalresult = new Double(latitude).toString();
	t1.setText(finalresult);
	
		System.out.println("latitude  "+latitude);
		System.out.println("longitude  "+longitude);
	}

	public void onProviderDisabled(String provider) {
		
	}

	public void onProviderEnabled(String provider) {
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		
	}
}