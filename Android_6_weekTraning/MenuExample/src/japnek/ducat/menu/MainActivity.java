package japnek.ducat.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView t;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        t=(TextView)findViewById(R.id.textView1);
               
    }

    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	switch(item.getItemId())
    	{
    	
    	case R.id.menu_settings:
    		Toast.makeText(getApplicationContext(), item.getTitle(),Toast.LENGTH_SHORT).show();
    		
    		break;
    	case R.id.item1:
    		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    		t.setText("You clicked on Edit Page option in the Menu");
    		break;
    	case R.id.item2:
    		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    		t.setText("You clicked on Create Folder option in the Menu");
    		break;
    	case R.id.item3:
    		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    		t.setText("You clicked on Search option in the Menu");
    		break;
    	case R.id.item4:
    		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    		break;
    	
    	
    	}
    	
		return super.onOptionsItemSelected(item);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
