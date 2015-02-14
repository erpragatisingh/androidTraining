package com.example.intentdemo1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class IntentDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_intent_demo, menu);
        return true;
    }
}
