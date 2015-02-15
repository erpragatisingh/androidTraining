package in.wptrafficanalyzer.listviewdemo;

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
        
        // ArrayAdapter is used to store an array of arbitrary objects
        // The second argument to the constructor is a resource id containing a textview for drawing each item in a view
        // android.R.layout.simple_list_item_1 is a built in layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);        
        ListView listView = (ListView) findViewById(R.id.listview);
        
        // ArrayAdapter indirectly implements ListAdapter interface
        listView.setAdapter(adapter);        
    }
}