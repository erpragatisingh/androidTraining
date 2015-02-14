package com.presentiagroup.PersonalityCoach;



import com.presentiagroup.PersonalityCoach.PersonalityCoach.Friends;
import com.presentiagroup.PersonalityCoach.PersonalityCoach.My;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class GetTipsCommunication extends Activity
{
   
	 /** Called when the activity is first created. */
	Button mbtnPaired;
	TextView mtvFirstType,mtvSecondType, mtvSecondTypeVal, mtvFirstTypeVal,mtvColleagues;
	Spinner mspOtherType,mspMyType;
	String Type[] = {"ENTP","ENFP","ENTJ","ENFJ","ESTP","ESFP","ESTJ","ESFJ","INTP","INFP","INTJ","INFJ","ISTP","ISFP","ISTJ","ISFJ"};
	private PerCoachDBHelper mDbHelper;
	String[] aFirstName = null;
	Integer[] aFirstType = null;
	String[] aSecondName = null;
	Integer[] aSecondType = null;
	Cursor cFriends;
	int MyCount, OtherCount;
	Button mbtnBack;
	Button mbtnHome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pair);
        mDbHelper =  new PerCoachDBHelper(this);
        mDbHelper.open();
        
        mtvColleagues = (TextView)findViewById(R.id.tvColleagues);
        mtvColleagues.setText("Colleagues & Friends");
        mtvFirstType = (TextView)findViewById(R.id.tvFirstType);
        mtvSecondType = (TextView)findViewById(R.id.tvSecondType);
        mtvFirstTypeVal = (TextView)findViewById(R.id.tvFirstTypeVal);
        mtvSecondTypeVal = (TextView)findViewById(R.id.tvSecondTypeVal);
        mbtnPaired = (Button)findViewById(R.id.btnPaired);
        mspOtherType = (Spinner)findViewById(R.id.spOtherType);
        mspMyType = (Spinner)findViewById(R.id.spMyType);
        FillData();
        
        
    }
    
    public void FillData()
    {
    	int count=0;
    	cFriends = mDbHelper.FetchAllFriends();
    	startManagingCursor(cFriends);
    	Cursor cMy = mDbHelper.FetchMy();
    	startManagingCursor(cMy);
    	
    	MyCount = cFriends.getCount() + cMy.getCount();
    	OtherCount = cFriends.getCount();
    	
    	
    	aFirstName = new String[MyCount];
    	aFirstType = new Integer[MyCount];
    	aSecondName = new String[OtherCount];
    	aSecondType = new Integer[OtherCount];
    	
    	for(int i=0;i<cMy.getCount();i++)
    	{
    		cMy.moveToFirst();
    		aFirstName[i] = Param.Convert(cMy.getString(cMy.getColumnIndex(My.name)));
    		aFirstType[i] =  cMy.getInt(cMy.getColumnIndex(My.type));
    		count = count+1;
    	}
    	
    	for(int i=0;i<cFriends.getCount();i++)
    	{
    		cFriends.moveToPosition(i);
    		String name = Param.Convert(cFriends.getString(cFriends.getColumnIndex(Friends.name)));
    		int Type = cFriends.getInt(cFriends.getColumnIndex(Friends.type));
    		aFirstName[i+count] = name;
    		aFirstType[i+count] = Type;
    		aSecondName[i] = name;
    		aSecondType[i] = Type;
    	}
    	
    	/*
    	SimpleCursorAdapter adapter1
    	= new SimpleCursorAdapter(this,R.layout.frnd_type_list_item,cFriends,
    			new String[] {Friends.name}, new int[] {R.id.tvFriend}); */
    	
    	ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.frnd_type_list_item,aSecondName);
    	
    	adapter1.setDropDownViewResource(R.layout.frnd_type_list_item);	     
    	
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.frnd_type_list_item,aFirstName);
    	
        adapter.setDropDownViewResource(R.layout.frnd_type_list_item);
        mspMyType.setAdapter(adapter);
        mspOtherType.setAdapter(adapter1);
        mspOtherType.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
            public void onItemSelected(AdapterView<?> parent, View v,
                      int position, long id) 
            {
            	
            	if(OtherCount>0)
            	{
            		int TypeID = aSecondType[position];
            		mtvSecondTypeVal.setText(Type[TypeID].toString());
    		    				
            		/*
            		cFriends.moveToPosition(position);
            		int pos = cFriends.getInt(cFriends.getColumnIndex(Friends.type));
            		mtvSecondTypeVal.setText(Type[pos].toString());*/
            	}
            	else
            	{
            		mtvSecondTypeVal.setText("");
            	}
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
				
			}
        });
        mspMyType.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
            public void onItemSelected(AdapterView<?> parent, View v,
                      int position, long id) 
            {
            	int TypeID = aFirstType[position];
				mtvFirstTypeVal.setText(Type[TypeID].toString());
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
				
			}
        });
        
        mbtnPaired.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{	
				if(CheckValidation())
				{
					Intent intent = new Intent(GetTipsCommunication.this, PairInfo.class);
					intent.putExtra("firsttype", mtvFirstTypeVal.getText().toString());
					intent.putExtra("secondtype", mtvSecondTypeVal.getText().toString());
					startActivity(intent);
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
				startActivity(new Intent(GetTipsCommunication.this, Home.class));
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
    public boolean CheckValidation()
    {
    	boolean IsValid = false;
    	if(MyCount>0)
		{
    		IsValid = true;
		}
    	else
    	{
    		IsValid = false;
    		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    		alertDialog.setIcon(R.drawable.icon);
        	alertDialog.setTitle("First Name");
			alertDialog.setMessage("Please select First Name. Click Ok to Add.");
        	alertDialog.setButton("OK", new DialogInterface.OnClickListener() 
        	{
	             public void onClick(DialogInterface dialog, int which) 
	             {
	            	 startActivity(new Intent(GetTipsCommunication.this, AddEditMy.class) );  
	            	 alertDialog.dismiss();
	            	 finish();
	             }
	         	});
        	alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() 
        	{
	             public void onClick(DialogInterface dialog, int which) 
	             {
	            	 alertDialog.dismiss();
	             }
	         	});
        	alertDialog.show();
    	}
    	if(OtherCount>0)
		{
    		IsValid = true;
		}
    	else
    	{
    		IsValid = false;
    		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
    		alertDialog.setIcon(R.drawable.icon);
        	alertDialog.setTitle("Second Name");
			alertDialog.setMessage("Please select Second Name. Click Ok to add.");
        	alertDialog.setButton("OK", new DialogInterface.OnClickListener() 
        	{
	             public void onClick(DialogInterface dialog, int which) 
	             {
	            	 startActivity(new Intent(GetTipsCommunication.this, AddEditFriends.class) );  
	            	 alertDialog.dismiss();
	            	 finish();
	            	 
	             }
	         	});
        	alertDialog.setButton2("Cancel", new DialogInterface.OnClickListener() 
        	{
	             public void onClick(DialogInterface dialog, int which) 
	             {
	            	 alertDialog.dismiss();
	             }
	         	});
        	alertDialog.show();
    		
    	}
    	return IsValid;
    }
    
}