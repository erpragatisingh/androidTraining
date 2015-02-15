package in.wptrafficanalyzer.actionbarsherlockmenu;

import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {    	
    	getSupportMenuInflater().inflate(R.menu.activity_main, menu);
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
