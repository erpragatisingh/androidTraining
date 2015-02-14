package com.cpdemo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyOwnCP extends ContentProvider {
	SQLiteDatabase sqLiteDatabase;
class MyOpenHelper extends SQLiteOpenHelper{

	public MyOpenHelper(Context context) {
		super(context, "mydatabase", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table mytable(name text, password text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}}
	
	@Override
	public boolean onCreate() {
		MyOpenHelper helper = new MyOpenHelper(getContext());
		sqLiteDatabase = helper.getWritableDatabase();
		System.out.println("AAAAA");
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,String[] selectionArgs, String sortOrder) {
		Cursor cursor = sqLiteDatabase.query("mytable", projection, selection, selectionArgs, null, null, null);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long insert = sqLiteDatabase.insert("mytable", "", values);
		Uri tempuri = ContentUris.appendId(Uri.parse("content://def").buildUpon(), insert).build();
	//	getContext().getContentResolver().notifyChange(tempuri, null);
		return tempuri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
