package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	TextView tv;
	Button bt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
		bt=(Button) findViewById(R.id.butnClick) ;
		bt.setOnClickListener(this);
		
	 tv=(TextView) findViewById(R.id.mt_txt);
	

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 tv.setText("Welcome\n");
		 
 		tv.setBackgroundColor(Color.BLUE);
 		//bt.setText("Blue");
 		bt.setId(765785859);
 		tv.append(String.valueOf(bt.getId()));
		
	}

//public void MyClick(View v) {
//	
//	
//        tv.setText("Welcome");
//	
//	tv.setBackgroundColor(Color.RED);
//	
//	
//}

}
