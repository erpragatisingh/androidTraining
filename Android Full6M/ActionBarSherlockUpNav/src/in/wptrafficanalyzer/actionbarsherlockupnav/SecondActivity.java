package in.wptrafficanalyzer.actionbarsherlockupnav;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class SecondActivity extends SherlockActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		
		/** Enabling Up navigation for this activity */
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		/** Setting up layout for this activity */
        setContentView(R.layout.second_layout);
	}
	
	/** This callback method will be invoked when the user selects up navigation icon from the action bar */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
	        case android.R.id.home:
	                Intent intent = new Intent(this,MainActivity.class);
	                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
	                startActivity(intent);
			}
		return super.onOptionsItemSelected(item);
	}

}
