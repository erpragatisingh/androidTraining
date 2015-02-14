package com.example.attendancemaster;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class My_SqliteHelper extends SQLiteOpenHelper {

	public static final String dbname = "attendancemaster.db";
	public static final String dtable = "attendance";
	public static final String dayno = "dayno";
	//public static final String day = "day";
	public static final String lec1 = "lec1";
	public static final String lec2 = "lec2";
	public static final String lec3 = "lec3";
	public static final String lec4 = "lec4";
	public static final String lec5 = "lec5";
	public static final String lec6 = "lec6";
	public static final String lec7 = "lec7";
	public static final String lec8 = "lec8";
	public static final int dver = 1;

	public My_SqliteHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table attendance(dayno integer primary key autoincrement,"
				+ "lec1 text not null,lec2 text not null,lec3 text not null,lec4 text not null,lec5 text not null,lec6 text not null,lec7 text not null,lec8 text not null);";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
