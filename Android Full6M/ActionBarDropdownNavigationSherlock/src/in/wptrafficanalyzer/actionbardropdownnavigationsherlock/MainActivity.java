package in.wptrafficanalyzer.actionbardropdownnavigationsherlock;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockActivity;



public class MainActivity extends  SherlockActivity {
	
	/** An array of strings to populate dropdown list */
	String[] actions = new String[] {
		"Bookmark",
		"Subscribe",
		"Share"
	};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        /** Create an array adapter to populate dropdownlist */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.sherlock_spinner_item, actions);
        
        
        /** Enabling dropdown list navigation for the action bar */
        getSupportActionBar().setNavigationMode(com.actionbarsherlock.app.ActionBar.NAVIGATION_MODE_LIST);
        
        
        /** Defining Navigation listener */
        ActionBar.OnNavigationListener navigationListener = new OnNavigationListener() {
			
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				Toast.makeText(getBaseContext(), "Current Action : " + actions[itemPosition]  , Toast.LENGTH_SHORT).show();
				return false;
			}
		};
	
		/** Setting dropdown items and item navigation listener for the actionbar */
		getSupportActionBar().setListNavigationCallbacks(adapter, navigationListener);        
		adapter.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
 
        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    	getSupportMenuInflater().inflate(R.menu.activity_main, menu);
    	return super.onCreateOptionsMenu(menu);
    }    

    
}
