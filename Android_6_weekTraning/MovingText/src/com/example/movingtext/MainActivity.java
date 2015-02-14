package com.example.movingtext;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animation anm=new TranslateAnimation(0, 0, 100, -100);
        anm.setDuration(7000);
        anm.setRepeatCount(-1);
        TextView tv1=(TextView)findViewById(R.id.textView1);
        tv1.setAnimation(anm);
    }
    
    public void function(View v)
    {
    	Toast.makeText(getApplicationContext(), "You just rolled Baby! :D", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
