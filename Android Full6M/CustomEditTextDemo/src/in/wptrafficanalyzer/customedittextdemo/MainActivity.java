package in.wptrafficanalyzer.customedittextdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /** Getting reference to the EditText widget of the main layout */
        EditText  edit = (EditText) findViewById(R.id.edit2);
        edit.setEnabled(false);       
        
    }
}