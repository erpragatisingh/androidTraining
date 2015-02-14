	package com.rajib.SmartKart;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 * THIS IS THE ENTRYPOINT.LOGIN SCREEN IS DISPLAYED
 */

public class MainActivity extends Activity implements OnClickListener {

	EditText editemail, editpwd;
	TextView tvmessage;

	/*
	 * LOG_CODE - RETURN CODE USED FOR THE LOGIN ACTIVITY REG_CODE - RETURN CODE
	 * USED FOR THE REGISTER ACTIVITY
	 */
	int LOG_CODE = 1;
	int REG_CODE = 2;
	String Name, EmailId;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editemail = (EditText) findViewById(R.id.editemail);
		editpwd = (EditText) findViewById(R.id.editpwd);
		Button btlogin = (Button) findViewById(R.id.btLogin);
		Button btregister = (Button) findViewById(R.id.btRegister);
		tvmessage = (TextView) findViewById(R.id.tvMessage);
		btregister.setOnClickListener(this);
		btlogin.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		/*
		 * IF SUCCESSFUL FROM LOGIN ACTIVITY INVOKE THE GETLISTOFBOOKS ACTIVITY
		 */
		if (requestCode == LOG_CODE && resultCode == 1) {

			// GET THE NAME AND EMAILID RETURNED FROM SUCCESSFUL LOGIN

			Name = data.getStringExtra("Name");
			EmailId = data.getStringExtra("EmailId");

			Intent nextintent = new Intent(getApplicationContext(),
					GetListofBooks.class);
			nextintent.putExtra("Name", Name);
			nextintent.putExtra("EmailId", EmailId);
			startActivity(nextintent);
		// IF UNSUCCESSFUL FROM REGISTRATION ACTIVITY
		} else if (requestCode == REG_CODE && resultCode == 3) {
			tvmessage.setTextColor(Color.parseColor("#FF0000"));
			tvmessage.setText("Registration Failed");

		//IF RE-ENTERED PASSWORD DOES NOT MATCH. THIS WILL NEVER EXECUTE AS I HAVE MOVED THE CODE TO REGISTER ACTIVITY
		} else if (requestCode == REG_CODE && resultCode == 2) {
			tvmessage.setTextColor(Color.parseColor("#FF0000"));
			tvmessage
					.setText("Re-entered password does not match with entered password");
		
		//IF UNSUCCESSFUL FROM LOGIN ACTIVITY
		} else {
			tvmessage.setTextColor(Color.parseColor("#FF0000"));
			tvmessage
					.setText("Userid or password is incorrect. Please try again");
		}
	}

	@Override
	public void onClick(View v) {
		// IF REGISTER BUTTON CLICKED
		if (v.getId() == R.id.btRegister) {
			Intent i = new Intent(getApplicationContext(), Register.class);
			startActivityForResult(i, REG_CODE);

		}
		// IF LOGIN BUTTON CLICKED
		if (v.getId() == R.id.btLogin) {
			Intent i = new Intent(getApplicationContext(), Login.class);
			i.putExtra("EmailId", editemail.getText().toString());
			i.putExtra("Password", editpwd.getText().toString());
			startActivityForResult(i, LOG_CODE);

		}

	}
}
