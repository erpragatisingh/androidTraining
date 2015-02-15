package in.wptrafficanalyzer.implicitintentdemo;

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
        
        /** Defining a click event listener **/
        OnClickListener listener = new OnClickListener() {			
			@Override
			public void onClick(View v) {
				/** Creating an implicit intent using activities action name **/
				Intent intent = new Intent("in.wptrafficanalyzer.secondactivity");
				
				/** Accessing the intended activity */
				startActivity(intent);
				
			}
		};
        
        
        /** A reference to button object of the main.xml */
        Button btn = (Button) findViewById(R.id.btn);
        
        
        /** Setting and event listener for the button click */
        btn.setOnClickListener(listener);
        
        
    }
}