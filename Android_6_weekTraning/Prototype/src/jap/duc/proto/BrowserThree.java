package jap.duc.proto;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class BrowserThree extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browserthree);
		WebView w=(WebView)findViewById(R.id.web3);
        w.loadUrl("http://www.youtube.com");
	}
}
