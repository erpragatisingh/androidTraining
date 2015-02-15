package in.wptrafficanalyzer.actionbarsherlockshareactionprovider;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.widget.ShareActionProvider;

public class MainActivity extends SherlockActivity {
	
	private ShareActionProvider mShareActionProvider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	/** Inflating the current activity's menu with res/menu/items.xml */
        getSupportMenuInflater().inflate(R.menu.items, menu);

        /** Getting the actionprovider associated with the menu item whose id is share */
        mShareActionProvider = (ShareActionProvider) menu.findItem(R.id.share).getActionProvider();

        
        /** Getting the target intent */
        Intent intent = getDefaultShareIntent();
        
        /** Setting a share intent */       
        if(intent!=null)
        	mShareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);

    }    
    
    /** Returns a share intent */
    private Intent getDefaultShareIntent(){    	
    	
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
        intent.putExtra(Intent.EXTRA_TEXT,"Sample Content !!!");
        return intent;
    }

    
    
    
}
