package in.wptrafficanalyzer.differentlayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        DisplayMetrics metrics = new DisplayMetrics();
        
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        /** Converting Screen resolution in pixels into dp */
        float dp_w = ( metrics.widthPixels * 160 ) / metrics.xdpi;
        
        /** Converting Screen resolution in pixels into dp */
        float dp_h = ( metrics.heightPixels * 160 ) / metrics.ydpi;
        
        /** Getting reference to TextView object of the main layout */
        TextView tvScreen  = (TextView) findViewById(R.id.tv_screen);
        
        /** Displaying Screen resolution in dp **/
        tvScreen.setText(Float.toString((int)dp_w) + "dp x " + Float.toString((int)dp_h) + "dp");        
    }
}