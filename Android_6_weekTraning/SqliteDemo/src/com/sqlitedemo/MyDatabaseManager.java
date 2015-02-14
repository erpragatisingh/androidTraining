package com.sqlitedemo;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseManager {

	SQLiteDatabase sqdb;

	public MyDatabaseManager(Context context) {
		MyCustomOpenHelper helper = new MyCustomOpenHelper(context);
		sqdb = helper.getWritableDatabase();
	}

	public void addRecord(String uName, String uPassword) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", uName);
		contentValues.put("password", uPassword);
		try {
			sqdb.insert("myTab", null, contentValues);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRecord(String uName, String uPassword, long rowID) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("name", uName);
		contentValues.put("password", uPassword);
		sqdb.update("myTab", contentValues, "rowid = '" + rowID + "'", null);
	}
	
	public ArrayList selectRecord(long rowID) {
		ArrayList arrayList = new ArrayList();
		Cursor cursor = sqdb.query("myTab", new String[]{"name","password"}, "rowid = '" + rowID + "'", null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String password = cursor.getString(cursor.getColumnIndex("password"));
			arrayList.add(name);
			arrayList.add(password);
		}
		return arrayList;
	}
	
	public ArrayList<ArrayList<String>> getAllRecords() {
		ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
		Cursor cursor = sqdb.query("myTab", new String[]{"name","password"}, null, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			for (int i = 0; i < cursor.getCount(); i++) {
				ArrayList<String> list = new ArrayList<String>();
				String name = cursor.getString(cursor.getColumnIndex("name"));
				String password = cursor.getString(cursor.getColumnIndex("password")); // column index is no of column u r accessing.
				list.add(name);
				list.add(password);
				arrayList.add(list);
				cursor.moveToNext();
			}
		}
		return arrayList;
	}

	public void deleteRecord(long rowID) {
		sqdb.delete("myTab", "rowid = '" + rowID + "'", null);
	}
	
	public void deleteAllRecord() {
		sqdb.delete("myTab", null, null);
	}

	class MyCustomOpenHelper extends SQLiteOpenHelper {

		public MyCustomOpenHelper(Context context) {
			super(context, "my_db", null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("Create table myTab(name text, password text);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

}
