package in.wptrafficanalyzer.listviewradio;

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
        
        // Getting object reference to listview of main.xml
        ListView listView = (ListView) findViewById(R.id.listview);
        
        // Instantiating array adapter to populate the listView
        // The layout android.R.layout.simple_list_item_single_choice creates radio button for each listview item
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,countries);
        
        listView.setAdapter(adapter);
        
    }
}