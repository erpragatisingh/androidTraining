package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FourScales extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
	Button mbtnEI;
	Button mbtnSN;
	Button mbtnTF;
	Button mbtnJP;
	Button mbtnBack;
	Button mbtnHome;
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
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
		
		mbtnBack.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
    }
    @Override
	public void onClick(View v) 
	{
		if(v.equals(mbtnEI))
		{
			Intent intent = new Intent(FourScales.this, FourScalesInfo.class);
			intent.putExtra(Param.scale, Param.EI);
			startActivity(intent);
		}
		if(v.equals(mbtnSN))
		{
			Intent intent = new Intent(FourScales.this, FourScalesInfo.class);
			intent.putExtra(Param.scale, Param.SN);
			startActivity(intent);
		}
		if(v.equals(mbtnTF))
		{
			Intent intent = new Intent(FourScales.this, FourScalesInfo.class);
			intent.putExtra(Param.scale, Param.TF);
			startActivity(intent);
		}
		if(v.equals(mbtnJP))
		{
			Intent intent = new Intent(FourScales.this, FourScalesInfo.class);
			intent.putExtra(Param.scale, Param.JP);
			startActivity(intent);
		}
	}
}