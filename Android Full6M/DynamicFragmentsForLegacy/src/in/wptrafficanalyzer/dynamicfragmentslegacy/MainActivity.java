package in.wptrafficanalyzer.dynamicfragmentslegacy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Fragment hello = new HelloFragment();
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.add(R.id.fragment_container,hello);
				
				fragmentTransaction.commit();
				
			}
		};        
        
        Button btnLoad = (Button) findViewById(R.id.btn_load);
        btnLoad.setOnClickListener(listener);
        
    }
}