package jap.duc.proto;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class BrowserTwo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browsertwo);
		WebView w=(WebView)findViewById(R.id.web2);
        w.loadUrl("http://www.facebook.com");
	}
}
