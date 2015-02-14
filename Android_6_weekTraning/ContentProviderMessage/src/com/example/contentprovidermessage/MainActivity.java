package com.example.contentprovidermessage;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView tView;
String colName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tView=(TextView)findViewById(R.id.textView1);
        ContentResolver cr=getContentResolver();
        Uri uri=Uri.parse("content://sms/inbox");
        Cursor messageCursor= cr.query(uri, new String[] {"_id","address","body","person"}, null, null, null);
        colName="ColumnName"+"\n";
        colName=colName+"________"+"\n";
        for(int loopcounter=0;loopcounter<messageCursor.getColumnCount();loopcounter++)
        {
        	colName=colName+messageCursor.getColumnName(loopcounter)+"\n";
        }
        colName=colName+"___________"+"\n";
        if(messageCursor.getCount()>0)
        {
        	while(messageCursor.moveToNext())
        	{
        		colName=colName+messageCursor.getString(messageCursor.getColumnIndex("body"))+"--";
        		colName=colName+messageCursor.getString(messageCursor.getColumnIndex("address"))+"--";
        		
        	}
        }
        tView.setText(colName);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
