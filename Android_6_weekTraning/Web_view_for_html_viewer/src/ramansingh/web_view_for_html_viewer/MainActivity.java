package ramansingh.web_view_for_html_viewer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		WebView wv= (WebView) findViewById(R.id.webView1);
		wv.getSettings().setBuiltInZoomControls(true);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.loadUrl("file:url)"
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
