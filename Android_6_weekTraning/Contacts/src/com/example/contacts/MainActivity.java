package com.example.contacts;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView t;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t=(TextView)findViewById(R.id.textView1);
        Cursor people=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
        		null, null, null, null);
        while(people.moveToNext())
        {
        	int name_index=people.getColumnIndex(PhoneLookup.DISPLAY_NAME);
        	String name=people.getString(name_index);
        	t.append(name+"\n");
        //	Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
        	
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
