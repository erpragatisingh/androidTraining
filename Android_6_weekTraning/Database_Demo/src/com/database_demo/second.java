package com.database_demo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;


public class second extends Activity{
	data d1;
	Cursor c1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
		d1= new data(this);
		c1= d1.getData();
		Intent intent = getIntent();
		String s = intent.getStringExtra("name");
		Long l = Long.parseLong(s);
		TextView txt=(TextView)findViewById(R.id.textView1);
		if(c1.moveToFirst()){
			do{
		if (c1.getString(c1.getColumnIndex(d1.ID)).equals(s)) {
		String title= null;
		title= c1.getString(c1.getColumnIndex(d1.COLUMN1));
		txt.setText(title);
		}
			}
		while (c1.moveToNext());
			
			
			
			
	}
	}
}
