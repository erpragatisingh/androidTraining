package com.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
@SuppressWarnings("unused")
public class DBAdapter extends CursorAdapter {

	Context context;
	Cursor c;
	Manager manager;

	public DBAdapter(Context context, Cursor c) {
		super(context, c);

		this.context = context;
		this.c = c;
		// TODO Auto-generated constructor stub
	}

	public long getItemId(int position) {
		String id = null;
		int id1 = 0;
		if (c.moveToPosition(position)) {

			id = c.getString(0);
			id1 = Integer.parseInt(id);
		}

		return id1;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		String title = null;
		String date = null;
		String udone = null;

		if (c.moveToPosition(position)) {

			date = c.getString(3);
			title = c.getString(1);
			udone = c.getString(5);

		}
		return new ReviewListView(context, title, date, udone);
	}

	private final class ReviewListView extends LinearLayout {

		private TextView title;
		private TextView date;
		private ImageView imageView;

		public ReviewListView(Context context, String name, String rating,
				String udone) {

			super(context);
			setOrientation(LinearLayout.VERTICAL);

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			params.setMargins(5, 3, 5, 0);

			title = new TextView(context);
			title.setText(name);
			title.setTextSize(16f);
			title.setTextColor(Color.WHITE);
			this.addView(title, params);

			date = new TextView(context);
			date.setText("To be done on: " + rating);
			date.setTextSize(16f);
			date.setTextColor(Color.BLACK);
			this.addView(date, params);

			imageView = new ImageView(context);
			imageView
					.setBackgroundResource(R.drawable.btn_check_buttonless_off);
			if (udone.equals("done")) {
				imageView
						.setBackgroundResource(R.drawable.btn_check_buttonless_on);
				this.addView(imageView, params);
			} else {
				imageView
						.setBackgroundResource(R.drawable.btn_check_buttonless_off);
				this.addView(imageView, params);
			}

		}
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// TODO Auto-generated method stub

	}

}
