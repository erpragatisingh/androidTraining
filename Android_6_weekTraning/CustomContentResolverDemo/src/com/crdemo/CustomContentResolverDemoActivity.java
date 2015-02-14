package com.crdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class CustomContentResolverDemoActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		insertRecord();
		//getRecords();
	}

	private void insertRecord() {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", "Amyyitt");
		contentValues.put("password", "mirauicle");
		getContentResolver().insert(Uri.parse("content://def"), contentValues);
	}
	
	private void getRecords(){
    	String[] selData = {"name","password"};
    	Cursor managedQuery = getContentResolver().query(Uri.parse("content://def"), selData, null, null, null);
    	managedQuery.moveToFirst();
    	for (int i = 0; i < managedQuery.getCount(); i++) {
    		String name = managedQuery.getString(0);
    		String password = managedQuery.getString(managedQuery.getColumnIndex("password"));
    		Toast.makeText(this, name+"  "+password, Toast.LENGTH_LONG).show();
    		managedQuery.moveToNext();
    	}
	}
}