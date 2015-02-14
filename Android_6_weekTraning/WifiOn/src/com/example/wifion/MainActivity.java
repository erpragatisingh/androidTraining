package com.example.wifion;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(TextView)findViewById(R.id.textView1);
        ConnectivityManager cin_wifi=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean wifi=cin_wifi.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        		.isConnectedOrConnecting();
        
        if(wifi) 
        {
        	
        	t.setText("wifi is on");
        }
   else {
	   
	   t.setText("wifi is off");
	
}
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
