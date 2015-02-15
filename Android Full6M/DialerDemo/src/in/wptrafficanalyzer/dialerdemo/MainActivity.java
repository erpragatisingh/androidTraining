package in.wptrafficanalyzer.dialerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /** Referring to the button object of the main.xml layout */
        Button btn  = (Button) findViewById(R.id.btn);        
        
        /**	Defining a click event listener	*/
        OnClickListener listener = new OnClickListener() {			
			@Override
			public void onClick(View v) {				
				/** Creating an intent with the dialer's action name  */
				/** Since the intent is created with activity's action name, the intent is an implicit intent */
				Intent intent = new Intent("android.intent.action.DIAL");
				
				/** Starting the Dialer activity */
				startActivity(intent);
			}
		};
        
		/** Setting click event listener for the buttonS */
        btn.setOnClickListener(listener);
    }
}