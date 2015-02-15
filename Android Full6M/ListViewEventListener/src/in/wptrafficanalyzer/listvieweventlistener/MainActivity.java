package in.wptrafficanalyzer.listvieweventlistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        
        // Get the object reference of listview from the layout
        ListView listView = ( ListView ) findViewById(R.id.listview);
        
        // Instantiating an array adapter for listview
        ArrayAdapter< String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, countries);
        listView.setAdapter(adapter);
        
        //Defining an item click listener
        OnItemClickListener itemClickListener = new OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
        			long id) {
        		
        		// AdapterView is the parent class of ListView
        		ListView lv = (ListView) arg0;
        		if(lv.isItemChecked(position)){
        			Toast.makeText(getBaseContext(), "You checked " + countries[position], Toast.LENGTH_SHORT).show();
        		}else{
        			Toast.makeText(getBaseContext(), "You unchecked " + countries[position], Toast.LENGTH_SHORT).show();
        		}
        		
        	}
		};
		
		// Setting the ItemClickEvent listener for the listview
        listView.setOnItemClickListener(itemClickListener);       
    }
}