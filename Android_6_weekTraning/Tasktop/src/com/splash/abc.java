package com.splash;



import android.content.Context;
import android.database.Cursor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class abc extends CursorAdapter{
	Context context;
	Cursor c;
	Manager manager;

	public abc(Context context, Cursor c) {
		super(context, c);
		this.context = context;
		this.c = c;
		// TODO Auto-generated constructor stub
	}
	
/*	public long getiem(int position){
		String id = null;
		int id1 = 0;
		if (c.moveToPosition(position)) {

			id = c.getString(0);
			id1 = Integer.parseInt(id);
		}
		
		return id1;}
		*/
	public View getView(int position, View convertView, ViewGroup parent){
		
		String title = null;
		String date = null;
		String udone = null;
		String time= null;

		if (c.moveToPosition(position)) {

			date = c.getString(3);
			title = c.getString(1);
			udone = c.getString(5);
			time = c.getString(6);

		}
		return new inj(context, title, date, udone, time);
		}

		

		public final class inj extends LinearLayout{
			private TextView title;
			private TextView date;
			private ImageView imageView;
			private TextView time;
			
		public inj(Context context, String name, String rating,
				String udone, String time1) {
			super(context);
			// TODO Auto-generated constructor stub
			LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			
			title = new TextView(context);
			title.setText(name);
			this.addView(title, params);
			
			date = new TextView(context);
			date.setText("To be done on: " + rating);
			this.addView(date, params);
			
			time = new TextView(context);
			time.setText("at Time- " +time1);
			this.addView(time, params);

			
			imageView = new ImageView(context);
			imageView.setBackgroundResource(R.drawable.btn_check_buttonless_off);
			this.addView(imageView, params);
			
		}

		
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
