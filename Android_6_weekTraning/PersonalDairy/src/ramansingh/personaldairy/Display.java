package ramansingh.personaldairy;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends Activity {
	
	TextView t1;
	My_SqliteHelper obj=new My_SqliteHelper(this, "dbb.db", null, 1);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		
		
		t1=(TextView)findViewById(R.id.textView_display);
		Cursor cur=getCur();
		mydisplay1(cur);
	}

	public Cursor getCur()
	{
		SQLiteDatabase db=obj.getReadableDatabase();
		Cursor cur=db.query(My_SqliteHelper.table1, null, null, null, null, null, null);
		startManagingCursor(cur);
		return cur;
	}
	
	public Cursor mydisplay1(Cursor cur)
	{
		StringBuilder str1=new StringBuilder();
		while(cur.moveToNext())
		{
			int id=cur.getInt(0);
			String name=cur.getString(1);
			String address=cur.getString(2);
			String phonem=cur.getString(3);
			String phoner=cur.getString(4);
			String email=cur.getString(5);
			String cname=cur.getString(6);
			String caddress=cur.getString(7);
			String cphone=cur.getString(8);
		//	String cfax=cur.getString(9);
			String cnotes=cur.getString(10);
			
			str1.append("_id="+id+"\n"+"NAME:"+name+"\n"+"ADDRESS:+"+address+"\n"+"PHONE_MOBILE:="+phonem+"\n"+"PHONE_RESI:"+phoner+"\n"+"E-MAIL:"+email+"\n"+"COMPANY NAME:"+cname+"\n"+"COMPANY ADDRESS:"+caddress+"\n"+"COMAPNY PHONE NO.:"+cphone+"\n"+"\n"+"NOTES:"+cnotes+"\n");
			
		}t1.setText(str1);
		return cur;
		
	}
		
		
	}

