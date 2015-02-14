package com.faynasoftlabs.tutorial.android.sharedpreferences.getdata;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Class which shows how to get preferences from other application
 * @author FaYnaSoft Labs
 *
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

	private EditText privateId;
	private EditText read;
	private EditText write;
	private EditText readWrite;
	private Button btn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		privateId = (EditText) findViewById(R.id.privateId);
		read = (EditText) findViewById(R.id.read);
		write = (EditText) findViewById(R.id.write);
		readWrite = (EditText) findViewById(R.id.read_write);
		btn = (Button) findViewById(R.id.btn);
		btn.requestFocus();

		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Context otherAppsContext = null;
				try {
					otherAppsContext = createPackageContext("com.faynasoftlabs.tutorial.android.sharedpreferences", 0);
				} catch (NameNotFoundException e) {
				}

				sharedPreferences = otherAppsContext.getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
				privateId.setText(sharedPreferences.getString(KEY_PRIVATE, "PRIVATE EMPTY"));

				sharedPreferences = null;

				sharedPreferences = otherAppsContext.getSharedPreferences(PREFS_READ, Context.MODE_WORLD_WRITEABLE);
				read.setText(sharedPreferences.getString(KEY_READ, "WORLD READ EMPTY"));

				sharedPreferences = null;

				sharedPreferences = otherAppsContext.getSharedPreferences(PREFS_WRITE, Context.MODE_WORLD_WRITEABLE);
				write.setText(sharedPreferences.getString(KEY_WRITE, "WORLD WRITE EMPTY"));

				sharedPreferences = null;

				sharedPreferences = otherAppsContext.getSharedPreferences(PREFS_READ_WRITE, Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
				readWrite.setText(sharedPreferences.getString(KEY_READ_WRITE, "WORLD READ WRITE EMPTY"));

				sharedPreferences = null;
			}
		});
	}
}