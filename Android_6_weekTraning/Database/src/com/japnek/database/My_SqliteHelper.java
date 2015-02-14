package com.japnek.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class My_SqliteHelper extends SQLiteOpenHelper {
    
	public static final String dbname="dba.db";
	public static final String dtable="preetvihar";
	public static final String user="user";
	public static final String pass="pass";
	public static final int dver=1;
	static
	{
		
	}
	public My_SqliteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="create table preetvihar" +
				"(_id integer primary key autoincrement,"
				+"user text not null,pass text not null);";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	 
	
	
	
	
	
	
}
