package com.example.externalfont;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txtGhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGhost=(TextView)findViewById(R.id.textView1);
       // String fontpath="fonts/ALGER.TTF";
        String fontpath="fonts/orangejuce.ttf";  
        Typeface tf=Typeface.createFromAsset(getAssets(), fontpath);
        txtGhost.setTypeface(tf);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
