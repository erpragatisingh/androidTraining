package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class SixteenTypesInfo extends Activity 
{
	/** Called when the activity is first created. */
	private int tempType= 0;
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
   //     tempType = savedInstanceState!=null ? savedInstanceState.getInt(Param.sixteen): 0;
		if(tempType==0)
		{
		//	tempType = extras !=null? extras.getInt(Param.sixteen) : null;
			tempType = extras.getInt(Param.sixteen);
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
        if(tempType==Param.ISTJ)
        {
        	mtvTitle.setText("ISTJ");
        	webview.loadUrl("file:///android_asset/16Types/ISTJ.html");
        }
        if(tempType==Param.ISFJ)
        {
        	mtvTitle.setText("ISFJ");
        	webview.loadUrl("file:///android_asset/16Types/ISFJ.html");
        }
        if(tempType==Param.INFJ)
        {
        	mtvTitle.setText("INFJ");
        	webview.loadUrl("file:///android_asset/16Types/INFJ.html");
        }
        if(tempType==Param.INTJ)
        {
        	mtvTitle.setText("INTJ");
        	webview.loadUrl("file:///android_asset/16Types/INTJ.html");
        }
        
        if(tempType==Param.ISTP)
        {
        	mtvTitle.setText("ISTP");
        	webview.loadUrl("file:///android_asset/16Types/ISTP.html");
        }
        if(tempType==Param.ISFP)
        {
        	mtvTitle.setText("ISFP");
        	webview.loadUrl("file:///android_asset/16Types/ISFP.html");
        }
        if(tempType==Param.INFP)
        {
        	mtvTitle.setText("INFP");
        	webview.loadUrl("file:///android_asset/16Types/INFP.html");
        }
        if(tempType==Param.INTP)
        {
        	mtvTitle.setText("INTP");
        	webview.loadUrl("file:///android_asset/16Types/INTP.html");
        }
        
        if(tempType==Param.ESTP)
        {
        	mtvTitle.setText("ESTP");
        	webview.loadUrl("file:///android_asset/16Types/ESTP.html");
        }
        if(tempType==Param.ESFP)
        {
        	mtvTitle.setText("ESFP");
        	webview.loadUrl("file:///android_asset/16Types/ESFP.html");
        }
        if(tempType==Param.ENFP)
        {
        	mtvTitle.setText("ENFP");
        	webview.loadUrl("file:///android_asset/16Types/ENFP.html");
        }
        if(tempType==Param.ENTP)
        {
        	mtvTitle.setText("ENTP");
        	webview.loadUrl("file:///android_asset/16Types/ENTP.html");
        }
        
        if(tempType==Param.ESTJ)
        {
        	mtvTitle.setText("ESTJ");
        	webview.loadUrl("file:///android_asset/16Types/ESTJ.html");
        }
        if(tempType==Param.ESFJ)
        {
        	mtvTitle.setText("ESFJ");
        	webview.loadUrl("file:///android_asset/16Types/ESFJ.html");
        }
        if(tempType==Param.ENFJ)
        {
        	mtvTitle.setText("ENFJ");
        	webview.loadUrl("file:///android_asset/16Types/ENFJ.html");
        }
        if(tempType==Param.ENTJ)
        {
        	mtvTitle.setText("ENTJ");
        	webview.loadUrl("file:///android_asset/16Types/ENTJ.html");
        }
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				
				finish();
				startActivity(new Intent(SixteenTypesInfo.this, Home.class));
				
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
        outState.putInt(Param.sixteen, tempType);
       
       
       
    }
}