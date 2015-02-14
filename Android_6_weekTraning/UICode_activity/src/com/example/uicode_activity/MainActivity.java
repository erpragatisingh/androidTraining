package com.example.uicode_activity;

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
		//setContentView(R.layout.activity_main);
	
	LayoutParams lp =new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
	
	LinearLayout lay= new LinearLayout(this);
	lay.setOrientation(LinearLayout.VERTICAL);
	
	TextView tv=new TextView(this);
	tv.setText("SINGH");
	tv.setLayoutParams(lp);
	
	Button btn=new Button(this);
	btn.setText("this is buton");
	btn.setLayoutParams(lp);
	lay.addView(tv);
	lay.addView(btn);
	
	
	
	LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
	this.addContentView(lay, lp2);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
