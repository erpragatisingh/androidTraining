package com.splash;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

@SuppressWarnings("unused")
public class Manager {
	Context context;
	SQLiteDatabase database;
	final String TABLENAME = "tab1";
	final String DATABASENAME = "data1";
	final String ID = "_id";
	final String COLUMN1 = "title";
	final String COLUMN2 = "priority";
	final String COLUMN3 = "date";
	final String COLUMN4 = "task";
	final String COLUMN5 = "done";
	final String COLUMN6 = "Time";
	final int VERSION = 1;
	MyHelper helper;

	Manager(Context context1) {
		context = context1;
		helper = new MyHelper(context);
		database = helper.getWritableDatabase();
	}

	public void addRow(String s1, String s2, String s3, String s4, String s5) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN1, s1);
		cv.put(COLUMN2, s2);
		cv.put(COLUMN3, s3);
		cv.put(COLUMN4, s4);
		cv.put(COLUMN6, s5);
		cv.put(COLUMN5, "undone");
		database.insert(TABLENAME, null, cv);
		Log.d("log", "one row added");
	} 

	public Cursor getRow() {
		Cursor cursor;
		cursor = database.query(TABLENAME, new String[] { ID, COLUMN1, COLUMN2,
				COLUMN3, COLUMN4, COLUMN5, COLUMN6 }, null, null, null, null, null, null);
		return cursor;
	}

	public void deleteRow(long id) {
		database.delete(TABLENAME, ID + "=" + id, null);

	}

	public void deleteRow() {
		database.delete(TABLENAME, null, null);

	}

	public void updateRow(long id, String s1, String s2, String s3, String s4, String s5) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN1, s1);
		cv.put(COLUMN2, s2);
		cv.put(COLUMN3, s3);
		cv.put(COLUMN4, s4);
		cv.put(COLUMN6, s5);
		database.update(TABLENAME, cv, ID + "=" + id, null);
	}

	public void updateDone(long id, String s) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN5, s);
		database.update(TABLENAME, cv, ID + "=" + id, null);
	}

	public void updatePriority(long id, String s) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN2, s);
		database.update(TABLENAME, cv, ID + "=" + id, null);
	}

	public void updateDate(long id, String s) {
		ContentValues cv = new ContentValues();
		cv.put(COLUMN3, s);
		database.update(TABLENAME, cv, ID + "=" + id, null);
	}

	class MyHelper extends SQLiteOpenHelper {

		public MyHelper(Context context) {
			super(context, DATABASENAME, null, VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String query = "create table " + TABLENAME + " (" + ID
					+ " integer not null primary key autoincrement," + COLUMN1
					+ " text," + COLUMN2 + " text," + COLUMN3 + " text,"
					+ COLUMN4 + " text," + COLUMN5 + " text," + COLUMN6 + " text);";
			db.execSQL(query);
			Log.e("TableCreated", "table created successfully");
			// TODO Auto-generated method stub

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}

	}

}
