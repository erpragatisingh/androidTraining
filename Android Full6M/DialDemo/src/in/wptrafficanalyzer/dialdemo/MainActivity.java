package in.wptrafficanalyzer.dialdemo;

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
        
        /** Defining an onclick listener */
        OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/** Get Telephone number Object*/
				EditText telNo = (EditText) findViewById(R.id.telNo);
				
				/** Get Telephone number String **/
				String strTelNo = telNo.getText().toString();
				
				/** Creating an intent which invokes an activity whose action name is ACTION_CALL */
				Intent intent = new Intent("android.intent.action.CALL");
				
				/** Creating a uri object to store the telephone number */
				Uri data = Uri.parse("tel:"+ strTelNo );
				
				/** Setting intent data */
				intent.setData(data);
				
				/** Starting the caller activity by the implicit intent */
				startActivity(intent);
				
			}
		};
        
        /** Getting reference to button of main.xml */
        Button btn = (Button) findViewById(R.id.btnCall);        
        
        /** Setting the event listener for the button */
        btn.setOnClickListener(listener);
        
        
    }
}