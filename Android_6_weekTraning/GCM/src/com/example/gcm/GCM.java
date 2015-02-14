package com.example.gcm;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GCM extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_gcm, menu);
        return true;
    }
}
