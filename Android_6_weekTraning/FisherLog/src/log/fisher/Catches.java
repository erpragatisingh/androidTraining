package log.fisher;

import java.lang.reflect.Array;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Catches extends Activity{

	Spinner sp,sp1;
	String[] species;
	String[] method;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catches);
		sp=(Spinner) findViewById(R.id.spinner1);
		sp1=(Spinner) findViewById(R.id.spinner2);
		species=getResources().getStringArray(R.array.species);
		method=getResources().getStringArray(R.array.method);
		ArrayAdapter<String> ad1=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,method);
		sp1.setAdapter(ad1);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		ArrayAdapter<String> ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,species);
		sp.setAdapter(ad);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
