package com.presentiagroup.PersonalityCoach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MoreInfo extends Activity 
{
	 /** Called when the activity is first created. */
	private int tempType;
	private WebView webview;
	TextView mtvTitle;
	Button mbtnBack;
	Button mbtnHome;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        
        Bundle extras = getIntent().getExtras();
        tempType = savedInstanceState!=null ? savedInstanceState.getInt(Param.more): 0;
		if(tempType==0)
		{
			tempType = extras !=null? extras.getInt(Param.more) : null;
		}
		
		webview = (WebView) findViewById(R.id.myWebView);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		webview.setBackgroundColor(0);
		webview.getZoomControls();
		
		WebSettings settings = webview.getSettings();
		settings.setBuiltInZoomControls(true);
		settings.setJavaScriptEnabled(true);
		
        if(tempType==Param.presentia)
        {
        	mtvTitle.setText("Finland Labs");
        	webview.loadUrl("file:///android_asset/Presentia.html");
        }
        if(tempType==Param.oka)
        {
        	mtvTitle.setText("Developer");
        	webview.loadUrl("file:///android_asset/OKA.html");
        	
        	
        }
        if(tempType==Param.mbti)
        {
        	mtvTitle.setText("About Application");
        	mtvTitle.setTextSize(16);
        	webview.loadUrl("file:///android_asset/MBTI.html");
        }
       
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(MoreInfo.this, Home.class));
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
		
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) 
	{
        super.onSaveInstanceState(outState);
        outState.putInt(Param.more, tempType);
       
       
       
    }
    

}