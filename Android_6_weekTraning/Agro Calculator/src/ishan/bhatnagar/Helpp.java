package ishan.bhatnagar;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Helpp extends SQLiteOpenHelper{
	
	public static final String database="agro.db";
	public static final String table="engine";
	public static final String crop="crop";
	public static final String winter="winter";
	public static final String temp="temperature";
	public Helpp(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase ar) {
		// TODO Auto-generated method stub
		String sdd="create table engine (crop text not null,winter text not null,temp text not null)";
		ar.execSQL(sdd);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
