package com.rajib.SmartKart;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Activity implements OnClickListener {

	// Progress Dialog
	private ProgressDialog pDialog;

	JSONParser jsonParser = new JSONParser();
	Button btSubmit;
	EditText edEmailid;
	EditText edName;
	EditText edPassword;
	EditText edReenterPassword;
	TextView tvmessage;
	
	// url to create new user
	private static String URL_CREATE_USER = "http://therajibdeb.com/SmartKart/USERS.php";
	private static final String TAG_SUCCESS = "success";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        btSubmit = (Button) findViewById(R.id.btsubmit);
        edEmailid = (EditText)findViewById(R.id.editEmail);
        edName= (EditText)findViewById(R.id.editName);
        edPassword= (EditText)findViewById(R.id.editpassword);
        edReenterPassword = (EditText)findViewById(R.id.editcnfpassword);
        tvmessage = (TextView)findViewById(R.id.tvMessage);
        
        btSubmit.setOnClickListener(this);
}

    
	class CreateNewUser extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Register.this);
			pDialog.setMessage("Registration in progress..");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Creating user
		 * */
		protected String doInBackground(String... args) {
			String EmailId = edEmailid.getText().toString();
			String Name = edName.getText().toString();
			String Password = edPassword.getText().toString();
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("EmailId", EmailId));
			params.add(new BasicNameValuePair("Name", Name));
			params.add(new BasicNameValuePair("Password", Password));
			JSONObject json = jsonParser.makeHttpRequest(URL_CREATE_USER,
					"POST", params);
			
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// successfully created user
					Intent i = new Intent(getApplicationContext(), GetListofBooks.class);
					i.putExtra("Name", Name);
					i.putExtra("EmailId", EmailId);
					startActivity(i);
					finish();
				} else {
					// failed to create user
					Intent data = new Intent();
					setResult(3, data);
					finish();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			pDialog.dismiss();
		}

	}

    
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(edPassword.getText().toString().equals(edReenterPassword.getText().toString()))
		{
			new CreateNewUser().execute();	
		}
		else
		{
			tvmessage.setTextColor(Color.parseColor("#FF0000"));
			tvmessage.setText("Re-entered password does not match with entered password");
			
		}
		
		
	}
}
