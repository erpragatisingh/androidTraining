package jap.duc.proto;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendSms2 extends Activity {
	Button b1;
	EditText e1,e2;
	TextView t1,t2;
	SmsManager sm;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.sms);
	
	
	
	b1=(Button)findViewById(R.id.but1);
	e1=(EditText)findViewById(R.id.edt1);
	e2=(EditText)findViewById(R.id.edt2);
	t1=(TextView)findViewById(R.id.txt1);
	t2=(TextView)findViewById(R.id.txt2);
	b1.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			sm=SmsManager.getDefault();
			sm.sendTextMessage(e1.getText().toString(), null, e2.getText().toString(), null, null);
		}
	});
	
	
	
}



}


 