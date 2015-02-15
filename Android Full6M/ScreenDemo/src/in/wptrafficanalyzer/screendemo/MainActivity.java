package in.wptrafficanalyzer.screendemo;

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
        
        /** An object to get Screen display metrics */
        DisplayMetrics metrics = new DisplayMetrics();
        
        /** Getting the screen display metrics */
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        
        /** Getting reference to TextView object of the main.xml file */
        TextView tvMetrics = (TextView) findViewById(R.id.tv_metrics);        
        
        /** Getting the screen density in dpi */        
        String density = Integer.toString(metrics.densityDpi);
        
        /** Getting the screen width and height in pixels */
        String resolution = Integer.toString(metrics.widthPixels) + "x" + Integer.toString(metrics.heightPixels);
        
        
        /** Converting Screen resolution in pixels into dp */
        float dp_w = ( metrics.widthPixels * 160 ) / metrics.xdpi;
        
        /** Converting Screen resolution in pixels into dp */
        float dp_h = ( metrics.heightPixels * 160 ) / metrics.ydpi;
        
        /** Getting the screen width and height in dp */
        String resolution_dp = Float.toString((int)dp_w) + "x" + Float.toString((int)dp_h);        
        
        /** Setting the density, width and height of the screen to the TextView object */ 
        tvMetrics.setText("Density : "+density + "\n" + "Resolution in pixels : " + resolution  + "\nResolution in dp : " + resolution_dp );        
        
    }
}