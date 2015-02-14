package com.presentiagroup.PersonalityCoach;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class FourTemperInfo extends Activity 
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
        tempType = savedInstanceState!=null ? savedInstanceState.getInt(Param.temp): 0;
		if(tempType==0)
		{
			tempType = extras !=null? extras.getInt(Param.temp) : null;
		}
		
		webview = (WebView) findViewById(R.id.myWebView);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		webview.setBackgroundColor(0);
		webview.getZoomControls();
		WebSettings settings = webview.getSettings();
		settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        mtvTitle.setTextSize(22);	
        if(tempType==Param.NT)
        {
        	mtvTitle.setText("NT");
        	webview.loadUrl("file:///android_asset/4Temper/NT.html");
        }
        if(tempType==Param.NF)
        {
        	mtvTitle.setText("NF");
        	webview.loadUrl("file:///android_asset/4Temper/NF.html");
        }
        if(tempType==Param.SP)
        {
        	mtvTitle.setText("SP");
        	webview.loadUrl("file:///android_asset/4Temper/SP.html");
        }
        if(tempType==Param.SJ)
        {
        	mtvTitle.setText("SJ");
        	webview.loadUrl("file:///android_asset/4Temper/SJ.html");
        }
        if(tempType==Param.TempOverview)
        {
        	mtvTitle.setText("Temp Overview");
        	webview.loadUrl("file:///android_asset/4Temper/Tempoverview.html");
        }
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(FourTemperInfo.this, Home.class));
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
        outState.putInt(Param.temp, tempType);
       
       
       
    }
}