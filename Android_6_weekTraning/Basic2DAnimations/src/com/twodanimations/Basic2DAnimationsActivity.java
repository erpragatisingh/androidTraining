package com.twodanimations;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Basic2DAnimationsActivity extends Activity {
	TextView textView;
	ImageView img;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView)findViewById(R.id.text1);
        img=(ImageView)findViewById(R.id.imageView1);
        
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_animation);
        textView.startAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.abc);
        img.startAnimation(animation1);
    }
}