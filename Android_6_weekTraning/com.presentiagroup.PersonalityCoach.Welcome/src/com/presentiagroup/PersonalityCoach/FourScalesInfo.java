package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class FourScalesInfo extends Activity 
{
	/** Called when the activity is first created. */
	private int tempType;
	private WebView webview;
	TextView mtvTitle;
	Button mbtnBack;
	Button mbtnHome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
       
		
        Bundle extras = getIntent().getExtras();
        tempType = savedInstanceState!=null ? savedInstanceState.getInt(Param.scale): 0;
		if(tempType==0)
		{
			tempType = extras !=null? extras.getInt(Param.scale) : null;
		}
		setContentView(R.layout.webview);
		webview = (WebView) findViewById(R.id.myWebView);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		
		webview.setBackgroundColor(0);
		webview.getZoomControls();
		WebSettings settings = webview.getSettings();
		settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
       // webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        
        if(tempType==Param.EI)
        {
        	mtvTitle.setText("Extraversion - Introversion");
        	
        	webview.loadUrl("file:///android_asset/4Scales/EI.html");
        }
        if(tempType==Param.SN)
        {
        	mtvTitle.setText("Sensing - iNtuition");
        	webview.loadUrl("file:///android_asset/4Scales/SN.html");
        }
        if(tempType==Param.TF)
        {
        	mtvTitle.setText("Thinking - Feeling");
        	webview.loadUrl("file:///android_asset/4Scales/TF.html");
        }
        if(tempType==Param.JP)
        {
        	mtvTitle.setText("Judging - Perceiving");
        	webview.loadUrl("file:///android_asset/4Scales/JP.html");
        }
        mtvTitle.setTextSize(19);		
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(FourScalesInfo.this, Home.class));
			}
		});
		
		mbtnBack.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) 
	{
        super.onSaveInstanceState(outState);
        outState.putInt(Param.scale, tempType);
       
       
       
    }
}