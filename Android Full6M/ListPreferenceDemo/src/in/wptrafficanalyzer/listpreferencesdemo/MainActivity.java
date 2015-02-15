package in.wptrafficanalyzer.listpreferencesdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends Activity implements OnPreferenceChangeListener {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /** Getting an instance of shared preferences, that is being used in this context */
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        
        /** Get the value stored in the share preferences corresponding to the key "lp_android_choice" */
        String android_choice = sp.getString("lp_android_choice", "None Selected");
        
        /** Getting an instance of the textview object corresponds to the layout in main.xml */
        TextView tv = (TextView) findViewById(R.id.android_version);
        
        /** Set the value to the textview object */
        tv.setText(android_choice);
        
    }
    
    /** This method is invoked by the ListPreference on changing its value */
    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {    	
    	TextView tv = (TextView) findViewById(R.id.android_version);
        tv.setText(newValue.toString());    	
    	return true;
    }    
    
}