package ishan.bhatnagar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Fetching extends Activity{

	TextView t;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fetching);
		t=(TextView) findViewById(R.id.fet);
		Bundle b=getIntent().getExtras();
		String tea=b.getString("str");
		String winter=b.getString("str1");
		String str=b.getString("str2");
		t.append(tea+"\n"+winter+"\n"+str+"\n");
	}

}
