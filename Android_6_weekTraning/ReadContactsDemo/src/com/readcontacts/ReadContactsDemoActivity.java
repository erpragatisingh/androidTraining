package com.readcontacts;

import android.R.anim;
import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ReadContactsDemoActivity extends Activity {
	ListView l1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button b1= (Button)findViewById(R.id.button1);
		l1=(ListView)findViewById(R.id.listView1);
	//	Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
	Cursor c1= getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
	int coun= c1.getCount();	
	 System.out.println(coun);
	
	
	b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	Uri u1= Uri.parse("content://sms/inbox");
				System.out.println("hhhhhhhh");
				Cursor c11= getContentResolver().query(Uri.parse("content://sms/inbox"), 
						new String[]{"_id", "address", "date", "body"}, null, null, null);
				c11.moveToFirst();
				for (int i = 0; i < c11.getCount(); i++) {
					String name = c11.getString(1);
					String nn= c11.getColumnName(2);
					String number = c11.getString(3);
					Toast.makeText(getApplicationContext(), "Name : "+name+" " +
							"Number : "+number+"Date :"+nn, Toast.LENGTH_LONG).show();
					c11.moveToNext();
				}
			}
		});
		
		c1.moveToFirst();
		String[] s12= new String[c1.getCount()];
		for (int i = 0; i < c1.getCount(); i++) {
			String name = c1.getString(c1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			String number = c1.getString(c1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			Toast.makeText(this, "Name : "+name+" Number : "+number, Toast.LENGTH_LONG).show();
			 s12[i] = name+"    "+number;
			
			c1.moveToNext();
		}
		 ArrayAdapter<String> a1= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, s12);
		 l1.setAdapter(a1);
	}
}