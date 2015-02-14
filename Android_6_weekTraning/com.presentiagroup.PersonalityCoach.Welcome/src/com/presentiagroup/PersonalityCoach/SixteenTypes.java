package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SixteenTypes extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
	Button mbtnISTJ;
	Button mbtnISFJ;
	Button mbtnINFJ;
	Button mbtnINTJ;
	
	Button mbtnISTP;
	Button mbtnISFP;
	Button mbtnINFP;
	Button mbtnINTP;
	
	Button mbtnESTP;
	Button mbtnESFP;
	Button mbtnENFP;
	Button mbtnENTP;
	
	Button mbtnESTJ;
	Button mbtnESFJ;
	Button mbtnENFJ;
	Button mbtnENTJ;
	Button mbtnBack;
	Button mbtnHome;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixteentypes);
        mbtnISTJ = (Button)findViewById(R.id.btnISTJ);
        mbtnISFJ = (Button)findViewById(R.id.btnISFJ);
        mbtnINFJ = (Button)findViewById(R.id.btnINFJ);
        mbtnINTJ = (Button)findViewById(R.id.btnINTJ);
        
        mbtnISTP = (Button)findViewById(R.id.btnISTP);
        mbtnISFP = (Button)findViewById(R.id.btnISFP);
        mbtnINFP = (Button)findViewById(R.id.btnINFP);
        mbtnINTP = (Button)findViewById(R.id.btnINTP);
        
        mbtnESTP = (Button)findViewById(R.id.btnESTP);
        mbtnESFP = (Button)findViewById(R.id.btnESFP);
        mbtnENFP = (Button)findViewById(R.id.btnENFP);
        mbtnENTP = (Button)findViewById(R.id.btnENTP);
        
        mbtnESTJ = (Button)findViewById(R.id.btnESTJ);
        mbtnESFJ = (Button)findViewById(R.id.btnESFJ);
        mbtnENFJ = (Button)findViewById(R.id.btnENFJ);
        mbtnENTJ = (Button)findViewById(R.id.btnENTJ);
        
        mbtnISTJ.setOnClickListener(this);
        mbtnISFJ.setOnClickListener(this);
        mbtnINFJ.setOnClickListener(this);
        mbtnINTJ.setOnClickListener(this);
        
        mbtnISTP.setOnClickListener(this);
        mbtnISFP.setOnClickListener(this);
        mbtnINFP.setOnClickListener(this);
        mbtnINTP.setOnClickListener(this);
        
        mbtnESTP.setOnClickListener(this);
        mbtnESFP.setOnClickListener(this);
        mbtnENFP.setOnClickListener(this);
        mbtnENTP.setOnClickListener(this);
        
        mbtnESTJ.setOnClickListener(this);
        mbtnESFJ.setOnClickListener(this);
        mbtnENFJ.setOnClickListener(this);
        mbtnENTJ.setOnClickListener(this);
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
		if(v.equals(mbtnISTJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ISTJ);
			startActivity(intent);
		}
		if(v.equals(mbtnISFJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ISFJ);
			startActivity(intent);
		}
		if(v.equals(mbtnINFJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.INFJ);
			startActivity(intent);
		}
		if(v.equals(mbtnINTJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.INTJ);
			startActivity(intent);
		}
		
		if(v.equals(mbtnISTP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ISTP);
			startActivity(intent);
		}
		if(v.equals(mbtnISFP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ISFP);
			startActivity(intent);
		}
		if(v.equals(mbtnINFP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.INFP);
			startActivity(intent);
		}
		if(v.equals(mbtnINTP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.INTP);
			startActivity(intent);
		}
		
		
		if(v.equals(mbtnESTP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ESTP);
			startActivity(intent);
		}
		if(v.equals(mbtnESFP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ESFP);
			startActivity(intent);
		}
		if(v.equals(mbtnENFP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ENFP);
			startActivity(intent);
		}
		if(v.equals(mbtnENTP))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ENTP);
			startActivity(intent);
		}
		
		
		if(v.equals(mbtnESTJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ESTJ);
			startActivity(intent);
		}
		if(v.equals(mbtnESFJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ESFJ);
			startActivity(intent);
		}
		if(v.equals(mbtnENFJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ENFJ);
			startActivity(intent);
		}
		if(v.equals(mbtnENTJ))
		{
			Intent intent = new Intent(SixteenTypes.this, SixteenTypesInfo.class);
			intent.putExtra(Param.sixteen, Param.ENTJ);
			startActivity(intent);
		}
		
	}
}