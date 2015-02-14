package com.presentiagroup.PersonalityCoach;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FourTemper extends Activity implements OnClickListener
{
	/** Called when the activity is first created. */
	Button mbtnNT;
	Button mbtnNF;
	Button mbtnSP;
	Button mbtnSJ;
	Button mbtnOverview;
	Button mbtnBack;
	Button mbtnHome;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        
        mbtnNT = (Button)findViewById(R.id.btnNT);
        mbtnNF = (Button)findViewById(R.id.btnNF);
        mbtnSP = (Button)findViewById(R.id.btnSP);
        mbtnSJ = (Button)findViewById(R.id.btnSJ);
        mbtnOverview = (Button)findViewById(R.id.btnOverview);
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
        mbtnNT.setOnClickListener(this);
        mbtnNF.setOnClickListener(this);
        mbtnSP.setOnClickListener(this);
        mbtnSJ.setOnClickListener(this);
        mbtnOverview.setOnClickListener(this);
        
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				
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
		if(v.equals(mbtnNT))
		{
			Intent intent = new Intent(FourTemper.this, FourTemperInfo.class);
			intent.putExtra(Param.temp, Param.NT);
			startActivity(intent);
		}
		if(v.equals(mbtnNF))
		{
			Intent intent = new Intent(FourTemper.this, FourTemperInfo.class);
			intent.putExtra(Param.temp, Param.NF);
			startActivity(intent);
		}
		if(v.equals(mbtnSP))
		{
			Intent intent = new Intent(FourTemper.this, FourTemperInfo.class);
			intent.putExtra(Param.temp, Param.SP);
			startActivity(intent);
		}
		if(v.equals(mbtnSJ))
		{
			Intent intent = new Intent(FourTemper.this, FourTemperInfo.class);
			intent.putExtra(Param.temp, Param.SJ);
			startActivity(intent);
		}
		if(v.equals(mbtnOverview))
		{
			Intent intent = new Intent(FourTemper.this, FourTemperInfo.class);
			intent.putExtra(Param.temp, Param.TempOverview);
			startActivity(intent);
		}
	}
}