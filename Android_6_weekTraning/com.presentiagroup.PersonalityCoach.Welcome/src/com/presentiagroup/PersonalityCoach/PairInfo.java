package com.presentiagroup.PersonalityCoach;



import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class PairInfo extends Activity 
{
	/** Called when the activity is first created. */
	
	private WebView webview1,webview2,webview3,webview4;
	TextView mtvTitle;
	Button mbtnBack;
	Button mbtnHome;
	Button mbtnOk;
	ArrayList<String> pair = new ArrayList<String>();
	String firsttype,secondtype; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pairwebview);
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnOk = (Button)findViewById(R.id.btnOk);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		
		Bundle extras = getIntent().getExtras();
		firsttype = extras !=null? extras.getString("firsttype") : "ENTP";
		secondtype = extras !=null? extras.getString("secondtype") : "ENTP";
		mtvTitle.setText(firsttype+" Connected to "+secondtype);
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
			public void onClick(View v) {
				
				finish();
			}
		});
		mbtnOk.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				
				finish();
			}
		});      
		webview1 = (WebView) findViewById(R.id.myWebView1);
		webview1.setBackgroundColor(0);
		
		
		webview2 = (WebView) findViewById(R.id.myWebView2);
		webview2.setBackgroundColor(0);
		
		
		webview3 = (WebView) findViewById(R.id.myWebView3);
		webview3.setBackgroundColor(0);
		
		
		webview4 = (WebView) findViewById(R.id.myWebView4);
		webview4.setBackgroundColor(0);
		
		
		WebSettings settings1 = webview1.getSettings();
		
        settings1.setJavaScriptEnabled(true);
        
        WebSettings settings2 = webview2.getSettings();
		
        settings2.setJavaScriptEnabled(true);
        
        
        WebSettings settings3 = webview3.getSettings();
		
        settings3.setJavaScriptEnabled(true);
        
        WebSettings settings4 = webview4.getSettings();
		
        settings4.setJavaScriptEnabled(true);
        
       // webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
       
        for(int i=0; i<firsttype.length(); i++)
        {
        	String a = String.valueOf(firsttype.charAt(i));
        	String b = String.valueOf(secondtype.charAt(i));
        	String c = a+b;
        	if(i==0)
        	{
        		webview1.loadUrl("file:///android_asset/16Tips/"+ c +".html");
        	}
        	if(i==1)
        	{
        		webview2.loadUrl("file:///android_asset/16Tips/"+ c +".html");
        	}
        	if(i==2)
        	{
        		webview3.loadUrl("file:///android_asset/16Tips/"+ c +".html");
        	}
        	if(i==3)
        	{
        		webview4.loadUrl("file:///android_asset/16Tips/"+ c +".html");
        	}
        	
        }
        
        		
          
    }
   
}