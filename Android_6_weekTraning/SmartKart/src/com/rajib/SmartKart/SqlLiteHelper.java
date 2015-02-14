package com.rajib.SmartKart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLiteHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "books_db";
	public static final int DB_VERSION = 1;

	public static final String TABLE_BOOKS = "books_table";
	public static final String TABLE_VERSION = "version_table";
	public static final String COLUMN_VERSION = "VersionId";
	public static final String COLUMN_BOOKID = "BookId";
	public static final String COLUMN_BOOKNAME = "BookTitle";
	public static final String COLUMN_ISBN = "ISBN";
	public static final String COLUMN_BOOKAUTHOR = "BookAuthor";
	public static final String COLUMN_PRICE = "Price";
	public static final String COLUMN_INSTOCK = "InStock";
	public static final String COLUMN_IMAGE = "Image";

	private static final String CREATE_BOOKS = "create table books_table (BookId text primary key , "
			+ "ISBN text not null, BookTitle text not null,BookAuthor text not null,Price integer not null, "
			+ "Image BLOB);";

	private static final String CREATE_VERSION = "create table version_table (VersionId text primary key);";
	
	public SqlLiteHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_BOOKS); 
		db.execSQL(CREATE_VERSION); 

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	       // Drop older table if existed
		System.out.println("In upgrade");
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_BOOKS);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_VERSION);
  
        // Create tables again 
        onCreate(db); 


	}

}
