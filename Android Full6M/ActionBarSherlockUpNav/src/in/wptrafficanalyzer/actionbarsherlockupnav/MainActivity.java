package in.wptrafficanalyzer.actionbarsherlockupnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                    Intent intent = new Intent("in.wptrafficanalyzer.actionbarsherlockupnav.second");
                    startActivity(intent);
            }
        };


		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(listener);
        
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    	getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
