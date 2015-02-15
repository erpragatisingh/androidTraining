package in.trafficanaer.hellofragment;


import android.os.Bundle;
import in.wptrafficanalyzer.hellofragment.R;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}