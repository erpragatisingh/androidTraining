package in.wptrafficanalyzer.listviewcustomlayout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	String[] country = new String[] {
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
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_layout, country);
        
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        
    }
}