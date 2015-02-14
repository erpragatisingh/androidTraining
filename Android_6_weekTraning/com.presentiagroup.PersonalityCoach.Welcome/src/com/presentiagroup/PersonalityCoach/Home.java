package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
	Button mButton16Type;
	Button mButtonScales;
	Button mButtonTemp;
	Button mButtonType2Type;
	Button mButton10Command;
	Button mButtonMBTIPrayer;
	Button mButtonMore;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mButton16Type = (Button)findViewById(R.id.imButton16Type);
        mButtonScales = (Button)findViewById(R.id.imButtonScales);
        mButtonTemp = (Button)findViewById(R.id.imButtonTemp);
        mButtonType2Type = (Button)findViewById(R.id.imButtonType2Type);
        mButton10Command = (Button)findViewById(R.id.imButton10Command);
       mButtonMBTIPrayer = (Button)findViewById(R.id.imButtonMBTIPrayer);
        mButtonMore = (Button)findViewById(R.id.imButtonMore);
        
        mButton16Type.setOnClickListener(this);
        mButtonScales.setOnClickListener(this);
        mButtonTemp.setOnClickListener(this);
        mButtonType2Type.setOnClickListener(this);
        mButton10Command.setOnClickListener(this);
        mButtonMBTIPrayer.setOnClickListener(this);
        mButtonMore.setOnClickListener(this);
        
    }
	@Override
	public void onClick(View v) 
	{
		if(v.equals(mButton16Type))
		{
			Intent intent = new Intent(Home.this, SixteenTypes.class);
			startActivity(intent);
		}
		else if(v.equals(mButtonScales))
		{
			Intent intent = new Intent(Home.this, FourScales.class);
			startActivity(intent);
		}
		else if(v.equals(mButtonTemp))
		{
			Intent intent = new Intent(Home.this, FourTemper.class);
			startActivity(intent);
		}
		else if(v.equals(mButtonType2Type))
		{
			Intent intent = new Intent(Home.this, TypeToType.class);
			startActivity(intent);
		}
		else if(v.equals(mButton10Command))
		{
			Intent intent = new Intent(Home.this, TenCommandments.class);
			startActivity(intent);
		}
		else if(v.equals(mButtonMBTIPrayer))
		{
			Intent intent = new Intent(Home.this, MBTIPrayers.class);
			startActivity(intent);
		}
		else if(v.equals(mButtonMore))
		{
			Intent intent = new Intent(Home.this, LearnMore.class);
			startActivity(intent);
		}
		
	}
}