package com.example.contentproviderdemo1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class MyownCP extends ContentProvider{
	SQLiteDatabase sql;
	
	class Database extends SQLiteOpenHelper{

		public Database(Context context) {
			super(context, "DataName", null, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("create table tb(Name text, Pass text)");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		Long l1= sql.insert("tb", null, values);
		Uri u1= ContentUris.appendId(Uri.parse("content://data").buildUpon(),l1 ).build();
		
		
		return u1;
	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		Database d1= new Database(getContext());
		sql= d1.getWritableDatabase();
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Cursor c1=sql.query("tb", projection, selection, selectionArgs, null, null, null, null);
		return c1;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
