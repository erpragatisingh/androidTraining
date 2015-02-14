package com.mymaps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;

@TargetApi(11)
public class MainActivity extends Activity {
	GoogleMap mMap;
	

   
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
		.getMap();

mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
