package in.wptrafficanalyzer.listviewwithlistactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
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
        
        // Declaring ArrayAdapter for the default listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);
        
        // Setting ArrayAdapter for the default listview
        setListAdapter(adapter);
        
        // Defining ItemClick event Listener
        OnItemClickListener listener = new OnItemClickListener() {
        	
        	// This method will be triggered when an item in the listview is clicked ( or touched ) 
        	@Override
        	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
        		Toast.makeText(getBaseContext(), "You selected : " + countries[position], Toast.LENGTH_SHORT).show();
        	}
		};
    
		// Setting an ItemClickEvent Listener for the listview
		// In this example we are making use the default listview
        getListView().setOnItemClickListener(listener);        
    }        
}