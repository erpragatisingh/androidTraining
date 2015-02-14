package com.presentiagroup.PersonalityCoach;



import com.presentiagroup.PersonalityCoach.PersonalityCoach.Friends;
import com.presentiagroup.PersonalityCoach.PersonalityCoach.My;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PerCoachDBHelper 
{
	private static final String TAG = "PerCoachDBHelper";
	private static final String DATABASE_NAME = "personalitycoach.db";
    private static final int DATABASE_VERSION = 2;
    private static final String tbl_FRIENDS = "friends";
    private static final String tbl_MY = "my";
    private final Context mCtx;
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;
	private static String DB_PATH = "/data/data/com.presentiagroup.PersonalityCoach/databases/";
	
	public class DatabaseHelper extends SQLiteOpenHelper 
	{
		 	DatabaseHelper(Context context) 
	        {
	            super(context, DATABASE_NAME, null, DATABASE_VERSION);
	        }
		 	 public void createDataBase()
			    {
		 		 	
			    	boolean dbExist = checkDataBase();
			 
			    	if(dbExist)
			    	{
			    		//do nothing - database already exist
			    	}
			    	else
			    	{
			 
			    		//By calling this method and empty database will be created into the default system path
			            //of your application so we are gonna be able to overwrite that database with our database.
			    		mDb = mDbHelper.getWritableDatabase();
			    		
			        	mDb.execSQL("create table " + tbl_FRIENDS +
			                        "(_id integer primary key, "
			                        + Friends.name +" text not null, "
			                        + Friends.type +" integer not null, "
			                        + Friends.note +" text not null "
			                        + ");"
			                        );
			        	mDb.execSQL("create table " + tbl_MY +
		                        "(_id integer primary key, "
		                        + My.name +" text not null, "
		                        + My.type +" integer not null "
		                        + ");"
		                        );
			        	
			        	
			    	}
			 
			    }

			    private boolean checkDataBase()
			    {
			 
			    	SQLiteDatabase checkDB = null;
			 
			    	try
			    	{
			    		String myPath = DB_PATH + DATABASE_NAME;
			    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
			 
			    	}
			    	catch(SQLiteException e)
			    	{
			    		//database does't exist yet.
			     	}
			 
			    	if(checkDB != null)
			    	{
			 
			    		checkDB.close();
			 
			    	}
			 
			    	return checkDB != null ? true : false;
			    }
			    
			    public void openDataBase() throws SQLException
			    {			    	 
			    	//Open the database
			        String myPath = DB_PATH + DATABASE_NAME;
			        mDb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
			    }

			    @Override
			    public synchronized void close() 
			    {
			    	if(mDb != null)
			    		mDb.close();
			    	    super.close();
			    }
			    
		        @Override
		        public void onCreate(SQLiteDatabase db) 
		        {
		        	        	
		        }
		        @Override
		        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
		        {	        	
		        	Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
		                    + newVersion + ", which will destroy all old data");
		            db.execSQL("DROP TABLE IF EXISTS folder");
		            onCreate(db);
		        }
	}
	public PerCoachDBHelper(Context ctx) 
	{
	        this.mCtx = ctx;
	}
	public PerCoachDBHelper open() throws SQLException 
    {
        mDbHelper = new DatabaseHelper(mCtx);
        try 
        { 
 			mDbHelper.createDataBase(); 
 		} 
        catch (SQLException sqle) 
	 	{ 
        	System.out.print("Unable to create database"); //throw new Error("Unable to create database"); 
	 	}
        
        try 
        {
           	mDbHelper.openDataBase();
     
     	}
        catch(SQLException sqle)
        {
       		throw sqle;
      	}

        
        return this;
    }
    	    
    public void close() 
    {
        mDbHelper.close();
    }
    public Cursor FetchMy()throws SQLException
    {
    	Cursor mCursor = mDb.query(tbl_MY, new String[] {My._ID,My.name,My.type
                }, null, null, null, null, My._ID);
    	if(mCursor!=null)
    	{
    		mCursor.moveToFirst();
    	}
    	
    	return mCursor;
    }
    
    public Cursor FetchAllFriends()throws SQLException
    {
    	Cursor mCursor = mDb.query(tbl_FRIENDS, new String[] {Friends._ID,Friends.name,Friends.type
                }, null, null, null, null, Friends.name);
    	if(mCursor!=null)
    	{
    		mCursor.moveToNext();
    	}
    	
    	return mCursor;
    }
    public Boolean CheckFriend(String name)throws SQLException
    {
    	
    	boolean IsExists = false;
    	Cursor mCursor = mDb.query(tbl_FRIENDS, new String[] {Friends._ID
        }, Friends.name+ " like '" + name+"'",null, null, null, null, null);
    	
    	if(mCursor!=null)
    	{
    		mCursor.moveToFirst();
    		if(mCursor.getCount()>0)
    		{
    			IsExists = true;
    		}
    		    		
    	}
     	return IsExists;
    }
    public Cursor GetFriends(long FriendID)throws SQLException
    {
    	Cursor mCursor = mDb.query(tbl_FRIENDS, new String[] {Friends._ID,
    			Friends.name,Friends.type,Friends.note}, Friends._ID + "=" + FriendID, null, null, null, null);
    	if(mCursor!=null)
    	{
    		mCursor.moveToFirst();
    	}
    	
    	return mCursor;
    }
    public boolean AddEditFriend(String name,int type,String note,long FriendID)
    {
    	ContentValues initialValues = new ContentValues();
    	initialValues.put(Friends.name, name);
    	initialValues.put(Friends.type, type);
    	initialValues.put(Friends.note, note);
    	if(FriendID==0)
    	{
    		return mDb.insert(tbl_FRIENDS, null, initialValues)>0;
    	}
    	else
    	{
    		return mDb.update(tbl_FRIENDS,initialValues, Friends._ID + "=" + FriendID, null)>0;
    	}
    }
    public boolean DeleteFriend(long FriendID)
    {
    	return mDb.delete(tbl_FRIENDS, Friends._ID + "=" + FriendID, null) > 0;
    	
    }
    
    public boolean AddEditMY(String name,int type, int MyID)
    {
    	ContentValues initialValues = new ContentValues();
    	initialValues.put(My.name, name);
    	initialValues.put(My.type, type);
    	if(MyID==0)
    	{
    		return mDb.insert(tbl_MY, null, initialValues)>0;
    	}
    	else
    	{
    		return mDb.update(tbl_MY,initialValues, My._ID + "=" + MyID, null)>0;
    	}
    	
    }
   
}
