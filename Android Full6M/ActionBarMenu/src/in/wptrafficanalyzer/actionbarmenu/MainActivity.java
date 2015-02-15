package in.wptrafficanalyzer.actionbarmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.items, menu);
    	
    	return super.onCreateOptionsMenu(menu);
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	super.onOptionsItemSelected(item);
    	
    	switch(item.getItemId()){
	    	case R.id.phone:
	    		Toast.makeText(getBaseContext(), "You selected Phone", Toast.LENGTH_SHORT).show();
	    		break;
	    	
	    	case R.id.computer:
	    		Toast.makeText(getBaseContext(), "You selected Computer", Toast.LENGTH_SHORT).show();
	    		break;
	    		
	    	case R.id.gamepad:
	    		Toast.makeText(getBaseContext(), "You selected Gamepad", Toast.LENGTH_SHORT).show();
	    		break;
	    		
	    	case R.id.camera:
	    		Toast.makeText(getBaseContext(), "You selected Camera", Toast.LENGTH_SHORT).show();
	    		break;
	    		
	    	case R.id.video:
	    		Toast.makeText(getBaseContext(), "You selected Video", Toast.LENGTH_SHORT).show();
	    		break;
	    		
	    	case R.id.email:
	    		Toast.makeText(getBaseContext(), "You selected EMail", Toast.LENGTH_SHORT).show();
	    		break;
	    		
    	}
    	
    	return true;
    	
    }
    
    
}