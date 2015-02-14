package du.ex.ja;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView t1,t2;
	Button b1;
	EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        e1=(EditText)findViewById(R.id.editText2);
        e2=(EditText)findViewById(R.id.editText1);
        b1=(Button)findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView1);
        t2=(TextView)findViewById(R.id.textView2);
        
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(e1.getText().toString()=="1234" && e2.getText().toString()=="1234")
				{
					Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(getApplicationContext(), "Login UnSuccessful.. Try Again", Toast.LENGTH_LONG).show();
				}
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
