package in.wptrafficanalyzer.actionbaractionview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
    /** Callback function */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	/** Create an option menu from res/menu/items.xml */
    	getMenuInflater().inflate(R.menu.items, menu);
    	
    	/** Get the action view of the menu item whose id is search */ 
    	View v = (View) menu.findItem(R.id.search).getActionView();
    	
    	/** Get the edit text from the action view */
    	EditText txtSearch = ( EditText ) v.findViewById(R.id.txt_search);
    	
    	/** Setting an action listener */
    	txtSearch.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				Toast.makeText(getBaseContext(), "Search : " + v.getText(), Toast.LENGTH_SHORT).show();
				return false;
			}
		});
    	
    	return super.onCreateOptionsMenu(menu);
    }
}