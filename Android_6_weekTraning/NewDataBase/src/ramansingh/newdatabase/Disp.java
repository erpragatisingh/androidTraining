package ramansingh.newdatabase;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Disp extends Activity {

	
	TextView t1;
	MYsqllitehlper obj=new MYsqllitehlper(this, "dba.db", null, 1, null);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.disp);
		t1=(TextView)findViewById(R.id.textView1);
		Cursor cur=getCur();
		mydisplay(cur);
	}

	public Cursor getCur()
	{
		SQLiteDatabase db=obj.getReadableDatabase();
		Cursor cur=db.query(MYsqllitehlper.db_name, null, null, null, null, null, null);
		startManagingCursor(cur);
		return cur;
	}
	
	public Cursor mydisplay(Cursor cur)
	{
		StringBuilder str=new StringBuilder();
		while(cur.moveToNext())
		{
			String day=cur.getString(0);
			String w1=cur.getString(1);
			String w2=cur.getString(1);

			
			
			
			str.append("day"+day+"\n"+"work1="+w1+"\n"+"work2="+w2+"\n");
			
		}t1.setText(str);
		return cur;
	}
}


