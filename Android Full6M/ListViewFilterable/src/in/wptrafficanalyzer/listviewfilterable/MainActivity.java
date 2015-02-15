package in.wptrafficanalyzer.listviewfilterable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	String[] countries = new String[] {
			"India",
            "Pakistan",
            "Sri Lanka",
            "China",
            "Bangladesh",
            "Nepal",
            "Afghanistan",
            "North Korea",
            "South Korea",
            "Japan"	
	};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Creating an array adapter to host the list view items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        
        // Get the reference of listview from the main layout
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
        
        // This statement enables text filtering in the listview 
        listView.setTextFilterEnabled(true);
        
        
    }
}