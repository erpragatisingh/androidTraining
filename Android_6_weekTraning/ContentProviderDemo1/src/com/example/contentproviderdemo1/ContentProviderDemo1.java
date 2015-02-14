package com.example.contentproviderdemo1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;

public class ContentProviderDemo1 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider_demo1);
        insertRecords();
       
    }

   
	

	private void insertRecords() {
		// TODO Auto-generated method stub
		ContentValues cv= new ContentValues();
		cv.put("Name", "Nikhil123");
		cv.put("Pass", "123456789");
		getContentResolver().insert(Uri.parse("content://data"), cv);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_content_provider_demo1, menu);
        return true;
    }
}
