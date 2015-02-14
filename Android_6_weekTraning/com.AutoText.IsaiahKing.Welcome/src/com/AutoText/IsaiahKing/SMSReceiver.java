package com.AutoText.IsaiahKing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
//import android.telephony.TelephonyManager;
import android.util.Log;
//import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver
{
	private static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";
	String msgSend;
	Boolean IsActive;
	//String imei;
	Boolean IsAddressBookContact;
		@Override
    public void onReceive(Context context, Intent intent) 
    {	
			
		   if(intent.getAction().equals(ACTION))               
            {
			   
			   Bundle bundle = intent.getExtras();
        		if (bundle != null) 
        		{
        		    //TelephonyManager mTelephonyMgr = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        			//imei = mTelephonyMgr.getDeviceId();
        		   SharedPreferences prefs = context.getSharedPreferences(Settings.PREF_Name,0);
       			   IsAddressBookContact = prefs.getBoolean(Settings.APP_isAddressBookContact,false);
       			   msgSend = prefs.getString(Settings.APP_messagetemplate,"I'm currently in a meeting, soon as I'm done ill get back to you.");
       			   IsActive = prefs.getBoolean(Settings.APP_isActive,false); 
       			   Object[] pdus = (Object[]) bundle.get("pdus");
       			   SmsMessage[] messages = null;

        			try
        			{ 
        				
                        //String imsi = mTelephonyMgr.getSubscriberId();
                       
                       
                       //if(imei.equals("359444022287525"))
	                   // {
        			   if(IsActive)
        			   {
        				   //This will put every new message into a array of SmsMessages. The message is received as a pdu,
        				   //and needs to be converted to a SmsMessage, if you want to get information about the message.
        				   
        				   messages = new SmsMessage[pdus.length];
        				   for (int i = 0; i < messages.length; i++)
        				   {
        					   messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
        				   }
        				   
        				   if (messages.length > -1) 
        				   {
        					  
        					   SmsManager m = SmsManager.getDefault();
        					   String destination = messages[0].getOriginatingAddress();
        					 
        						   if(IsAddressBookContact)
        						   {
        							   Cursor curPeople = context.getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        							   if(curPeople!=null)
        							   {
        								   for(int position=0;position<curPeople.getCount();position++)
        								   {
        									   curPeople.moveToPosition(position);
        									   //String a =curPeople.getString(curPeople.getColumnIndex(People.NUMBER));
        									   if(curPeople.getString(curPeople.getColumnIndex(People.NUMBER))==destination)
        									   {
        										  
        										   String text = msgSend + "\n\n sent via Auto Text";
        										   m.sendTextMessage(destination, null, text, null, null);
        										   curPeople.close();
        										   break;
        									   }
        								   
        								   }
        						  
        							   }
        						   
        						   }
        						   else
        						   {
        							   String text = msgSend + "\n\n sent via Auto Text";
        							   m.sendTextMessage(destination, null, text, null, null);
        						   }
        	                    }
        					   //Toast.makeText(context, messages[0].getOriginatingAddress(), Toast.LENGTH_LONG).show();
        				   }
        			   	//}
        			}
        			catch(Exception e)
        			{
        				Log.e("GetMessages", "fail", e);
        			} 
        		}
            }
    }
		
}
