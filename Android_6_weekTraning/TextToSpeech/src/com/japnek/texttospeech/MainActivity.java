package com.japnek.texttospeech;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnInitListener {

	private int MY_DATA_CHECK_CODE = 0;
	private TextToSpeech tts;
	EditText inputText;
	Button speakButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		speakButton = (Button) findViewById(R.id.button1);
		inputText = (EditText) findViewById(R.id.editText1);
		speakButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = inputText.getText().toString();
				if (text != null && text.length() > 0) {
					Toast.makeText(MainActivity.this, "Saying" + text,
							Toast.LENGTH_LONG).show();
					tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
				}

			}
		});
		
		Intent checkintent =new Intent();
		checkintent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
		startActivityForResult(checkintent, MY_DATA_CHECK_CODE);
		
	}
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(requestCode==MY_DATA_CHECK_CODE)
		{
			if(resultCode==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
			{
				tts=new TextToSpeech(this, this);
			}
			else
			{
				Intent installment=new Intent();
				installment.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
				startActivity(installment);
			}
		}
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}



	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
		if(status==TextToSpeech.SUCCESS)
		{
			tts.setLanguage(Locale.ENGLISH);
			Toast.makeText(MainActivity.this, "Text to speech engine is initialised", Toast.LENGTH_LONG).show();
		}
		else if(status==TextToSpeech.ERROR)
		{
			Toast.makeText(MainActivity.this, "Error.....Text to speech engine is not initialised", Toast.LENGTH_LONG).show();	
		}
	
	}

}
