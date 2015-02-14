package com.example.contentresolverdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.Toast;

public class ContentResolverDemo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_resolver_demo);
        getRecords();
    }

    private void getRecords() {
		// TODO Auto-generated method stub
		String[] s12= {"Name", "Pass"};
		Cursor cursor= managedQuery(Uri.parse("content://data"), s12, null, null, null);
		cursor.moveToFirst();
		for(int i=0; i<cursor.getCount(); i++){
			String str1= cursor.getString(0);
			String str2= cursor.getString(1);
			cursor.moveToNext();
			Toast.makeText(getApplicationContext(), str1+""+str2, Toast.LENGTH_LONG).show();
		}
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_content_resolver_demo, menu);
        return true;
    }
}
