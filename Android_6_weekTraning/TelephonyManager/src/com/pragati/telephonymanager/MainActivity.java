package com.pragati.telephonymanager;

import com.javint.telephonymanager.R;

import android.R.string;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView1 = (TextView) findViewById(R.id.textView1);

		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String IMEINumber = tm.getDeviceId();
		String subscriberID = tm.getDeviceSoftwareVersion();
		String a = Build.MODEL;
		String SIMSerialNumber = tm.getSimSerialNumber();
		String networkCountryISO = tm.getNetworkCountryIso();
		String SIMCountryISO = tm.getSimCountryIso();
		String softwareVersion = tm.getDeviceSoftwareVersion();
		String voiceMailNumber = tm.getVoiceMailNumber();

		// Get the phone type
		String strphoneType = "";
		int call_State = tm.getCallState();
		switch (call_State) {
		case TelephonyManager.CALL_STATE_IDLE:

			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:

			break;
		case TelephonyManager.CALL_STATE_RINGING:

			break;
		default:
			break;
		}

		int Sim_State = tm.getSimState();

		switch (Sim_State) {
		case TelephonyManager.SIM_STATE_ABSENT:

			break;
		case TelephonyManager.SIM_STATE_NETWORK_LOCKED:

			break;
		case TelephonyManager.SIM_STATE_PIN_REQUIRED:

			break;
		case TelephonyManager.SIM_STATE_PUK_REQUIRED:

			break;
		case TelephonyManager.SIM_STATE_READY:

			break;
		case TelephonyManager.SIM_STATE_UNKNOWN:

			break;

		default:
			break;
		}

		int Data_State=tm.getDataState();
		
		switch (Data_State) {
		case TelephonyManager.DATA_ACTIVITY_IN:
			//Data connection activity: Currently receiving IP  traffic
			
			break;
case TelephonyManager.DATA_ACTIVITY_OUT:
			//Data connection activity: Currently sending IP traffic. 


			break;
case TelephonyManager.DATA_ACTIVITY_DORMANT:
	//Data connection is active, but physical link is down 


	
	break;
case TelephonyManager.DATA_ACTIVITY_INOUT:
	//Data connection activity: Currently both sending and receiving IP traffic. 




	
	break;

		default:
			break;
		}
		
		 
		String simSirlNum = tm.getSimSerialNumber();
		String Sim_operator = tm.getSimOperator();

		int phoneType = tm.getPhoneType();

		switch (phoneType) {
		case (TelephonyManager.PHONE_TYPE_CDMA):
			strphoneType = "CDMA";
			break;
		case (TelephonyManager.PHONE_TYPE_GSM):
			strphoneType = "GSM";
			break;
		case (TelephonyManager.PHONE_TYPE_NONE):
			strphoneType = "NONE";
			break;
		}

		// getting information if phone is in roaming
		boolean isRoaming = tm.isNetworkRoaming();

		String info = "Phone Details:\n";
		info += "\n IMEI Number:" + IMEINumber;
		// info+="\n SubscriberID:"+subscriberID;
		info += "\n Sim Serial Number:" + SIMSerialNumber;
		info += "\n Network Country ISO:" + networkCountryISO;
		info += "\n SIM Country ISO:" + SIMCountryISO;
		info += "\n Software Version:" + softwareVersion;
		info += "\n Voice Mail Number:" + voiceMailNumber;
		info += "\n Phone Network Type:" + strphoneType;
		info += "\n In Roaming? :" + isRoaming;

		textView1.setText(info);
	}

}
