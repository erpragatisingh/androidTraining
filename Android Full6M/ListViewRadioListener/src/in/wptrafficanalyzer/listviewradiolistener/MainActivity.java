package in.wptrafficanalyzer.listviewradiolistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	// String array of countries for the listview
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
        
        
        // Reference to listview object of the main layout
        ListView listView = (  ListView ) findViewById(R.id.listview);
        
        // Creating an array adapter for listView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, countries);
        listView.setAdapter(adapter);
        
        // Defining the item click listener for listView
        OnItemClickListener itemClickListener = new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        		Toast.makeText(getBaseContext(), "You selected :" + countries[position], Toast.LENGTH_SHORT).show();        		
        	}
		};
        
		// Setting the item click listener for listView 		
        listView.setOnItemClickListener(itemClickListener);
    }
}