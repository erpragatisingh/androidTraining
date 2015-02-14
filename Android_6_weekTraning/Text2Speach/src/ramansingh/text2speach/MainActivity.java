package ramansingh.text2speach;

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
EditText et;
Button b1;
private int MY_DATA_CHECK_CODE=0;
private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   
    et=(EditText) findViewById(R.id.editText1);
    b1=(Button) findViewById(R.id.button1);
   
    b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String text=et.getText().toString();
			if(text!=null&&text.length()>0);
			Toast.makeText(MainActivity.this, "saying", 2000).show();
			tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
			
		}
	});
    		
    Intent ci=new Intent();
    ci.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
   startActivityForResult(ci,MY_DATA_CHECK_CODE);
   
    
    }

protected void onActivityResult(int requestCode,int resultCode,Intent data) {
	
	
	if(requestCode==MY_DATA_CHECK_CODE){
		if(resultCode==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
			tts=new TextToSpeech(this,this);
			
			
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
	public void onInit(int v2) {
		// TODO Auto-generated method stub
		if(v2==TextToSpeech.SUCCESS);
		{
			tts.setLanguage(Locale.ENGLISH);
			Toast.makeText(MainActivity.this,"SPEAKING PLZ WAIT"	, Toast.LENGTH_SHORT).show();
			
		}
	}
}

	