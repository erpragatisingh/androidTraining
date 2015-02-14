package com.sqlitedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqliteDemoActivity extends Activity {
	EditText nameEditText, passwordEditText, rowIDEditText;
	Button addButton;
	MyDatabaseManager databaseManager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		nameEditText = (EditText) findViewById(R.id.editText1);
		passwordEditText = (EditText) findViewById(R.id.editText2);
		rowIDEditText = (EditText) findViewById(R.id.editText3);
		addButton = (Button) findViewById(R.id.button1);
		databaseManager = new MyDatabaseManager(this);
		addButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
		//		 databaseManager.addRecord(nameEditText.getText().toString(),
		//		 passwordEditText.getText().toString());
	//			databaseManager.updateRecord(nameEditText.getText().toString(),
	//					passwordEditText.getText().toString(),
	//					Long.parseLong(rowIDEditText.getText().toString()));
	//			databaseManager.deleteRecord(Long.parseLong(rowIDEditText.getText().toString()));
//				databaseManager.deleteAllRecord();
//				nameEditText.setText("");
//				passwordEditText.setText("");
//				rowIDEditText.setText("");
//				ArrayList record = databaseManager.selectRecord(Long.parseLong(rowIDEditText.getText().toString()));
//				Toast.makeText(SqliteDemoActivity.this,
//						(String) record.get(0) + (String) record.get(1), 3000)
//						.show();
				ArrayList<ArrayList<String>> allRecords = databaseManager.getAllRecords();
				for (int i = 0; i < allRecords.size(); i++) {
					ArrayList<String> arrayList = allRecords.get(i);
					Toast.makeText(
							SqliteDemoActivity.this,
							(String) arrayList.get(0)+"  "
									+ (String) arrayList.get(1), Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}




