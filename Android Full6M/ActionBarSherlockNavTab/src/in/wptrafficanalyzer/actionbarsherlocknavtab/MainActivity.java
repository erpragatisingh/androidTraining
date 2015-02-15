package in.wptrafficanalyzer.actionbarsherlocknavtab;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        actionBar.setDisplayShowTitleEnabled(true);
        
        Tab tab = actionBar.newTab()
        					.setText("Android")
        					.setTabListener(new AndroidFragment())
        					.setIcon(R.drawable.android);
        
        actionBar.addTab(tab);
        
        tab = actionBar.newTab()
				.setText("Apple")
				.setTabListener(new AppleFragment())
				.setIcon(R.drawable.apple);
        
        actionBar.addTab(tab);
        
        
    }  
    
}
