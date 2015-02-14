package com.miracle.maps.demo;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MainActivity extends Activity {
	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

		LatLng latLng = new LatLng(28.654654, 77.346555);
		LatLng lat2 = new LatLng(53.551, 9.993);
		PolygonOptions rectOptions = new PolygonOptions()
        .add(new LatLng(37.35, -122.0),
             new LatLng(37.45, -122.0),
             new LatLng(37.45, -122.2),
             new LatLng(37.35, -122.2),
             new LatLng(37.35, -122.0));

//Get back the mutable Polygon
Polygon polygon = mMap.addPolygon(rectOptions);

mMap.addMarker(new MarkerOptions()
				.position(lat2)
				.title("Hiiiiii")
				.snippet("This is my location")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
		mMap.addMarker(new MarkerOptions()
				.position(latLng)
				.title("Hiiiiii")
				.snippet("This is my location")
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

		mMap.setMyLocationEnabled(true);
		
		// GoogleMapOptions options = new GoogleMapOptions();
		//
		// options.mapType(GoogleMap.MAP_TYPE_SATELLITE).compassEnabled(false).rotateGesturesEnabled(false).tiltGesturesEnabled(false);

	}

}
