package com.presentiagroup.PersonalityCoach;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


public class Survey extends Activity 
{
	 /** Called when the activity is first created. */
	
	private WebView webview;
	Button mbtnBack;
	Button mbtnHome;
	private ProgressDialog progressBar;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
       	webview = (WebView) findViewById(R.id.myWebView);
		
		webview.setBackgroundColor(0);
		webview.getZoomControls();
		WebSettings settings = webview.getSettings();
		settings.setBuiltInZoomControls(true);
		settings.setJavaScriptEnabled(true);
		
		webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(Survey.this, Home.class));
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
		
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		 
        progressBar = ProgressDialog.show(Survey.this,    
	               "Please wait...", "Loading...", true);
        progressBar.setCancelable(true);
        webview.setWebViewClient(new WebViewClient() 
        {
            public boolean shouldOverrideUrlLoading(WebView view, String url) 
            {
                view.loadUrl(url);
                return true;
            }
 
            public void onPageFinished(WebView view, String url) 
            {
                 if (progressBar.isShowing()) 
                 {
                    progressBar.dismiss();
                 }
                 webview.setInitialScale(100);
            }
 
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) 
            {
            	Toast.makeText(Survey.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                alertDialog.setTitle("Error");
                alertDialog.setMessage(description);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                });
                alertDialog.show();
            }
        });
		
        webview.loadUrl("http://finlandlabs.com/in-en/index.php/personality-guide-");
       
	
    }
    
      

}