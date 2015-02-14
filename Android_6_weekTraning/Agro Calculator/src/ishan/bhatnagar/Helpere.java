package ishan.bhatnagar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Helpere extends SQLiteOpenHelper{
	
	public static final String database="agro.db";
	public static final String table="farmer";
	public static final String name="name";
	public static final String lastname="lastname";
	public static final String pass="pass";
	public static final String email="email";
	public static final String sex="sex";
	public Helpere(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public void onCreate(SQLiteDatabase v) {
		// TODO Auto-generated method stub
		String ag="create table farmer(name text not null,lastname text not null,pass text not null,email text not null,sex text not null)";
		v.execSQL(ag);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
