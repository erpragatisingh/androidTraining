package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class TakeMBTI extends Activity 
{
	/** Called when the activity is first created. */
	private WebView webview;
	TextView mtvTitle;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
		webview = (WebView) findViewById(R.id.myWebView);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		mtvTitle.setText("Take the MBTI");
		webview.getZoomControls();
		WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.loadUrl("file:///android_asset/MBTI.html");
           
    }
}