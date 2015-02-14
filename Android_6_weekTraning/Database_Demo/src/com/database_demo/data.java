package com.database_demo;

import java.util.jar.Attributes.Name;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class data
{
	public static final String DB_NAME="NNN21";
	public static final String DB_TABLENAME= "AAA12";
	final String COLUMN1 = "title";
	SQLiteDatabase sql;
	final String ID = "_id";

	public data(Context c1)
	{
		Databasee d1= new Databasee(c1);
		sql= d1.getWritableDatabase();
	}


	class Databasee extends SQLiteOpenHelper
	{

		public Databasee(Context context) {
			super(context, DB_NAME, null, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String query = "create table " + DB_TABLENAME + " (" + ID
			+ " integer not null primary key autoincrement," + COLUMN1
			+ " text);";
	db.execSQL(query);
		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub
			arg0.execSQL("DROP TABLE IF EXISTS"+DB_TABLENAME);
			onCreate(arg0);
		}
	}
		public void adddata(String s1)
		{
		
			ContentValues cv= new ContentValues();
			cv.put(COLUMN1, s1);
		//	cv.put("Pass", i1);
			sql.insert(DB_TABLENAME, null, cv);
			
			
			
		}
		
		public Cursor getData()
		{
			Cursor cursor;
			cursor= sql.query(DB_TABLENAME, new String[]{ ID, COLUMN1 }, null, null, null, null, null);
			return cursor;
			
		}
	}

	

