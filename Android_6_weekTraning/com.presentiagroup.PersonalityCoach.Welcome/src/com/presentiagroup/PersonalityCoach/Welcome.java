package com.presentiagroup.PersonalityCoach;

import android.app.Activity;
//import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
//import android.widget.Toast;

public class Welcome extends Activity 
{
	Button btnGetStarted;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnGetStarted = (Button)findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				    //TelephonyManager mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
			        //String imei = mTelephonyMgr.getDeviceId();
			        
			        
			        Intent intent = new Intent(Welcome.this, Home.class);
			        startActivity(intent);
		        	
			      /*
			        if(imei!=null && imei.equals("00000000000000")||imei.equals("353833044187711")||imei.equals("A100001780DA70")||imei.equals("A100001377AA0E")||imei.equals("310003038800211")||imei.equals("310005183347446")||imei.equals("353833041327922") )
			        {
			        	
			        	Intent intent = new Intent(Welcome.this, Home.class);
			        	startActivity(intent);
			        	
			        }
			        else
			        {
			        	Toast.makeText(Welcome.this, "Sorry! IMEI not supported", Toast.LENGTH_SHORT).show();
			        	finish();
			        }*/
				
			}
		});
    }
}