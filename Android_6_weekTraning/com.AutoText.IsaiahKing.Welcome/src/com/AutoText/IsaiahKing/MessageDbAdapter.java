package com.AutoText.IsaiahKing;

import com.AutoText.IsaiahKing.AutoText.MessageTemplate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MessageDbAdapter 
{
	private static final String TAG = "MessageDbAdapter";
	private static final String DATABASE_NAME = "autotext.db";
    private static final int DATABASE_VERSION = 2;
    private static final String MESSAGE_TABLE_NAME = "messagetemplate";
    private final Context mCtx;
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;
	private static String DB_PATH = "/data/data/com.AutoText.IsaiahKing/databases/";
	private static final String[] Messages = new String[] {
        "I'm currently in a meeting, soon as I'm done ill get back to you.", 
        "Hey, I'm in class ill text you back when I'm out.", 
        "At work. Ill get back to you at a break or after work.", 
        "I'm driving, ill get back to you when i reach my destination.", 
        "I'm with a client right now soon as I'm available ill get back to you.", 
        "Let me text you back when I'm free.", 
        "I'm in a movie, ill text you back when I'm out.",
        "Busy, will get back to you soon.", 
        "Cant talk now, ill get with you later."
        };
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
			    		
			    	}
			    	else
			    	{
			 
			    	
			    		mDb = mDbHelper.getWritableDatabase();
			    		
			        	mDb.execSQL("create table " + MESSAGE_TABLE_NAME +
			                        "(_id integer primary key, "
			                        + "message text not null, "
			                        + "created integer, "
			                        + "modified integer);"
			                        );
			        	for(int i=0; i<Messages.length;i++)
			        	{
			        		mDb.execSQL("INSERT INTO "
                                + MESSAGE_TABLE_NAME
                                + " ("+MessageTemplate.MessageText+", "
                                	+MessageTemplate.CREATED_DATE+", "
                                	+MessageTemplate.MODIFIED_DATE+")"
                                + " VALUES ("
                                	+"\""+Messages[i].toString()+"\", "
                                	+Long.valueOf(System.currentTimeMillis())+", "
                                	+Long.valueOf(System.currentTimeMillis())
                                		+");"); 
			        	}
			    		
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
			    		
			     	}
			 
			    	if(checkDB != null)
			    	{
			 
			    		checkDB.close();
			 
			    	}
			 
			    	return checkDB != null ? true : false;
			    }
			    
			    public void openDataBase() throws SQLException
			    {			    	 
			    	
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
	public MessageDbAdapter(Context ctx) 
	{
	        this.mCtx = ctx;
	}
	public MessageDbAdapter open() throws SQLException 
    {
        mDbHelper = new DatabaseHelper(mCtx);
        try 
        { 
 			mDbHelper.createDataBase(); 
 		} 
        catch (SQLException sqle) 
	 	{ 
        	System.out.print("Unable to create database"); 
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
    public boolean AddNewMessage(String MessageText)
    {
    	ContentValues initialValues = new ContentValues();
    	initialValues.put(MessageTemplate.MessageText, MessageText);
    	initialValues.put(MessageTemplate.CREATED_DATE, Long.valueOf(System.currentTimeMillis()));
    	initialValues.put(MessageTemplate.MODIFIED_DATE, Long.valueOf(System.currentTimeMillis()));
    	return mDb.insert(MESSAGE_TABLE_NAME, null, initialValues)>0;
    }
    public boolean EditMessage(long MessageID, String MessageText)
    {
    	ContentValues initialValues = new ContentValues();
    	initialValues.put(MessageTemplate.MessageText, MessageText);
    	initialValues.put(MessageTemplate.MODIFIED_DATE, Long.valueOf(System.currentTimeMillis()));
    	return mDb.update(MESSAGE_TABLE_NAME,initialValues, MessageTemplate._ID + "=" + MessageID, null)>0;
    }
    public boolean DeleteMessage(long MessageID)
    {
    	return mDb.delete(MESSAGE_TABLE_NAME, MessageTemplate._ID + "=" + MessageID, null) > 0;
    	
    }
    public Cursor FetchAllMessage()throws SQLException
    {
    	Cursor mCursor = mDb.query(MESSAGE_TABLE_NAME, new String[] {MessageTemplate._ID,MessageTemplate.MessageText
                }, null, null, null, null, MessageTemplate.CREATED_DATE);
    	if(mCursor!=null)
    	{
    		mCursor.moveToNext();
    	}
    	
    	return mCursor;
    }
    public Cursor FetchMessagebyID(long MessageID)throws SQLException
    {
    	Cursor mCursor = mDb.query(true,MESSAGE_TABLE_NAME, 
        			new String[] {MessageTemplate.MessageText}, 
        			MessageTemplate._ID + "=" + MessageID, null,
                    null, null, null, null);
    	if (mCursor != null) 
    	{
    		mCursor.moveToFirst();
    	}
    	return mCursor;
    }
}
