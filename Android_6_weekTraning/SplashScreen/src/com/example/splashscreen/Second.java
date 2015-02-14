package com.example.splashscreen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

public class Second extends Activity{

	ImageView iii;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		iii=(ImageView)findViewById(R.id.imageView2);
	}
}
