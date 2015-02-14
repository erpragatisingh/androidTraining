package com.gcrgc;

import java.util.List;


import android.R.string;
import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GeoCodingAndReverseGeocodingDemoActivity extends Activity {
	Button button;
	TextView t1;
	EditText e1, e2, e4;
//	Double d1, d2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button1);
		t1=(TextView)findViewById(R.id.textView1);
		e1= (EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		
		
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				System.out.println("AAAA");
		//		d1= Double.parseDouble(e1.getText().toString());
		//		d2= Double.parseDouble(e2.getText().toString());
		//		System.out.println(d1);
		//		System.out.println(d2);
		//		String locationName = getLocationName(Double.parseDouble(e1.getText().toString()),Double.parseDouble(e2.getText().toString()));
			//	String locationName= getLocationName(28.570813, 77.326116);
		//		System.out.println("Location name is ========== "+locationName);
		//		t1.setText(locationName);
				getLatLong("sector 15 metro station,noida,india");
			}
		});
	}
	
	// geo coding
	private void getLatLong(String address){
		try {
			Geocoder geocoder = new Geocoder(this);
			List<Address> fromLocationName = geocoder.getFromLocationName(address, 1);
			if (fromLocationName != null) {
				double latitude = fromLocationName.get(0).getLatitude();
				double longitude = fromLocationName.get(0).getLongitude();
				System.out.println("latitude is "+latitude +"   longitude is  "+longitude);
				String a1= String.valueOf(latitude);
				t1.setText(a1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// reverse geo coding
	private String getLocationName(double mLat, double mLong) {
		String localityName = "";
		try {
			Geocoder geocoder = new Geocoder(this);
			List<Address> fromLocation = geocoder.getFromLocation(mLat, mLong,1);
			if (fromLocation != null) {
				localityName = fromLocation.get(0).getLocality()+"  "+fromLocation.get(0).getAddressLine(0)+"  "+fromLocation.get(0).getCountryCode()+"  "+fromLocation.get(0).getCountryName();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ABC");
		}
		return localityName;
	}

}