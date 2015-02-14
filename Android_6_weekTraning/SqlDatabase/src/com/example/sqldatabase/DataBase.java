package com.example.sqldatabase;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
	SQLiteDatabase sql;

	public DataBase(Context context) {
		super(context, "DBName", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table TBName(Username text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void addData(String s1){
		
		sql= this.getWritableDatabase();
		ContentValues cv= new ContentValues();
		cv.put("Username", s1);
		sql.insert("TBName", null, cv);
	}
public Cursor getData() {
	// TODO Auto-generated method stub
	Cursor c1= sql.query("TBName", new String[]{"Username"}, null, null, null, null, null);
	return c1;


}
}