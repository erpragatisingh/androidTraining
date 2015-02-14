package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LearnMore extends Activity implements OnClickListener
{
    /** Called when the activity is first created. */
	Button mbtnPresntia;
	Button mbtnOKA;
	Button mbtnTakeMBTI;
	Button mbtnBack;
	Button mbtnHome;
	Button mbtnConnectUs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);
        
        mbtnPresntia = (Button)findViewById(R.id.btnPresntia);
        mbtnOKA = (Button)findViewById(R.id.btnOKA);
        mbtnTakeMBTI = (Button)findViewById(R.id.btnTakeMBTI);
        mbtnConnectUs = (Button)findViewById(R.id.btnConnectUs);
        mbtnPresntia.setOnClickListener(this);
        mbtnOKA.setOnClickListener(this);
        mbtnTakeMBTI.setOnClickListener(this);
        mbtnConnectUs.setOnClickListener(this);
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
		if(v.equals(mbtnPresntia))
		{
			Intent intent = new Intent(LearnMore.this, MoreInfo.class);
			intent.putExtra(Param.more, Param.presentia);
			startActivity(intent);
		}
		if(v.equals(mbtnOKA))
		{
			Intent intent = new Intent(LearnMore.this, MoreInfo.class);
			intent.putExtra(Param.more, Param.oka);
			startActivity(intent);
		}
		if(v.equals(mbtnTakeMBTI))
		{
			Intent intent = new Intent(LearnMore.this, MoreInfo.class);
			intent.putExtra(Param.more, Param.mbti);
			startActivity(intent);
		}
		if(v.equals(mbtnConnectUs))
		{
			startActivity(new Intent(LearnMore.this, ConnectWithUs.class));
		}
		
	}
}