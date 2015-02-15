package com.devahead.androidwebviewcacheonsd;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener
{
	protected WebView webView;
	protected Button startSecondActivityBtn;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		webView = ((WebView)findViewById(R.id.webView));
		startSecondActivityBtn = ((Button)findViewById(R.id.startSecondActivityBtn));

		// Set the listener
		startSecondActivityBtn.setOnClickListener(this);
		
		// Initialize the WebView
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		webView.setScrollbarFadingEnabled(true);
		webView.getSettings().setLoadsImagesAutomatically(true);

		// Load the URLs inside the WebView, not in the external web browser
		webView.setWebViewClient(new WebViewClient());

		webView.loadUrl("http://www.google.com");
	}

	@Override
	protected void onDestroy()
	{
		// Clear the cache (this clears the WebViews cache for the entire application)
		webView.clearCache(true);
		
		super.onDestroy();
	}
	
	@Override
	public File getCacheDir()
	{
		// NOTE: this method is used in Android 2.1
		
		return getApplicationContext().getCacheDir();
	}

	@Override
	public void onClick(View v)
	{
		if (v == startSecondActivityBtn)
		{
			Intent intent = new Intent(this, SecondActivity.class);
			startActivity(intent);
		}
	}
}