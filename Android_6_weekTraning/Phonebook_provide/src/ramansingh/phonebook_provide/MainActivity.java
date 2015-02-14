package ramansingh.phonebook_provide;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.PhoneLookup;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		tv=(TextView) findViewById(R.id.textView1);
		Cursor people=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null	, null,  null, null);
		
	while (people.moveToNext()){
		int name_index=people.getColumnIndex(PhoneLookup.DISPLAY_NAME);
		String name= people.getString(name_index);
		tv.append(name +"\n");
		
		
	}
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
