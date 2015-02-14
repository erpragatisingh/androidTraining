package com.mcq.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersDatabaseHandler extends SQLiteOpenHelper {
	 private static final int DATABASE_VERSION = 1;
	 
	    // Database Name
	    private static final String DATABASE_NAME = "usersManager";
	 
	    // Contacts table name
	    private static final String TABLE_USERS = "users";
	 
	    // Contacts Table Columns names
	    private static final String KEY_ID = "id";
	    private static final String KEY_NAME = "name";
	    private static final String KEY_PH_NO = "phone_number";
	    private static final String KEY_EMAIL = "email";
	    private static final String KEY_PASSWORD="password";
	    private static final String KEY_ADDRESS="address";
	   
	    
	 

	public UsersDatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("Creating table...\n");
		 String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
	                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
	                + KEY_PH_NO + " TEXT," + KEY_EMAIL + " TEXT," + KEY_PASSWORD + " TEXT," +  KEY_ADDRESS + " TEXT)";
	        db.execSQL(CREATE_CONTACTS_TABLE);
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
	
		 // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
 
        // Create tables again
        onCreate(db);
	}
	
	public void addContact(User contact) {
		System.out.println("addding row");
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_NAME, contact.getName()); // Contact Name
	    values.put(KEY_PH_NO, contact.getPhone()); // Contact Phone Number
	    values.put(KEY_EMAIL,contact.getEmail() );
	    values.put(KEY_PASSWORD, contact.getPassword());
	    values.put(KEY_ADDRESS, contact.getAddress());
	 
	    // Inserting Row
	    db.insert(TABLE_USERS, null, values);
	    db.close(); // Closing database connection
	}
	
	public User getContact(int id) {
		System.out.println("retrieving contact");
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
	            KEY_NAME, KEY_PH_NO,KEY_EMAIL,KEY_PASSWORD,KEY_ADDRESS }, KEY_ID + "=?",
	            new String[] { String.valueOf(id) }, null, null, null, null);
	    if (cursor != null)
	        cursor.moveToFirst();
	 
	    User contact = new User(cursor.getString(1),cursor.getString(3),cursor.getString(2),cursor.getString(4),cursor.getString(5));
	    cursor.close();
	    db.close();
	    // return contact
	    return contact;
	}
	
	public User getContact(String emailId, String password) {
		User contact = null;
		System.out.println("retrieving contact");
	    SQLiteDatabase db = this.getReadableDatabase();
	 
	    Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
	            KEY_NAME, KEY_PH_NO,KEY_EMAIL,KEY_PASSWORD,KEY_ADDRESS }, KEY_EMAIL + "=? AND " + KEY_PASSWORD + "=?",
	            new String[] { emailId,password }, null, null, null, null);
	    
	    if (cursor != null)
	        if(cursor.moveToFirst())
	        	contact = new User(cursor.getString(1),cursor.getString(3),cursor.getString(2),cursor.getString(4),cursor.getString(5));
	    
	    
	    	
	    cursor.close();
	    db.close();
	    // return contact
	    return contact;
	}

}
