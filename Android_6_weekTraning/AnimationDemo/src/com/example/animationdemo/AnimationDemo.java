package com.example.animationdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationDemo extends Activity {
	ImageView image;
	TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);
        image=(ImageView)findViewById(R.id.imageView1);
        text=(TextView)findViewById(R.id.textView1);
        Animation a1= AnimationUtils.loadAnimation(this, R.anim.abc);
        Animation a2= AnimationUtils.loadAnimation(this, R.anim.def);
        image.setAnimation(a1);
        text.setAnimation(a2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_animation_demo, menu);
        return true;
    }
}
