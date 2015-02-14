package com.sharedprefdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPrefDemoActivity extends Activity {
	/** Called when the activity is first created. */

	SharedPreferences sharedPreferences;
	Button button,clearButton;
	EditText nameEditText,passwordEditText;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		sharedPreferences = getSharedPreferences("pref1", MODE_PRIVATE);
		String name = sharedPreferences.getString("name", "");
		String password = sharedPreferences.getString("password", "");
		Toast.makeText(this, "Name "+name+"  "+"Password "+password, Toast.LENGTH_LONG).show();
		button = (Button)findViewById(R.id.button1);
		clearButton = (Button)findViewById(R.id.button2);
		nameEditText = (EditText)findViewById(R.id.editText1);
		passwordEditText = (EditText)findViewById(R.id.editText2);
		nameEditText.setText(name);
		passwordEditText.setText(password);

		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Editor editor = sharedPreferences.edit();
				editor.putString("name", nameEditText.getText().toString());
				editor.putString("password", passwordEditText.getText().toString());
				editor.commit();
				Intent intent = new Intent(SharedPrefDemoActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});
		clearButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Editor editor = sharedPreferences.edit();
				editor.clear();
				editor.commit();
			}
		});
	}
}