
package ducat.jap.customdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog(this);
        
        dialog.setContentView(R.layout.activity_main);
        dialog.setTitle("Custom Dialog Generated");
        TextView t=(TextView)dialog.findViewById(R.id.textView1);
        t.setText("This is Custom Dialog");
        dialog.show();
        setContentView(R.layout.next);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
