package com.cpdemo;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class ContentProviderDemoActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//insertRecord();
		getRecords();
	}

	private void insertRecord() {
		ContentValues values = new ContentValues();
		values.put("name", "miracle123");
		values.put(MyBaseColumn.Users.uPassword, "123456789");
		getContentResolver().insert(MyBaseColumn.Users.contentUri, values);
		
	}

	private void getRecords(){
    	String[] selData = {"name",MyBaseColumn.Users.uPassword};
    	Cursor managedQuery = managedQuery(MyBaseColumn.Users.contentUri, selData, null, null, null);
    	managedQuery.moveToFirst();
    	for (int i = 0; i < managedQuery.getCount(); i++) {
    		String name = managedQuery.getString(0);
    		String password = managedQuery.getString(managedQuery.getColumnIndex(MyBaseColumn.Users.uPassword));
    		Toast.makeText(this, name+"  "+password, Toast.LENGTH_LONG).show();
    		managedQuery.moveToNext();
    	}
	}
}