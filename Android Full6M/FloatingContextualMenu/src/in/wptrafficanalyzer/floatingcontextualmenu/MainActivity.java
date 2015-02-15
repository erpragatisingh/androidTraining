package in.wptrafficanalyzer.floatingcontextualmenu;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	String[] countries = new String[] {
		"India",
		"Pakistan",
		"Bangladesh",
		"Sri Lanka",
		"Nepal",
		"Bhutan",
		"Burma",
		"China"
	};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        getListView().setAdapter(adapter);
        
        /** Registering context menu for the listview */
        registerForContextMenu(getListView());
        
    }
    
    
    /** This will be invoked when an item in the listview is long pressed */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, v, menuInfo);    	
    	getMenuInflater().inflate(R.menu.actions , menu);
    }
    
    
    /** This will be invoked when a menu item is selected */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	
    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    	
    	switch(item.getItemId()){
    		case R.id.cnt_mnu_edit:
    			Toast.makeText(this, "Edit : " + countries[info.position]  , Toast.LENGTH_SHORT).show();
    			break;
    		case R.id.cnt_mnu_delete:
    			Toast.makeText(this, "Delete : " + countries[info.position]  , Toast.LENGTH_SHORT).show();
    			break;
    		case R.id.cnt_mnu_share:
    			Toast.makeText(this, "Share : " + countries[info.position]  , Toast.LENGTH_SHORT).show();
    			break;
    		
    	}
    	return true;
    }
    
}