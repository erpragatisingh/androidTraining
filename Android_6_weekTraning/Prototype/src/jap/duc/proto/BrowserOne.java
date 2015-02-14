package jap.duc.proto;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class BrowserOne extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browserone);
		WebView w=(WebView)findViewById(R.id.webView1);
        w.loadUrl("http://www.google.co.in");
	}

}
