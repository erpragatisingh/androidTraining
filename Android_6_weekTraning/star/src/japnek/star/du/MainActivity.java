package japnek.star.du;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView t1;
	public int i,j;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuffer result=new StringBuffer();
        t1=(TextView)findViewById(R.id.textView1);
        for(i=0;i<5;i++)
        {
        	for(j=i;j<5;j++)
        	{
        		
        		result.append("*");
        		
        		
        		
        	}
        	result.append("\n");

        }
  
        t1.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
