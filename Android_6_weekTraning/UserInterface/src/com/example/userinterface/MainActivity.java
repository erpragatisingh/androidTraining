package com.example.userinterface;

import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        LayoutParams params=new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        
        TextView tv=new TextView(this);
        tv.setText("This is a textview");
        tv.setLayoutParams(params);
        
        Button btn=new Button(this);
        btn.setText("This is a button");
        btn.setLayoutParams(params);
        
        layout.addView(tv);//adds textview
        layout.addView(btn);//adds button
        
        //create a layout param for the layout
        LinearLayout.LayoutParams layoutParam=new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT);
        
        this.addContentView(layout, layoutParam);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
