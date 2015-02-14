package ramansingh.newdatabase;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MYsqllitehlper extends SQLiteOpenHelper {

	static final String db_name="MyDb.db";
	static final String table_name="ramansingh";
	static final String key_day = "day";
	static final String key_work1="w1";
	static final String key_work2="w2";
	static final String dbversion="1";
	
	
	
	
	public MYsqllitehlper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
String sql= "create table ramansingh(day primary key not null ,"+"w1 not null,w2 not null);";
		arg0.execSQL(sql);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldversion, int newversion) {
		// TODO Auto-generated method stub

	}

}
