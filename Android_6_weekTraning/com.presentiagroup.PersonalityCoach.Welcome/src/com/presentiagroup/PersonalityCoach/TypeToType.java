package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TypeToType extends Activity implements OnClickListener
{
	/** Called when the activity is first created. */
	Button mbtnAddEditOwn;
	Button mbtnAddEditFriends;
	Button mbtnTips;
	Button mbtn16Tips;
	Button mbtnBrowse;
	Button mbtnBack;
	Button mbtnHome;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t2t);
        mbtnAddEditOwn = (Button)findViewById(R.id.btnAddEditOwn);
        mbtnAddEditFriends = (Button)findViewById(R.id.btnAddEditFriends);
        mbtnTips = (Button)findViewById(R.id.btnTips);
        mbtn16Tips = (Button)findViewById(R.id.btn16Tips);
        mbtnBrowse = (Button)findViewById(R.id.btnBrowse);
        
        
        mbtnAddEditOwn.setOnClickListener(this);
        mbtnAddEditFriends.setOnClickListener(this);
        mbtnTips.setOnClickListener(this);
        mbtn16Tips.setOnClickListener(this);
        mbtnBrowse.setOnClickListener(this);
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
		if(v.equals(mbtnAddEditOwn))
		{
			Intent intent = new Intent(TypeToType.this, AddEditMy.class);
			startActivity(intent);
		}
		if(v.equals(mbtnAddEditFriends))
		{
			Intent intent = new Intent(TypeToType.this, AddEditFriends.class);
			startActivity(intent);
		}
		if(v.equals(mbtnTips))
		{
			Intent intent = new Intent(TypeToType.this, GetTipsCommunication.class);
			startActivity(intent);
		}
		if(v.equals(mbtn16Tips))
		{
			Intent intent = new Intent(TypeToType.this, GetTipsForEachSixteen.class);
			startActivity(intent);
			
		}
		if(v.equals(mbtnBrowse))
		{
			Intent intent = new Intent(TypeToType.this, FriendList.class);
			startActivity(intent);
		}
		
		
	}
}