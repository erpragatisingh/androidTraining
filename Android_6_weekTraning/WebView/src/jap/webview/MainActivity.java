package jap.webview;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView w=(WebView)findViewById(R.id.webView1);
        w.loadUrl("http://www.google.co.in");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
//    @Override
//    public void onBackPressed() {
//    	// TODO Auto-generated method stub
//    	//super.onBackPressed();
//    }
    int btnevent=0;
    
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	//super.onBackPressed();
    	
    	btnevent++;
    	
    	if (btnevent==2) {
    		super.onBackPressed();
			
		}
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	// TODO Auto-generated method stub
    	switch (keyCode) {
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			Toast.makeText(getApplicationContext(), "Home button pressed", 1).show();
			break;

		default:
			break;
		}
    	
    	return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
    	// TODO Auto-generated method stub
    	return super.onKeyUp(keyCode, event);
    }
}
