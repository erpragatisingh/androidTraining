package japne.singh.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Calc extends Activity {
	
	Button b1;
	TextView t1;
	double a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        
        b1=(Button)findViewById(R.id.button1);
        t1=(TextView)findViewById(R.id.textView1);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				t1.setText("1");
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_calc, menu);
        return true;
    }
    
}
