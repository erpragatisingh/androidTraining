package com.checknetworkconnection;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

public class CheckNetworkConnectionActivity extends Activity {
	private NetworkInfo networkInfo;
	private ConnectivityManager manager;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
			manager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
			networkInfo = manager.getActiveNetworkInfo();
			if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
				Toast.makeText(this, networkInfo.getTypeName(), Toast.LENGTH_LONG).show();
			} else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
				Toast.makeText(this, networkInfo.getTypeName(), Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, "No network exist", Toast.LENGTH_LONG).show();
		}
    }
}