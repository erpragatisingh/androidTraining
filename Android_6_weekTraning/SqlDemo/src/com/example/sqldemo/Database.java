package com.example.sqldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{
	SQLiteDatabase sql;

	public Database(Context context) {
		super(context, "DBNAME", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table TBNAME(Name text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	public void addData(String s1) {
		// TODO Auto-generated method stub
sql= this.getWritableDatabase();
ContentValues cv= new ContentValues();
cv.put("Name", s1);
sql.insert("TBNAME", null, cv);
	}

}
