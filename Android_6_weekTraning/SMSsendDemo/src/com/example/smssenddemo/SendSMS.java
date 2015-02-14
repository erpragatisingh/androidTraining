package com.example.smssenddemo;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SendSMS extends Activity {
	EditText e1, e2;
	Button b1, b2, b3, b4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1= (EditText)findViewById(R.id.editText1);
        e2= (EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendSms();
			}
		});
        
 b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendSms1();
			}
		});
 b4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:000999888777666"));
			startActivity(i);
		}
	});
        
    
    b3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			sendSms2();
		}

		private void sendSms2() {
			// TODO Auto-generated method stub

		    Intent smsIntent = new Intent(Intent.ACTION_VIEW);

		    smsIntent.putExtra("sms_body", e2.getText().toString()); 
		    smsIntent.putExtra("address", e1.getText().toString());
		    smsIntent.setType("vnd.android-dir/mms-sms");

		    startActivity(smsIntent);
		    
		    ContentValues values = new ContentValues(); 
            
		    values.put("address", e1.getText().toString()); 
		              
		    values.put("body", e2.getText().toString()); 
		              
		    getContentResolver().insert(Uri.parse("content://sms/sent"), values);
		}
	});
    }


    private void sendSms() {
		// TODO Auto-generated method stub

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(e1.getText().toString(), null,e2.getText().toString() , null, null);
	}

    private void sendSms1() {
		// TODO Auto-generated method stub


        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(e2.getText().toString()); 
        smsManager.sendMultipartTextMessage(e1.getText().toString(), null, parts, null, null);
	}
    
    
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
