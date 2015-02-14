package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MBTIPrayers extends Activity 
{
	/** Called when the activity is first created. */
	private WebView webview;
	TextView mtvTitle;
	Button mbtnBack;
	Button mbtnHome;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
		webview = (WebView) findViewById(R.id.myWebView);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
		
		mbtnBack.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
		mtvTitle.setText("Invocations");
		webview.setBackgroundColor(0);
		webview.getZoomControls();
		WebSettings settings = webview.getSettings();
		settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/MBTIPrayers.html");
           
    }
}