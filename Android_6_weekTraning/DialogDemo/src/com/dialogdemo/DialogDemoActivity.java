package com.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;

public class DialogDemoActivity extends Activity {
    /** Called when the activity is first created. */
    
	
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.icon);
        builder.setTitle("Welcome");
        builder.setMessage("Hello, this is dialog demo");
        
        builder.setNegativeButton("No", new MyListner1());
        
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogDemoActivity.this, "yes", 3000).show();
			}
		});
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(DialogDemoActivity.this, "cancel", 3000).show();				
			}
		});
//        builder.setCancelable(false);
        builder.show();
    }
	
	class MyListner1 implements OnClickListener {

		public void onClick(DialogInterface dialog, int which) {
			Toast.makeText(DialogDemoActivity.this, "no", 3000).show();
		}
		
	}
}

