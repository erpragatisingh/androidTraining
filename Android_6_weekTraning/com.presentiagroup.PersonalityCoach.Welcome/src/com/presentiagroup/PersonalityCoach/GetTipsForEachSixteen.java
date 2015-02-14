package com.presentiagroup.PersonalityCoach;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class GetTipsForEachSixteen extends Activity
{
    /** Called when the activity is first created. */
	Button mbtnPaired;
	TextView mtvFirstType,mtvSecondType, mtvSecondTypeVal, mtvFirstTypeVal;
	Spinner mspOtherType,mspMyType;
	String Type[] = {"ENTP","ENFP","ENTJ","ENFJ","ESTP","ESFP","ESTJ","ESFJ","INTP","INFP","INTJ","INFJ","ISTP","ISFP","ISTJ","ISFJ"};
	Button mbtnBack;
	Button mbtnHome;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pairgeneral);
        mtvFirstType = (TextView)findViewById(R.id.tvFirstType);
        mtvSecondType = (TextView)findViewById(R.id.tvSecondType);
        mtvFirstTypeVal = (TextView)findViewById(R.id.tvFirstTypeVal);
        mtvSecondTypeVal = (TextView)findViewById(R.id.tvSecondTypeVal);
        mbtnPaired = (Button)findViewById(R.id.btnPaired);
        mspOtherType = (Spinner)findViewById(R.id.spOtherType);
        mspMyType = (Spinner)findViewById(R.id.spMyType);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.type, R.layout.type_list_item);
        adapter.setDropDownViewResource(R.layout.type_list_item);
        mspMyType.setAdapter(adapter);
        mspOtherType.setAdapter(adapter);
        mspOtherType.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
            public void onItemSelected(AdapterView<?> parent, View v,
                      int position, long id) 
            {
            	
            	mtvSecondTypeVal.setText(Type[position].toString());
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
				
			}
        });
        mspMyType.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
            public void onItemSelected(AdapterView<?> parent, View v,
                      int position, long id) 
            {
            	
				mtvFirstTypeVal.setText(Type[position].toString());
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0)
			{
				
				
			}
        });
        
        mbtnPaired.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{			
				Intent intent = new Intent(GetTipsForEachSixteen.this, PairInfo.class);
				intent.putExtra("firsttype", mtvFirstTypeVal.getText().toString());
				intent.putExtra("secondtype", mtvSecondTypeVal.getText().toString());
				startActivity(intent);
				
				
			}
		});
        mbtnHome = (Button)findViewById(R.id.btnHome);
		mbtnBack = (Button)findViewById(R.id.btnBack);
		mbtnHome.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View v) {
				
				finish();
				startActivity(new Intent(GetTipsForEachSixteen.this, Home.class));
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
    
}