package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Scales extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
	Button mbtnEI;
	Button mbtnSN;
	Button mbtnTF;
	Button mbtnJP;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scales);
        mbtnEI = (Button)findViewById(R.id.btnEI);
        mbtnSN = (Button)findViewById(R.id.btnSN);
        mbtnTF = (Button)findViewById(R.id.btnTF);
        mbtnJP = (Button)findViewById(R.id.btnJP);
        
        mbtnEI.setOnClickListener(this);
        mbtnSN.setOnClickListener(this);
        mbtnTF.setOnClickListener(this);
        mbtnJP.setOnClickListener(this);
        
    }
    @Override
	public void onClick(View v) 
	{
		if(v.equals(mbtnEI))
		{
			Intent intent = new Intent(Scales.this, SixteenTypesInfo.class);
			startActivity(intent);
		}
		if(v.equals(mbtnSN))
		{
			Intent intent = new Intent(Scales.this, SixteenTypesInfo.class);
			startActivity(intent);
		}
		if(v.equals(mbtnTF))
		{
			Intent intent = new Intent(Scales.this, SixteenTypesInfo.class);
			startActivity(intent);
		}
		if(v.equals(mbtnJP))
		{
			Intent intent = new Intent(Scales.this, SixteenTypesInfo.class);
			startActivity(intent);
		}
	}
}