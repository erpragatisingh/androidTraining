package com.database_demo;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Adap extends CursorAdapter{
	Context c1;
	Cursor c2;	

	
	public Adap(Context context, Cursor c) {
		super(context,c);
		c1= context;
		c2= c;
		
		
		// TODO Auto-generated constructor stub
	}

	public View getView(int position, View convertView, ViewGroup parent)
	{
		String title= null;
		if(c2.moveToPosition(position)){

		title = c2.getString(1);
		}
		return new inj(c1, title);
	/*	LayoutInflater inflater = ((Activity)c1).getLayoutInflater();
        convertView = inflater.inflate(a1, parent);
		TextView text=(TextView)convertView.findViewById(R.id.textView1);
		text.setText(c2.getString(1));
		return convertView;*/
		
	}
	
	public final class inj extends LinearLayout{
		private TextView title;
		
	public inj(Context context, String name) {
		super(context);
		// TODO Auto-generated constructor stub
		LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		
		title = new TextView(context);
		title.setText(name);
		this.addView(title, params);
	}
	}
	
	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}
