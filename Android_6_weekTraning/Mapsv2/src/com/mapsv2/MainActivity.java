package com.mapsv2;

import java.util.List;

import javax.security.auth.PrivateCredentialPermission;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;


import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private GoogleMap mMap;
	Button button;
	EditText e1, e2, e4;
	double d1,d2;
	LatLng latlng;
	TextView t1;

  
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
		e1= (EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e4=(EditText)findViewById(R.id.editText3);
		t1=(TextView)findViewById(R.id.textView1);
	//	d1= Double.parseDouble(e1.getText().toString());
	//	d2= Double.parseDouble(e2.getText().toString());
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				getLatLong("sector 15 metro station,noida,india");
				}
		});
		
		mMap=((MapFragment)getFragmentManager().findFragmentById(R.id.frag)).getMap();
	    GoogleMapOptions options = new GoogleMapOptions();
		options.mapType(GoogleMap.MAP_TYPE_SATELLITE).compassEnabled(false).rotateGesturesEnabled(false).tiltGesturesEnabled(false);
		mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
	//	mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
		mMap.setMyLocationEnabled(true);
		
	}
		private void getLatLong(String address){
			try {
				Geocoder geocoder = new Geocoder(this);
				List<Address> fromLocationName = geocoder.getFromLocationName(address, 1);
				if (fromLocationName != null) {
					double latitude = fromLocationName.get(0).getLatitude();
					double longitude = fromLocationName.get(0).getLongitude();
					System.out.println("latitude is "+latitude +"   longitude is  "+longitude);
					latlng = new LatLng(latitude,longitude);
					String a1= String.valueOf(latitude);
					t1.setText(a1);
					mMap.addMarker(new MarkerOptions()
					.position(latlng)
					.title("Hiiiiii")
					.snippet("This is my location")
					.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	

