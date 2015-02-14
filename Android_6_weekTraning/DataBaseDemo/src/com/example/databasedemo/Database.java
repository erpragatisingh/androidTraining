package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
SQLiteDatabase sql;



	public Database(Context context) {
		super(context, "DB_Name", null, 1);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table mytab(Name Text, Pass Text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void AddData(String a1, String a2) {
		
		SQLiteDatabase sql= this.getWritableDatabase();
		ContentValues c1= new ContentValues();
		c1.put("Name", a1);
		c1.put("Pass", a2);
		sql.insert("mytab", null, c1);
		
		
	}
	public Cursor getData(){
		Cursor c1= sql.query("mytab", new String[]{"Name", "Pass"},null, null, null, null,null);
		return c1;
		
	}

}
