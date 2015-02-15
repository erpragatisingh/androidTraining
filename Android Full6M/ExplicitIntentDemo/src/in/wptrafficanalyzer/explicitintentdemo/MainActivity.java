package in.wptrafficanalyzer.explicitintentdemo;

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
        
        /** Getting a reference to the button exists in the main.xml **/
        Button btn = (Button) findViewById(R.id.btn_access);
        
        /** Defining a click listener for the button **/
        OnClickListener btnClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/** Creating an explicit intent to access the SecondActivity **/
				Intent intent = new Intent(getBaseContext(), SecondActivity.class);
				
				/** Starting the SecondActivity **/
				startActivity(intent);				
			}
		};
        
        btn.setOnClickListener(btnClickListener);
        
    }
}