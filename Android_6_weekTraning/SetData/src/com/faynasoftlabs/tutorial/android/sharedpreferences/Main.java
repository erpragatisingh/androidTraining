package com.faynasoftlabs.tutorial.android.sharedpreferences;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Class which shows how to store preferences
 *
 * @author FaYnaSoft Labs
 */
public class Main extends Activity {
	public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
	public static final String KEY_PRIVATE = "KEY_PRIVATE";
	public static final String PREFS_READ = "PREFS_READ";
	public static final String KEY_READ = "KEY_READ";
	public static final String PREFS_WRITE = "PREFS_WRITE";
	public static final String KEY_WRITE = "KEY_WRITE";
	public static final String PREFS_READ_WRITE = "PREFS_READ_WRITE";
	public static final String KEY_READ_WRITE = "KEY_READ_WRITE";

	private SharedPreferences sharedPreferences;

	private EditText privateField;
	private Button  privateBtn;
	private EditText readField;
	private Button  readBtn;
	private EditText writeField;
	private Button  writeBtn;
	private EditText read_writeField;
	private Button  read_writeBtn;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		privateField = (EditText) findViewById(R.id.privateId);
		privateBtn = (Button) findViewById(R.id.privateBtn);
		privateBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sharedPreferences = getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
				Editor prefsPrivateEditor = sharedPreferences.edit();
				prefsPrivateEditor.putString(KEY_PRIVATE, privateField.getText().toString());
				prefsPrivateEditor.commit();
				privateField.setText("");
			}
		});

		readField = (EditText) findViewById(R.id.readId);
		readBtn = (Button) findViewById(R.id.readBtn);
		readBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sharedPreferences = getSharedPreferences(PREFS_READ, Context.MODE_WORLD_READABLE);
				Editor prefsPrivateEditor = sharedPreferences.edit();
				prefsPrivateEditor.putString(KEY_READ, readField.getText().toString());
				prefsPrivateEditor.commit();
				readField.setText("");
			}
		});

		writeField = (EditText) findViewById(R.id.writeId);
		writeBtn = (Button) findViewById(R.id.writeBtn);
		writeBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sharedPreferences = getSharedPreferences(PREFS_WRITE, Context.MODE_WORLD_WRITEABLE);
				Editor prefsPrivateEditor = sharedPreferences.edit();
				prefsPrivateEditor.putString(KEY_WRITE, writeField.getText().toString());
				prefsPrivateEditor.commit();
				writeField.setText("");
			}
		});

		read_writeField = (EditText) findViewById(R.id.read_writeId);
		read_writeBtn = (Button) findViewById(R.id.read_writeBtn);
		read_writeBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				sharedPreferences = getSharedPreferences(PREFS_READ_WRITE, Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
				Editor prefsPrivateEditor = sharedPreferences.edit();
				prefsPrivateEditor.putString(KEY_READ_WRITE, read_writeField.getText().toString());
				prefsPrivateEditor.commit();
				read_writeField.setText("");
			}
		});
	}
}