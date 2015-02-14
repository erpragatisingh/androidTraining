package com.presentiagroup.PersonalityCoach;



import com.presentiagroup.PersonalityCoach.PersonalityCoach.Friends;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddEditFriends extends Activity
{
    /** Called when the activity is first created. */
	Button mbtnSave;
	EditText metName;
	EditText metNote;
	Spinner mspType;
	Button mbtnBack;
	Button mbtnHome;
	String Name, Type, Note;
	String nameOld;
	TextView mtvTitle;
	private static long mFriendID;
	private PerCoachDBHelper mDbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendscolleag);
        
        mDbHelper = new PerCoachDBHelper(this);
		mDbHelper.open();
		
        mbtnSave = (Button)findViewById(R.id.btnSave);
        metName = (EditText)findViewById(R.id.etName);
        metNote = (EditText)findViewById(R.id.etNote);
        mspType = (Spinner)findViewById(R.id.spType);
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mtvTitle = (TextView)findViewById(R.id.tvTitle);
		
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.type, R.layout.type_list_item);
        adapter.setDropDownViewResource(R.layout.type_list_item);
        mspType.setAdapter(adapter);
        Bundle extras = getIntent().getExtras();
        mFriendID =  extras !=null?extras.getLong(Friends._ID) : 0;
        fillData();
        mbtnSave.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{			
				
				
				
				
				
				Name = metName.getText().toString().trim().toLowerCase();
				Note = metNote.getText().toString().trim();
				int type = mspType.getSelectedItemPosition();
				if(CheckValidation())
				{
					mDbHelper.AddEditFriend(Name,type, Note, mFriendID);
					finish();
					setResult(RESULT_OK);
				}
				
				
				
				
				
				
				
				
			}
		});
        
        
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(AddEditFriends.this, Home.class));
			}
		});
		
		mbtnBack.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
        
    }
    public void fillData()
    {
    	if(mFriendID>0)
    	{
    		mtvTitle.setText("Edit Friends and Colleagues");
    		Cursor cursor = mDbHelper.GetFriends(mFriendID);
    		startManagingCursor(cursor);
    		nameOld = Param.Convert(cursor.getString(cursor.getColumnIndex(Friends.name)));
    		metName.setText(nameOld);
    		metNote.setText(cursor.getString(cursor.getColumnIndex(Friends.note)));
    		mspType.setSelection(cursor.getInt(cursor.getColumnIndex(Friends.type)));
    		
    	}
    	else
    	{
    		mtvTitle.setText("Add Friends and Colleagues");
    		mspType.setSelection(-1);
    	}
    	
    }
    public boolean CheckValidation()
    {
    	boolean IsValid = false;
    	AlertDialog alertDialog = new AlertDialog.Builder(AddEditFriends.this).create();
		alertDialog.setIcon(R.drawable.icon);
    	if(Name.length()>0)
		{
    		
    		if(mDbHelper.CheckFriend(Name) && mFriendID==0)
        	{
        		IsValid = false;
    			
            	alertDialog.setTitle("Name");
    			alertDialog.setMessage("Already exists!!!");
            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
    	             public void onClick(DialogInterface dialog, int which) 
    	             {
    	                     return;
    	             }
    	         	});
            	alertDialog.show();
        	}
    		else if(mDbHelper.CheckFriend(Name) && mFriendID>0 && !nameOld.equalsIgnoreCase(Name))
    		{
    			IsValid = false;
    			alertDialog.setTitle("Name");
    			alertDialog.setMessage("Already exists!!!");
            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
    	             public void onClick(DialogInterface dialog, int which) 
    	             {
    	                     return;
    	             }
    	         	});
            	alertDialog.show();
    		}
    		else
    		{
    			IsValid = true;
    		}
        	
		}
		else
		{
			IsValid = false;
			
        	alertDialog.setTitle("Name");
			alertDialog.setMessage("Please enter Name.");
        	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int which) 
	             {
	                     return;
	             }
	         	});
        	alertDialog.show();
		}
    	
    	
    	
    	return IsValid;
    }
    
    
    
    
    
}