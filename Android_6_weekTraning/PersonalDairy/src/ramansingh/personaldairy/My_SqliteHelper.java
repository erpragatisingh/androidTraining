package ramansingh.personaldairy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class My_SqliteHelper extends SQLiteOpenHelper {

	public static final String dbname="dbb.db";
	public static final String table1="personaldairy";
	public static final String name="name";
	public static final String address="address";
	public static final String phonenumm="phonem";
	public static final String phonenumr="phoner";
	
	public static final String email="email";
	public static final String compname="cname";
	public static final String compaddress="caddress";
	public static final String compphone="cphone";
	//public static final String compfax="cfax";
	public static final String cnote="note";


	
	public static final int dver=1;
	
	
	public My_SqliteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="create table personaldairy(_id integer primary key autoincrement ,"+"name text not null,address text,phonenumm text,phonrnumr text,email text,compname text,compaddress text,cphone text,cnote text);";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
