package jap.duc.proto;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends Activity {

	Button b1,b2,b3,b4,b5;
	TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        t1=(TextView)findViewById(R.id.textView1);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(MainMenu.this,SendSms2.class);
				startActivity(i);
				//startActivity(new Intent("jap.duc.proto.SendSms"));
			}
		});
        
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainMenu.this,Browse1.class);
				startActivity(i);
				///startActivity(new Intent("jap.duc.proto.Browse"));
			}
		});
        
        b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainMenu.this,Rating.class);
				startActivity(i);
			}
		});
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }
    
}
