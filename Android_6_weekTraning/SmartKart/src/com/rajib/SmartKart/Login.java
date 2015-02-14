package com.rajib.SmartKart;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class Login extends Activity {

	private ProgressDialog qprogress;

	JSONParser jParser = new JSONParser();
	String EmailId,Password,Name;
	String EmailIdpassed,Passwordpassed;

	private static String URL_GET_USERS = "http://therajibdeb.com/SmartKart/GETUSERS.php";

	private static final String C_SUCCESS = "success";
	private static final String C_USERS = "Users";
	private static final String C_EMAILID = "EmailId";
	private static final String C_NAME =  "Name";
	private static final String C_PASSWORD = "Password";

	JSONArray users = null;
	//String EmailId, Name, Password;

	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	Intent i = getIntent(); 
	EmailIdpassed = i.getStringExtra("EmailId");
	Passwordpassed= i.getStringExtra("Password");
	new RetrieveUser().execute();
	
	}
	
	class RetrieveUser extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			qprogress = new ProgressDialog(Login.this);
			qprogress.setMessage("Getting user data. Please wait...");
			qprogress.setIndeterminate(false);
			qprogress.setCancelable(false);
			qprogress.show();
		}

		
		
		protected String doInBackground(String... parms) {
			// TODO Auto-generated method stub
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("EmailId", EmailIdpassed));
			
			
			JSONObject user_json = jParser.makeHttpRequest(URL_GET_USERS,
					"GET", params);
			try {
				int success = user_json.getInt(C_SUCCESS);
				Log.d("success_users", "rajib" + success);
				if (success == 1) 
				{
					users = user_json.getJSONArray(C_USERS);
					Log.d("Version", "rajib" + users);
					for (int i = 0; i < users.length(); i++) 
					{
						JSONObject c = users.getJSONObject(i);

						EmailId = c.getString(C_EMAILID);
						Log.d("EmailId", "rajib" + EmailId);
						
						Name = c.getString(C_NAME);
						Log.d("Name", "rajib" + Name);
						
						Password = c.getString(C_PASSWORD);
						Log.d("Password", "rajib" + Password);
						
						if (Password.equals(Passwordpassed))
						{
							Intent data = new Intent();
							data.putExtra("Name", Name);
							data.putExtra("EmailId", EmailId);

							setResult(1, data);
							finish();
						
						}else{
							Intent data = new Intent();
							setResult(0, data);
							finish();

						}
					}
				}else
				{
					Intent data = new Intent();
					setResult(0, data);
					finish();
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}

			
			return null;
		}
		protected void onPostExecute(String file_url) {
			qprogress.dismiss();
		}
	}

	
}
