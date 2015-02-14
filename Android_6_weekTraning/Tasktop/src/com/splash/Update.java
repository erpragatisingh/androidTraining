package com.splash;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Update extends Activity {

	long l;
	String s;
	EditText editText, editText2;
	TextView tv, tv1;

	Manager manager;
	Cursor c;
	RadioButton radioButton, radioButton2;
	Button button2;

	private int mYear;
	private int mMonth;
	private int mDay;
	private int mhour;
	private int mmin;
	
	static final int DATE_DIALOG_ID = 0;
	static final int TIME_DIALOG_ID = 10;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update);
		s = getIntent().getStringExtra("name");
		l = Long.parseLong(s);
		editText = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		radioButton = (RadioButton) findViewById(R.id.radio0);
		radioButton2 = (RadioButton) findViewById(R.id.radio1);
		tv = (TextView) findViewById(R.id.textView6);
		tv1=(TextView)findViewById(R.id.textView9);

		manager = new Manager(this);

		c = manager.getRow();
		if (c.moveToFirst()) {

			String title = null;
			String priority = null;
			String date = null;
			String task = null;
			String time= null;

			do {

				if (c.getString(c.getColumnIndex(manager.ID)).equals(s)) {
					title = c.getString(c.getColumnIndex(manager.COLUMN1));
					priority = c.getString(c.getColumnIndex(manager.COLUMN2));
					date = c.getString(c.getColumnIndex(manager.COLUMN3));
					task = c.getString(c.getColumnIndex(manager.COLUMN4));
					time= c.getString(c.getColumnIndex(manager.COLUMN6));
					editText.setText(title);
					tv.setText(date);
					editText2.setText(task);
					tv1.setText(time);
					if (priority.equalsIgnoreCase("high")) {
						radioButton.setChecked(true);
					} else {
						radioButton2.setChecked(true);
					}

				}
			} while (c.moveToNext());
		}

		Button button = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				validation();

			}

			private void validation() {
				// TODO Auto-generated method stub
				if (!validate()) {
					return;
				}
				String str;
				if (radioButton.isChecked()) {
					str = radioButton.getText().toString();
				} else {
					str = radioButton2.getText().toString();
				}
			/*	manager.updateRow(l, editText.getText().toString(), str, tv
						.getText().toString(), editText2.getText().toString());*/
				Intent intent = new Intent(Update.this, MainScreen.class);
				// intent.putExtra("name", s);
				startActivity(intent);
				// Update.this.finish();

			}

			// validate form fields
			private boolean validate() {
				boolean valid = true;
				StringBuilder validationText = new StringBuilder();
				if (((editText.getText() == null) || editText.getText()
						.toString().equals(""))
						|| ((editText2.getText() == null) || editText2
								.getText().toString().equals(""))) {
					validationText.append("Don't left any Field Empty!");
					valid = false;
				}
				if (!valid) {
					new AlertDialog.Builder(Update.this)
							.setTitle("WARNING")
							.setMessage(validationText.toString())
							.setPositiveButton(
									"Continue",
									new android.content.DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int arg1) {

										}
									}).show();
					validationText = null;
				}
				return valid;
			}

		});

		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Update.this, Detail.class);
				intent.putExtra("name", s);
				startActivity(intent);
				// Update.this.finish();

			}
		});

		ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);
		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Update.this, Welcome.class);
				startActivity(intent);
				// Update.this.finish();

			}
		});

		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showDialog(DATE_DIALOG_ID);
			}
		});
		button2= (Button)findViewById(R.id.button3);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//openTimePickerDialog(false);
				showDialog(TIME_DIALOG_ID);
				 
				
			}
		});

		// get the current date
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		mhour= c.get(Calendar.HOUR);
		mmin= c.get(Calendar.MINUTE);

		// display the current date (this method is below)
		// updateDisplay();

	}

	private void updateDisplay() {
		// TODO Auto-generated method stub

		tv.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mDay).append("-").append(mMonth + 1).append("-")
				.append(mYear).append(" "));
		tv1.setText(new StringBuilder()
		// Month is 0 based so add 1
		.append(mhour).append("-").append(mmin).append(" "));

	}

	// the callback received when the user "sets" the date in the dialog
	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
		}
	};
	 TimePickerDialog.OnTimeSetListener m1= new OnTimeSetListener() {
		 
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				  Calendar callset= (Calendar)c.clone();
				mhour= hourOfDay;
				mmin= minute;
				updateDisplay();
			}
	 };

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		
		case DATE_DIALOG_ID:
			
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
					mDay);
			
		case TIME_DIALOG_ID:
			Boolean my1=isChild();
			return new TimePickerDialog(this, m1, mhour, mmin, my1);
		}
		return null;
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
			finish();
			break;
		default:
			break;
		}

		return true;
	}

}
