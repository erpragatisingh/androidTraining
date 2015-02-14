package com.anr;

import android.app.Activity;
import android.os.Bundle;

public class ANRActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
			Thread.sleep(500000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}