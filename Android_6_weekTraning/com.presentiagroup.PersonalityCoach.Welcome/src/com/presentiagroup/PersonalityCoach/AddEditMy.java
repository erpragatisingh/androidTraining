package com.presentiagroup.PersonalityCoach;

import com.presentiagroup.PersonalityCoach.PersonalityCoach.My;

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

public class AddEditMy extends Activity
{
    /** Called when the activity is first created. */
	Button mbtnSave;
	EditText metName;
	Spinner mspType;
	Button mbtnBack;
	Button mbtnHome;
	String Name, Type;
	TextView mtvTitle;
	private static int mMyID;
	private PerCoachDBHelper mDbHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my);
        mbtnSave = (Button)findViewById(R.id.btnSave);
        metName = (EditText)findViewById(R.id.etName);
        mspType = (Spinner)findViewById(R.id.spType);
        mtvTitle = (TextView)findViewById(R.id.tvTitle);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.type, R.layout.type_list_item);
        adapter.setDropDownViewResource(R.layout.type_list_item);
        mspType.setAdapter(adapter);
        
        mDbHelper = new PerCoachDBHelper(this);
		mDbHelper.open();
        Bundle extras = getIntent().getExtras();
        
        mMyID =  extras !=null?extras.getInt(My._ID) : 0;
        
        fillData();
               
        mbtnSave.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{			
				Name = metName.getText().toString().trim().toLowerCase();
				
				
				if(Name.length()>0)
				{
					mDbHelper.AddEditMY(Name, mspType.getSelectedItemPosition(), mMyID);
					finish();
					
				}
				else
				{
					AlertDialog alertDialog = new AlertDialog.Builder(AddEditMy.this).create();
					alertDialog.setIcon(R.drawable.icon);
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
				
			}
		});
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(AddEditMy.this, Home.class));
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
    	
    		Cursor cursor = mDbHelper.FetchMy();
    		startManagingCursor(cursor);
    		if(cursor!=null && cursor.getCount()>0)
    		{
    			mtvTitle.setText("Update your own Type");
    			mMyID =  cursor.getInt(cursor.getColumnIndex(My._ID));
    			metName.setText(Param.Convert(cursor.getString(cursor.getColumnIndex(My.name))));
    			mspType.setSelection(cursor.getInt(cursor.getColumnIndex(My.type)));
    		}
    	 	else
    	 	{
    	 		mtvTitle.setText("Enter your own Type");
    	 		mspType.setSelection(0);
    	 	}
    	
    }
    

}