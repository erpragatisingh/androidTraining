package com.example.broadcastdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Broadcast extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_broadcast, menu);
        return true;
    }
}
