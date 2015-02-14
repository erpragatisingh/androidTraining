package com.example.broad;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Broad extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
    }
@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	this.registerReceiver(brd, i1);
}
protected void onPause() {
    // Unregister since the activity is not visible
   this.unregisterReceiver(brd);
    super.onPause();
  } 
IntentFilter i1= new IntentFilter("abc");
private BroadcastReceiver brd= new BroadcastReceiver(){
	
	public void onReceive(Context context, Intent intent) {
		String str= intent.getStringExtra("msg");
		  Toast.makeText(context, str, 3000).show();
	}
};
public void onClick(View v) {
	// TODO Auto-generated method stub
Intent i2= new Intent("abc");
i2.putExtra("msg", "WWWWW");
sendBroadcast(i2);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_broad, menu);
        return true;
    }
}
