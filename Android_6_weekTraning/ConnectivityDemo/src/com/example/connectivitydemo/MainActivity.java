package com.example.connectivitydemo;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView tv = (TextView) findViewById(R.id.resultText);
		WebView wv = (WebView) findViewById(R.id.webView1);
		
		ConnectivityManager conn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		
		boolean wifiStatus = conn.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
		//boolean btStatus = conn.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH).isConnected();
	//	boolean ethStatus = conn.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET).isConnected();
		boolean mnStatus = conn.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected();
		
		if (wifiStatus) {
			tv.setText("WiFi connected.");
			wv.loadUrl("http://www.google.com");
		}
//		else if (btStatus) {
//			tv.setText("WiFi not connected, Bluetooth connected.");
//			wv.setBackgroundResource(R.drawable.ic_launcher);
//		}
//		else if (ethStatus) {
//			tv.setText("WiFi not connected, Bluetooth not connected. Ethernet connected.");
//			wv.loadUrl("http://www.google.com");
//		}
		else if (mnStatus) {
			tv.setText("WiFi not connected, Bluetooth not connected, Ethernet not connected, Mobile network connected.");
			wv.loadUrl("http://www.google.com");
		}
		else {
			tv.setText("WiFi not connected, Bluetooth not connected, Ethernet not connected, Mobile network not connected.");

			wv.setBackgroundResource(R.drawable.ic_launcher);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
