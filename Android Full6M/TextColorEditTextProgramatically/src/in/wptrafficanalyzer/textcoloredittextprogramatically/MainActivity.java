package in.wptrafficanalyzer.textcoloredittextprogramatically;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText etColor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Getting reference to EditText 
		etColor = (EditText) findViewById(R.id.et_color);		
		
		// Setting an EditorActionListener for the EditText
		etColor.setOnEditorActionListener(new OnEditorActionListener() {			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				// Getting the user input text
				String color = v.getText().toString();
				try{
					// If user presssed Done button of the keyboard
					if(actionId == EditorInfo.IME_ACTION_DONE){
						// Changing the color the text
						etColor.setTextColor(Color.parseColor(color));
						
						// Showing a Toast message
						Toast.makeText(getBaseContext(), v.getText(), Toast.LENGTH_SHORT).show();
					}
				}catch(IllegalArgumentException e){
					Toast.makeText(getBaseContext(), "Invalid color. Enter color as eg : #a2fa34 ", Toast.LENGTH_SHORT).show();
				}catch(Exception e){
					Toast.makeText(getBaseContext(), "Invalid, enter color as eg : #a2fa34 ", Toast.LENGTH_SHORT).show();
				}
				// return false, means , continue to other handlers
				return false;
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