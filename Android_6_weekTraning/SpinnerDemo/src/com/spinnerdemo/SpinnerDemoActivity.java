package com.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerDemoActivity extends Activity {
	Spinner spinner;
	ArrayAdapter<String> arrayAdapter;
	String[] data = {"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		spinner = (Spinner) findViewById(R.id.spinner);
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data);
		spinner.setAdapter(arrayAdapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String itemAtPosition = (String)parent.getItemAtPosition(position);
				Toast.makeText(SpinnerDemoActivity.this, itemAtPosition, 3000).show();
			}

			public void onNothingSelected(AdapterView<?> parent) {
				
			}
		});
		
	}
}