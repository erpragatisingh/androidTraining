package com.mmm;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Mapss extends Activity {
	private GoogleMap mMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapss);

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


		mMap.setMyLocationEnabled(true);
		
		// GoogleMapOptions options = new GoogleMapOptions();
		//
		// options.mapType(GoogleMap.MAP_TYPE_SATELLITE).compassEnabled(false).rotateGesturesEnabled(false).tiltGesturesEnabled(false);

	}
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mapss, menu);
        return true;
    }
}
