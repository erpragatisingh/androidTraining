package com.raman.mathstable.test;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class ableview extends Activity implements OnInitListener {

	ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	private TextToSpeech ts;
	private int MY_DATA_CHECK_CODE=0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tableview);
		 
		b1=(ImageButton) findViewById(R.id.imageButton1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by one is equal to one".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		
		b2=(ImageButton) findViewById(R.id.imageButton2);
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by two is equal to two".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b3=(ImageButton) findViewById(R.id.imageButton3);
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 3 is equal to 3".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		
		b4=(ImageButton) findViewById(R.id.imageButton4);
		b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 4 is equal to 4".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b5=(ImageButton) findViewById(R.id.imageButton5);
		b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 5 is equal to 5".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b6=(ImageButton) findViewById(R.id.imageButton6);
		b6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 6 is equal to 6".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b7=(ImageButton) findViewById(R.id.imageButton7);
		b7.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 7 is equal to 7".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b8=(ImageButton) findViewById(R.id.imageButton8);
		b8.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 8 is equal to 8".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b9=(ImageButton) findViewById(R.id.imageButton9);
		b9.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 9 is equal to 9".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b10=(ImageButton) findViewById(R.id.imageButton10);
		b10.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 10 is equal to 10".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b11=(ImageButton) findViewById(R.id.imageButton11);
		b11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 11 is equal to 11".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		b12=(ImageButton) findViewById(R.id.imageButton12);
		b12.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String text="one multiplied by 12 is equal to 12".toString();
				ts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				
			}
		});
		
		
		
		
		Intent i = new Intent();
		i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(i, MY_DATA_CHECK_CODE);
		
		
		
		
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode==MY_DATA_CHECK_CODE){
			if(resultCode==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
				ts=new TextToSpeech(this, this);
				
				
				
			}
			else{
				Intent ins=new Intent();
				ins.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
				startActivity(ins);
				
			}
		}
		
	}


	
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }

	@Override
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		if(arg0==TextToSpeech.SUCCESS);
		{
			ts.setLanguage(Locale.ENGLISH);
			
			
		}
	
	}}