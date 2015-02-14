package com.AutoText.IsaiahKing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
//import android.database.Cursor;
//import android.content.SharedPreferences.Editor;
import android.os.Bundle;
//import android.provider.Contacts.People;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends Activity implements OnClickListener
 
{
	/** Called when the activity is first created. */
	public static final String PREF_Name = "settings";
	public static final String APP_isActive = "isActive";
	public static final String APP_isAddressBookContact = "isAddressBookContact";
	public static final String APP_messagetemplate = "messagetemplate";
	private static final int ACTIVITY_SELECTMSG=5;
	Button mbtnAddEditDeleteMsg;
	Button mbtnSetMsg;
	CheckBox chkActive;
	SharedPreferences settingsfile;
	
	TextView tvMessageTemp;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        try
        {
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.settings);
        	/*
        	Cursor C = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        	startManagingCursor(C);
        	for(int position=0;position<C.getCount();position++)
        	{
        		C.moveToPosition(position);
        		String a =C.getString(C.getColumnIndex(People.NUMBER));
        		if(C.getString(C.getColumnIndex(People.NUMBER))=="9988595599")
        		{
        			Toast.makeText(this, C.getString(C.getColumnIndex(People.NUMBER)), Toast.LENGTH_LONG).show();
        		}
        		else
        		{
        			Toast.makeText(this, "Not Exits", Toast.LENGTH_LONG).show();
        		}
        	}*/
        	
        	SetDefaultSettings();
        	filldata();
          	
        }
        catch (Throwable er) 
		{
			Toast.makeText(this, "Error "+er.getMessage(), Toast.LENGTH_LONG).show();

		}
    }
    
     private void SetDefaultSettings()
     {
    	 settingsfile = getSharedPreferences(PREF_Name,0);
    	 Editor editorsettingsfile = settingsfile.edit();
     	 if(!settingsfile.contains(APP_isActive))
     	 {
     		    editorsettingsfile.putBoolean(APP_isActive, false);
     		    editorsettingsfile.commit();
     	 }
     	 if(!settingsfile.contains(APP_isAddressBookContact))
     	 {
     		editorsettingsfile.putBoolean(APP_isAddressBookContact, true);
     		editorsettingsfile.commit();
     	 }
     	 if(!settingsfile.contains(APP_messagetemplate))
     	 {
        		String message = "I'm currently in a meeting, soon as I'm done ill get back to you.";
        		editorsettingsfile.putString(APP_messagetemplate, message);
        		editorsettingsfile.commit();
       	 }
        	
     }
     private void filldata()
     {
    	 mbtnAddEditDeleteMsg = (Button)findViewById(R.id.btnAddEditDeleteMsg);
    	 mbtnSetMsg = (Button)findViewById(R.id.btnSetMsg);
    	 chkActive = (CheckBox)findViewById(R.id.Activate);
    	 tvMessageTemp = (TextView)findViewById(R.id.tvMessageTemplate);
    	 mbtnAddEditDeleteMsg.setOnClickListener(this);
    	 mbtnSetMsg.setOnClickListener(this);
    	 chkActive.setOnClickListener(this);
    	 RadioButton mrbAddBookContact = (RadioButton) findViewById(R.id.rbAddBookContact);
 		 RadioButton mrbAllContacts = (RadioButton) findViewById(R.id.rbAllContacts);
 		 mrbAddBookContact.setOnClickListener(this);
 		 mrbAllContacts.setOnClickListener(this);
 		 RadioGroup mrbgContact = (RadioGroup) findViewById(R.id.rbgContact);
 		 boolean isAddressBookContact=settingsfile.getBoolean(APP_isAddressBookContact,false);
 		 if(isAddressBookContact)
 		 {
 			mrbgContact.check(R.id.rbAddBookContact);
 		 }
 		 else
 		 {
 			mrbgContact.check(R.id.rbAllContacts);
 		 }
 		 boolean isActive=settingsfile.getBoolean(APP_isActive,false);
 		 if(isActive)
 		 {
 			chkActive.setChecked(true);
 		 }
 		 else
 		 {
 			chkActive.setChecked(false);
 		 }
 		String strMessage =settingsfile.getString(APP_messagetemplate,"");
 		tvMessageTemp.setText(strMessage);
     }
     public void onClick(View v)
 	{
    	 if(v.getId()==R.id.Activate)
  		 {
  			settingsfile = getSharedPreferences(PREF_Name,Context.MODE_WORLD_WRITEABLE);
  			Editor editorsettingsfile = settingsfile.edit();
  			//boolean isActive=settingsfile.getBoolean(APP_isActive,false);
  			if(chkActive.isChecked())
  			{
  				editorsettingsfile.putBoolean(APP_isActive, true);
  				editorsettingsfile.commit();
  			}
  			else
  			{
  				editorsettingsfile.putBoolean(APP_isActive, false);
  				editorsettingsfile.commit();
  			}
  			
  		}
    	 if(v.getId()==R.id.rbAddBookContact)
 		{
    		settingsfile = getSharedPreferences(PREF_Name,Context.MODE_WORLD_WRITEABLE);
    		Editor editorsettingsfile = settingsfile.edit();
    		editorsettingsfile.putBoolean(APP_isAddressBookContact, true);
  			editorsettingsfile.commit();
 		}
 		if(v.getId()==R.id.rbAllContacts)
 		{
 			settingsfile = getSharedPreferences(PREF_Name,Context.MODE_WORLD_WRITEABLE);
 			Editor editorsettingsfile = settingsfile.edit();
    		editorsettingsfile.putBoolean(APP_isAddressBookContact, false);
  			editorsettingsfile.commit();
 		}
 		
 		if(v.getId()==R.id.btnSetMsg)
 		{
 			Intent sintent = new Intent(this,ChioceMessageList.class);
 			startActivityForResult(sintent,ACTIVITY_SELECTMSG);
 		}
 		if(v.getId()==R.id.btnAddEditDeleteMsg)
 		{
 			Intent sintent = new Intent(this,MessageTemplateList.class);
 			startActivity(sintent);
 		}
 	}
     @Override
     protected void onActivityResult(int requestCode, int resultCode,Intent intent) 
     {
         super.onActivityResult(requestCode, resultCode, intent);
         switch(requestCode)
         {
         	case ACTIVITY_SELECTMSG:
         	if( resultCode == RESULT_OK)
         	{
         		filldata();
         	}break;
         }	
     }
       
}