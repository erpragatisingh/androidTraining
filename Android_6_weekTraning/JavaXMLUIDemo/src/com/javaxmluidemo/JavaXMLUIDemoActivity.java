package com.javaxmluidemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class JavaXMLUIDemoActivity extends Activity {
	LinearLayout linearLayout;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        linearLayout = (LinearLayout)findViewById(R.id.layout);
        
        Button button = new Button(this);
        button.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,50));
        button.setText("Click this!!!");
        button.setBackgroundResource(R.drawable.icon);
        
        linearLayout.addView(button);
    }
}