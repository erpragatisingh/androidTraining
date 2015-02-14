package ramansingh.wifi;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv= (TextView) findViewById(R.id.textView1);

		ConnectivityManager cin_wifi=
				(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		boolean wifi=
				cin_wifi.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();
		if(wifi){
			
			tv.setText("Wifi is ConnectedOrConnecting");
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
