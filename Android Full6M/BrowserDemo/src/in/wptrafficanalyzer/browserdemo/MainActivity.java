package in.wptrafficanalyzer.browserdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        /** Getting a reference to the button object of the main.xml */
        Button btn = (Button) findViewById(R.id.btn_browse);
        
        OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/** Getting a reference to the textedit object of the main.xml */
				EditText txt = (EditText) findViewById(R.id.te_url);
				
				
				/** Creating a view action to display the website */
				Intent intent = new Intent("android.intent.action.VIEW");
				
				/** Setting up a uri object with a web address  */
				Uri data = Uri.parse("http://"+txt.getText().toString());
				
				/** Setting web address to the intent object as data */
				intent.setData(data);
				
				/** Start an activity that matches intent action and intent data */
				startActivity(intent);
				
			}
		};
		
		btn.setOnClickListener(listener);
        
    }
}