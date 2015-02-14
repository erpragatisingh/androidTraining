package com.onsavedinstancestate;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class MainActivity extends Activity {

	EditText edt1;
	String edt11;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edt1=(EditText)findViewById(R.id.edittext);	
		Toast.makeText(getApplicationContext(), "oncreate", Toast.LENGTH_SHORT).show();
		
		loadSavedPreferences();
	}
	
//	@Override
//	protected void onSaveInstanceState(Bundle outState) {
//		// TODO Auto-generated method stub
//		super.onSaveInstanceState(outState);
//		Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
//		outState.putString("edittext", edt1.getText().toString());
//		
//		
//		
//		
//	}
//	
//	@Override
//	protected void onRestoreInstanceState(Bundle savedInstanceState) {
//		// TODO Auto-generated method stub
//		
//		super.onRestoreInstanceState(savedInstanceState);
//		Toast.makeText(getApplicationContext(), "restored", Toast.LENGTH_SHORT).show();
//		
//		String s=savedInstanceState.getString("edittext");
//		edt1.setText(s);
//		
//		
//	}
//	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
	}
	
	public void onClick(View v)
	{
		startActivity(new Intent(MainActivity.this,SecondActivity.class));
	}
	
	private void loadSavedPreferences() {
		SharedPreferences sharedPreferences = PreferenceManager
		        .getDefaultSharedPreferences(this);

		edt1.setText(sharedPreferences.getString("string_et1","value doesn't exist"));

		}
		private void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager
		        .getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
		}
		public void saveData(){
		savePreferences("string_et1", edt1.getText().toString());
		}
		@Override
		public void onBackPressed(){
		    saveData();
		    
		    super.onBackPressed();
		}
}
