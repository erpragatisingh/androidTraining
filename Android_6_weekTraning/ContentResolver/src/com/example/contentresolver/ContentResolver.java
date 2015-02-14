package com.example.contentresolver;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;

public class ContentResolver extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_resolver);
        getRecords();
    }

    private void getRecords() {
		// TODO Auto-generated method stub
		String[] str= {"Name","Pass"};
		Cursor cursor= managedQuery(Uri.parse("content://data"), str, null, null, null);
		cursor.moveToFirst();
	String s1=	cursor.getString(0);
	String s2=	cursor.getString(1);
		cursor.moveToNext();
		Toast.makeText(getApplicationContext(),"Value is"+ s1+""+""+s2, Toast.LENGTH_LONG).show();
		System.out.println(s1+""+s2);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_content_resolver, menu);
        return true;
    }
}
