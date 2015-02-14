package ramansingh.map_current_location;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import android.os.Bundle;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
	GoogleMap gm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		// showing status
		if (status != ConnectionResult.SUCCESS) {
			// google play services are not available
			int requestCode = 10;
			Dialog d = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);
			d.show();

		} else {
			// google play services are available
			SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map);
			gm = fm.getMap();
			gm.setMyLocationEnabled(true);
			//gm.setTrafficEnabled(true);
			//gm.setIndoorEnabled(true);

		}

	}
}
