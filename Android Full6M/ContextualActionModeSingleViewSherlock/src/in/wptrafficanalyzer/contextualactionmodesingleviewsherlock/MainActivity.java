package in.wptrafficanalyzer.contextualactionmodesingleviewsherlock;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.ActionMode.Callback;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {
	
	
	com.actionbarsherlock.view.ActionMode mMode;
	com.actionbarsherlock.view.ActionMode.Callback mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        TextView tvHello = (TextView) findViewById(R.id.tv_hello);
        
        mCallback = new Callback() {
			
        	/** Invoked whenever the action mode is shown. This is invoked immediately after onCreateActionMode */
			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {				
				return false;
			}
			
			/** Called when user exits action mode */
			@Override
			public void onDestroyActionMode(ActionMode mode) {
				mMode = null;				
			}
			
			/** This is called when the action mode is created. This is called by startActionMode() */
			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				mode.setTitle("Demo");
                getSupportMenuInflater().inflate(R.menu.context_menu, menu);
                return true;
			}
			
			/** This is called when an item in the context menu is selected */
			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				switch(item.getItemId()){
	                case R.id.action1:
	                        Toast.makeText(getBaseContext(), "Selected Action1 ", Toast.LENGTH_LONG).show();
	                        mode.finish();  // Automatically exists the action mode, when the user selects this action
	                        break;
	                case R.id.action2:
	                        Toast.makeText(getBaseContext(), "Selected Action2 ", Toast.LENGTH_LONG).show();
	                        break;
	                case R.id.action3:
	                        Toast.makeText(getBaseContext(), "Selected Action3 ", Toast.LENGTH_LONG).show();
	                        break;
				}
				return false;

			}
		};
		
		OnLongClickListener listener = new OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                    if(mMode!=null)
                            return false;
                    else
                            mMode = startActionMode(mCallback);
                    return true;
            }
		};

		tvHello.setOnLongClickListener(listener);
        
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    	getSupportMenuInflater().inflate(R.menu.activity_main, menu);
    	return super.onCreateOptionsMenu(menu);
    }
    
}
