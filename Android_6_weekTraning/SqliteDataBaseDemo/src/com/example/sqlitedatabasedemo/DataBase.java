package com.example.sqlitedatabasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
	SQLiteDatabase sql;
	

	public DataBase(Context context) {
		super(context, "DB_NAME", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table mytable(Name text, RollNo text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void addData(String s1, String s2){
		sql= this.getWritableDatabase();
		ContentValues cv= new ContentValues();
		cv.put("Name", s1);
		cv.put("RollNo", s2);
		sql.insert("mytable", null, cv);
		
	}

}
