package com.example.calender_view;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CalenderActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calender, menu);
        return true;
    }
}
