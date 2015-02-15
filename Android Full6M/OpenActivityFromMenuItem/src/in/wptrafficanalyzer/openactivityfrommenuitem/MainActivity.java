package in.wptrafficanalyzer.openactivityfrommenuitem;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
	
	String[] articles = new String[] {
		"Floating contextual menu",
		"Contextual Action Bar",
		"Dropdown Navigation in Action Bar",
		"Navigation Tabs in Action Bar"
		
	};
	
	String[] article_urls = new String[] {
		"http://wptrafficanalyzer.in/blog/creating-a-floating-contextual-menu-in-android",
		"http://wptrafficanalyzer.in/blog/creating-a-contextual-menu-bar-contextual-action-mode-for-a-listview-in-android",
		"http://wptrafficanalyzer.in/blog/adding-drop-down-navigation-to-action-bar-in-android",
		"http://wptrafficanalyzer.in/blog/adding-navigation-tabs-containing-listview-to-action-bar-in-android"		
	};
	
	
	@Override
	protected void onStart() {
		super.onStart();
		/** Defining an array adapter to host list of articles */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, articles );
		
		/** Setting array adapter to the the listview */
        getListView().setAdapter(adapter);
	}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        
        /** Registering the listview for the contextual menu */
        registerForContextMenu(getListView());
    }
    
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    	
    	super.onCreateContextMenu(menu, v, menuInfo);
    	
    	/** Inflating the menu from activity_main.xml */
    	getMenuInflater().inflate(R.menu.activity_main, menu);    	
    	
    	
    	
    	AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
    	
    	/** Creating an intent, based on which the menu items will be populated */
    	Intent intent = new Intent(Intent.ACTION_VIEW);    	
    	
    	/** Creating a url object which points to the selected article's web page */
    	Uri uri = Uri.parse(article_urls[info.position]);
    	
    	
    	intent.setData(uri);
        
    	/** Adding menu items satisfying the intent properties */
        menu.addIntentOptions(
             Menu.NONE,  // Menu group to which new items will be added
             Menu.NONE,      	// Unique item ID (none)
             Menu.NONE,      	// Order for the items (none)
             this.getComponentName(),   // The current activity name
             null,   	// Specific items to place first (none)
             intent, 	// Intent created above that describes our requirements
             Menu.FLAG_APPEND_TO_GROUP,      	// Additional flags to control items
             null);  	// Array of MenuItems that correlate to specific items (none)        
    }
}