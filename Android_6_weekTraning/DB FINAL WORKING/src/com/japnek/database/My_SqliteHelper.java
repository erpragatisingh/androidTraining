package com.japnek.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class My_SqliteHelper extends SQLiteOpenHelper {

	public static final String dbname="d.db";
	public static final String dtable="ramansingh";
	public static final String user="user";
	public static final String pass="pass";
	public static final String email="email";
	public static final String address="address";
	//public static final String phone="ph_no";
	
	public static final int dver=1;
	
	
	public My_SqliteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql="create table ramansingh" +"(_id integer primary key autoincrement ,"+"user text not null,pass text not null,email text not null,address text not null);";
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
