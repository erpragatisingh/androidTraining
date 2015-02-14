package com.splash;

import java.security.PrivateKey;
import java.util.Calendar;

import javax.security.auth.PrivateCredentialPermission;



import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class AddTask extends Activity {
	private int mYear;
	private int mMonth;
	private int mDay;
	private int mhour;
	private int mmin;
	private int msec;
	Button button, button2;
	TextView tv, tv1;
	Manager manager;
	EditText editText1, editText2;
	RadioButton radioButton, radioButton2;
	TextView textAlarmPrompt;

	static final int DATE_DIALOG_ID = 0;
	static final int TIME_DIALOG_ID= 12;
	TimePicker myTimePicker;
    TimePickerDialog timePickerDialog;
    final static int RQS_1 = 1;
    
 
  
	

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addtask);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		radioButton = (RadioButton) findViewById(R.id.radio0);
		radioButton2 = (RadioButton) findViewById(R.id.radio1);
	//	textAlarmPrompt= (TextView)findViewById(R.id.textView10);
		manager = new Manager(getApplicationContext());
		

		Button button = (Button) findViewById(R.id.button2);
		button2=(Button)findViewById(R.id.button3);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				validation();
			//	textAlarmPrompt.setText("");
			//	triggerNotification(v);
			//	setAlarm(callset);
				nik();
				Log.e("response ===========", "KEE==========" +editText1.getText().toString()+"  Name =" +editText2.getText().toString());

			}

			private void validation() {
				// TODO Auto-generated method stub

			//	if (!validate()) {
			//		return;
			//	}
				String str;
				if (radioButton.isChecked()) {
					str = radioButton.getText().toString();
				} else {
					str = radioButton2.getText().toString();
				}

				manager.addRow(editText1.getText().toString(), str, tv
						.getText().toString(), editText2.getText().toString(), tv1.getText().toString());
				editText1.setText("");
				editText2.setText("");

				Toast.makeText(AddTask.this, "Task Saved", 3000).show();
				Intent intent = new Intent(AddTask.this, MainScreen.class);
				startActivity(intent);// AddTask.this.finish();

			}

			// validate form fields
			private boolean validate() {
				boolean valid = true;
				StringBuilder validationText = new StringBuilder();
				if (((editText1.getText() == null) || editText1.getText()
						.toString().equals(""))
						|| ((editText2.getText() == null) || editText2
								.getText().toString().equals(""))) {
					validationText.append("Don't left any Field Empty!");
					valid = false;
				}
				if (!valid) {
					new AlertDialog.Builder(AddTask.this)
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
				Intent intent = new Intent(AddTask.this, MainScreen.class);
				startActivity(intent);// AddTask.this.finish();

			}
		});

		ImageView imageView1 = (ImageView) findViewById(R.id.imageView2);
		imageView1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(AddTask.this, Welcome.class);
				startActivity(intent);// AddTask.this.finish();

			}
		});
button2.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//openTimePickerDialog(false);
		showDialog(TIME_DIALOG_ID);
		 
		
	}
});


final Calendar c1= Calendar.getInstance();
mhour= c1.get(Calendar.HOUR_OF_DAY);
mmin= c1.get(Calendar.MINUTE);
//msec= c1.get(Calendar.SECOND);

updateDisplay1();




		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				showDialog(DATE_DIALOG_ID);
				
			}
		});

		// get the current date
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// display the current date (this method is below)
		updateDisplay();

	}
	
	private void updateDisplay() {
		// TODO Auto-generated method stub

		tv = (TextView) findViewById(R.id.textView6);
		tv.setText(new StringBuilder()
				// Month is 0 based so add 1
				.append(mDay).append("-").append(mMonth +1).append("-")
				.append(mYear).append(" "));

	}
	private void updateDisplay1() {
		tv1 = (TextView) findViewById(R.id.textView9);
		tv1.setText(new StringBuilder()
		// Month is 0 based so add 1
		.append(mhour).append("-").append(mmin).append(" "));
	}
public void nik(){
	DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
		
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateDisplay();
			
			
			
			  }};
			 TimePickerDialog.OnTimeSetListener m1= new OnTimeSetListener() {
				 
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					// TODO Auto-generated method stub
					Calendar c = Calendar.getInstance();
					  Calendar callset= (Calendar)c.clone();
					mhour= hourOfDay;
					mmin= minute;
					updateDisplay1();
				
					 callset.set(Calendar.HOUR_OF_DAY, hourOfDay);
					  callset.set(Calendar.MINUTE, minute);
					  callset.set(Calendar.SECOND, 0);
					  callset.set(Calendar.MILLISECOND, 0);
					/*  if(callset.compareTo(c) <= 0){
						    //Today Set time passed, count to tomorrow
							callset.add(Calendar.DATE, 1);
						   }*/
					  setAlarm(callset);
					
				}
			};
		
			  
	
}
	// the callback received when the user "sets" the date in the dialog

	
private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
	
		mYear = year;
		mMonth = monthOfYear;
		mDay = dayOfMonth;
		updateDisplay();
		
		
		
		  }};
		 TimePickerDialog.OnTimeSetListener m1= new OnTimeSetListener() {
			 
			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance();
				  Calendar callset= (Calendar)c.clone();
				mhour= hourOfDay;
				mmin= minute;
				updateDisplay1();
			
				 callset.set(Calendar.HOUR_OF_DAY, hourOfDay);
				  callset.set(Calendar.MINUTE, minute);
				  callset.set(Calendar.SECOND, 0);
				  callset.set(Calendar.MILLISECOND, 0);
				/*  if(callset.compareTo(c) <= 0){
					    //Today Set time passed, count to tomorrow
						callset.add(Calendar.DATE, 1);
					   }*/
				  setAlarm(callset);
				
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


	protected void setAlarm(Calendar targetCal) {
		// TODO Auto-generated method stub
		textAlarmPrompt= (TextView)findViewById(R.id.textView10);
		textAlarmPrompt.setText(
			    "\n\n***\n"
			    + "Alarm is set@ " + targetCal.getTime() + "\n"
			    + "***\n");
			  
			  Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
			  PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
			  AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
			  alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
			  
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
			startActivity(intent);// finish();
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
