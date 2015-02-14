package com.splash;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends Activity {

	Manager manager;
	Cursor c;
	TextView textView, textView2, textView3, textView4,textView5;
	Button button, button2;
	Long l;
	String s;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		Intent intent = getIntent();
		s = intent.getStringExtra("name");
		l = Long.parseLong(s);
	

		textView = (TextView) findViewById(R.id.textView5);
		textView2 = (TextView) findViewById(R.id.textView8);
		textView3 = (TextView) findViewById(R.id.textView10);
		textView4 = (TextView) findViewById(R.id.textView12);
		textView5 = (TextView)findViewById(R.id.textView13);
		manager = new Manager(this);

		c = manager.getRow();
		if (c.moveToFirst()) {

			String title = null;
			String priority = null;
			String date = null;
			String task = null;
			String Time = null;

			do {

				if (c.getString(c.getColumnIndex(manager.ID)).equals(s)) {
					title = c.getString(c.getColumnIndex(manager.COLUMN1));
					priority = c.getString(c.getColumnIndex(manager.COLUMN2));
					date = c.getString(c.getColumnIndex(manager.COLUMN3));
					task = c.getString(c.getColumnIndex(manager.COLUMN4));
					Time = c.getString(c.getColumnIndex(manager.COLUMN6));
					textView.setText(title);
					textView2.setText(task);
					textView3.setText(priority);
					textView4.setText(date);
					textView5.setText(Time);
				}
			} while (c.moveToNext());
		}

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				manager.deleteRow(l);

				Intent intent = new Intent(Detail.this, MainScreen.class);
				startActivity(intent);// Detail.this.finish();

			}
		});

		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Detail.this, MainScreen.class);
				startActivity(intent);// Detail.this.finish();

			}
		});

		ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);
		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Detail.this, Welcome.class);
				startActivity(intent);// Detail.this.finish();

			}
		});

		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Detail.this, Update.class);
				intent.putExtra("name", s);
				startActivity(intent);// Detail.this.finish();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.mymenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		switch (item.getItemId()) {

		case R.id.item1:
			// Toast.makeText(this, "Add Task", 1000).show();
			intent = new Intent(this, AddTask.class);
			startActivity(intent);
			// finish();

			break;
		case R.id.item2:
			// Toast.makeText(this, "Delete All", 1000).show();

			manager.deleteRow();
			intent = new Intent(this, MainScreen.class);
			startActivity(intent);
			// finish();
			break;

		case R.id.item3:
			// Toast.makeText(this, "Info.", 1000).show();
			intent = new Intent(this, Welcome.class);
			startActivity(intent);
			// finish();
			break;
		case R.id.item4:
			Toast.makeText(this, "Press Home", 1000).show();
			// finish();
			break;
		default:
			break;
		}

		return true;
	}

}
