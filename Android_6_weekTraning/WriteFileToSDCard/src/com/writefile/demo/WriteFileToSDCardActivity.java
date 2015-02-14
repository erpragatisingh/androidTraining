package com.writefile.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WriteFileToSDCardActivity extends Activity {
	Button readButton,writeButton;
	EditText editText;
	TextView textView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        readButton = (Button)findViewById(R.id.readButton);
        writeButton = (Button)findViewById(R.id.writeButton);
        editText = (EditText)findViewById(R.id.edit);
        textView = (TextView)findViewById(R.id.textView);
        
        writeButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String message = editText.getText().toString();
				writeMessage(message);
			}
		});
        
        readButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String readMessage = readMessage();
				textView.setText(readMessage);
			}
		});
        
    }
    
    private void writeMessage(String myMessage){
    	File externalStorageDirectory = Environment.getExternalStorageDirectory();
    	File file = new File(externalStorageDirectory, "myfile.txt");
    	byte[] bytes = new String(myMessage).getBytes();
    	try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			outputStream.write(bytes);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    private String readMessage(){
    	File externalStorageDirectory = Environment.getExternalStorageDirectory();
    	File file = new File(externalStorageDirectory, "myfile.txt");
    	String line = "";
    	StringBuilder builder = new StringBuilder();
    	try {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return builder.toString();
    }
    
}








