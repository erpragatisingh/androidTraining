package in.wptrafficanalyzer.openalertdialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /** Instantiating the quit button of the layout file */
        Button quit = (Button) findViewById(R.id.btn_quit);
        
        /** Defining a click event  listener for the quit button */
        OnClickListener listener = new OnClickListener() {			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getFragmentManager();
				
				/** Instantiating the DialogFragment */
				MyAlertDialogWIndow alert = new MyAlertDialogWIndow();
				
				/** Opening the dialog window */
				alert.show(fm, "Alert_Dialog");
				
			}
		};
		
		/** Setting the click event listener for the button 'quit' */
        quit.setOnClickListener(listener);
    }
}