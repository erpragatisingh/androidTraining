package com.japnek.database;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends Activity {
	TextView t1;
	My_SqliteHelper obj=new My_SqliteHelper(this, "dba.db", null, 1);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		t1=(TextView)findViewById(R.id.text1);
		Cursor cur=getCur();
		mydisplay(cur);
	}

	@SuppressWarnings("deprecation")
	public Cursor getCur()
	{
		SQLiteDatabase db=obj.getReadableDatabase();
		Cursor cur=db.query(My_SqliteHelper.dtable, null, null, null, null, null, null);
		startManagingCursor(cur);
		return cur;
	}
	
	public Cursor mydisplay(Cursor cur)
	{
		StringBuilder str=new StringBuilder();
		while(cur.moveToNext())
		{
			int id=cur.getInt(0);
			String use=cur.getString(1);
			String pas=cur.getString(2);
			str.append("id ="+id+"\n"+"user ="+use+"\n"+"Password ="+pas+"\n");
			
		}
		t1.setText(str);
		return cur;
	}
}
