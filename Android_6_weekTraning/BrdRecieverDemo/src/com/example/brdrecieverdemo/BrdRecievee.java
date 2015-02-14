package com.example.brdrecieverdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class BrdRecievee extends Activity {
	Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brd_recievee);
        b1=(Button)findViewById(R.id.button1);
        
    }
public void onClick(View v) {
	// TODO Auto-generated method stub
Intent i= new Intent(BrdRecievee.this, MyBroadcast.class);
sendBroadcast(i);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.activity_brd_recievee, menu);
        return true;
    }
}
