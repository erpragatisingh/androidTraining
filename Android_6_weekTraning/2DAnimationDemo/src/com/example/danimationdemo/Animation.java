package com.example.danimationdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class Animation extends Activity {
	TextView t1;
	ImageView i1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        t1=(TextView)findViewById(R.id.textView1);
        i1=(ImageView)findViewById(R.id.imageView1);
        android.view.animation.Animation a1= new AnimationUtils().loadAnimation(this, R.anim.animate);
        t1.setAnimation(a1);
        
        i1.setAnimation(a1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_animation, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	return super.onOptionsItemSelected(item);
    }
}
