package com.example.alertdialogdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class AlertDialog extends Activity {
	Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        b1=(Button)findViewById(R.id.button1);
     
    }
    
    public void onClickk(View view) {
		// TODO Auto-generated method stub

    	 android.app.AlertDialog.Builder builder= new android.app.AlertDialog.Builder(AlertDialog.this);
         builder.setMessage("HEllo User");
         builder.setIcon(R.drawable.ic_launcher);
         builder.setTitle("Alert Box");
         
         builder.setPositiveButton("No", new OnClickListener() {
 			
 			@Override
 			public void onClick(DialogInterface dialog, int which) {
 				// TODO Auto-generated method stub
 			Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();	
 			}
 		});
         builder.setNegativeButton("Yes", new OnClickListener() {
 			
 			@Override
 			public void onClick(DialogInterface dialog, int which) {
 				// TODO Auto-generated method stub
 			Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();
 			finish();
 			}
 		});
         builder.setNeutralButton("Continue", new OnClickListener() {
 			
 			@Override
 			public void onClick(DialogInterface dialog, int which) {
 				// TODO Auto-generated method stub
 			Intent i = new Intent(AlertDialog.this, AlertDialog.class);
 			startActivity(i);
 			}
 		});
         builder.show();
    }
   

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_alert_dialog, menu);
        return true;
    }
}
