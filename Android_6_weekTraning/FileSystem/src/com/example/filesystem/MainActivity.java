package com.example.filesystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int READ_BLOCK_SIZE=100;
	private EditText textBox;
	Button saveButton,loadButton;
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textBox=(EditText)findViewById(R.id.editText1);
        saveButton=(Button)findViewById(R.id.button1);
        loadButton=(Button)findViewById(R.id.button2);
        saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str=textBox.getText().toString();
				try
				{
					FileOutputStream fout=openFileOutput("textFile.txt", MODE_PRIVATE);
					OutputStreamWriter osw=new OutputStreamWriter(fout);
					osw.write(str);
					osw.flush();
					osw.close();
					Toast.makeText(getBaseContext(), "File Saved", Toast.LENGTH_LONG).show();
					textBox.setText("");
				}
				catch(IOException ioe)
				{
					
				}
			}
		});
        
        loadButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try
				{
					FileInputStream fIn=openFileInput("textFile.txt");
					InputStreamReader isr=new InputStreamReader(fIn);
					char[] inputBuffer=new char[READ_BLOCK_SIZE];
					String s="";
					int charRead;
					while((charRead=isr.read(inputBuffer))>0)
					{
						String readString=String.copyValueOf(inputBuffer,0,charRead);
						s+=readString;
						inputBuffer=new char[READ_BLOCK_SIZE];
					}
					textBox.setText(s);
					Toast.makeText(getBaseContext(), "File loaded", Toast.LENGTH_LONG).show();
				}
				catch(IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
