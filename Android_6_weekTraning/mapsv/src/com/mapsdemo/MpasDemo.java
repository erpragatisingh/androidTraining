package com.mapsdemo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;

public class MpasDemo extends Activity {
	GoogleMap mMap;

  //  @SuppressLint({ "NewApi", "NewApi", "NewApi" })
	@SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi", "NewApi" })
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpas_demo);
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		.getMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
		mMap.setMyLocationEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_mpas_demo, menu);
        return true;
    }
}
