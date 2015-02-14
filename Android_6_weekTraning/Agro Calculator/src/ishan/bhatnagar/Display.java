package ishan.bhatnagar;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends Activity{

	TextView tt;
	Helpere hlp=new Helpere(this, "agro.db", null,1);
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		tt=(TextView) findViewById(R.id.dis);
		Cursor c=getcur();
		Mydis(c);
	}
	public Cursor getcur(){
		SQLiteDatabase s=hlp.getReadableDatabase();
		Cursor cr=s.query(Helpere.table, null, null, null, null, null, null);
		startManagingCursor(cr);
		return cr;
	}
	public Cursor Mydis(Cursor c){
		StringBuilder s=new StringBuilder();
		while(c.moveToNext()){
			String name=c.getString(0);
			String pass=c.getString(2);
			s.append("name:---"+name+"\n\n"+"password:---"+pass+"\n\n");
		}
		tt.setText(s);
		return c;	
	}
}
