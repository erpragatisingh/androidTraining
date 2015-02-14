package ramansingh.content_provider;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
String colName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	TextView tv = (TextView) findViewById(R.id.textView1);
	ContentResolver cr =getContentResolver();
	Uri uri=Uri.parse("content://sms/inbox");
	//Uri uri =Uri.parse("content://sms"); (for all sms togheter)
	//Uriuri=Uri.parse("content://sms/sent); (to view sent)
	Cursor messageCursor = cr.query(uri, new String[]{"_id", "address", "body","person"}, null	,null, null);
	colName="ColumnName" + "\n";
	
	colName= colName + "............."+ "\n";
	
	
	for(int loopCounter=0; loopCounter<messageCursor.getColumnCount(); loopCounter++){
		colName =colName + messageCursor.getColumnName(loopCounter) +"\n";
		
	}
	
	colName= colName + "............."+ "\n";
	
	if(messageCursor.getCount()>0)
	{
		while(messageCursor.moveToNext()){
			colName=colName+messageCursor.getString(messageCursor.getColumnIndex("body"))+"--";
			colName=colName+messageCursor.getString(messageCursor.getColumnIndex("address"))+"--";
		}
	}
	
	
	tv.setText(colName);
	
	
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
