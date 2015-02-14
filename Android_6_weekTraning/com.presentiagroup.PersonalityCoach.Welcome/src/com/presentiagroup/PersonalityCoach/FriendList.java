package com.presentiagroup.PersonalityCoach;


import com.presentiagroup.PersonalityCoach.PersonalityCoach.Friends;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FriendList extends Activity
{
	private PerCoachDBHelper mDbHelper;
	private static Cursor curFriends;
	private ListView mListView;
	public static final int ACTIVITY_EDITFriend = 1;
	private static final int DIALOG_YES_NO_LONG_MESSAGE = 2;
	public static final int ACTIVITY_ADDFriend = 4;
	private static long mFriendID;
	private EfficientAdapter m_adapter;
	Button mbtnBack;
	Button mbtnHome;
	String Type[] = {"ENTP","ENFP","ENTJ","ENFJ","ESTP","ESFP","ESTJ","ESFJ","INTP","INFP","INTJ","INFJ","ISTP","ISFP","ISTJ","ISFJ"};
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	try
    	{
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.friends_list);
    		
    		
    		mDbHelper = new PerCoachDBHelper(this);
    		mDbHelper.open();
    		fillData();
    		   		
    		Button btnADDFriend = (Button)findViewById(R.id.btnADDFriend);
    		mbtnHome = (Button)findViewById(R.id.btnHome);
    		mbtnBack = (Button)findViewById(R.id.btnBack);
    		mbtnHome.setOnClickListener(new View.OnClickListener() 
    		{			
    			@Override
    			public void onClick(View v) {
    				
    				finish();
    				startActivity(new Intent(FriendList.this, Home.class));
    			}
    		});
    		
    		mbtnBack.setOnClickListener(new View.OnClickListener() 
    		{
    			
    			@Override
    			public void onClick(View v) {
    				
    				finish();
    			}
    		});
    		btnADDFriend.setOnClickListener(new View.OnClickListener() 
    		{
				
				@Override
				public void onClick(View v) 
				{
					startActivityForResult(new Intent(FriendList.this, AddEditFriends.class),ACTIVITY_ADDFriend);
					
				}
			});
    	}
    	catch (Throwable er) 
		{
			Toast.makeText(this, "Error "+er.getMessage(), Toast.LENGTH_LONG).show();

		}
    	
    	
    	
    	
    	
    }
    private void fillData()
	{
		try
		{
			mListView = (ListView)findViewById(R.id.lvFriends);
			curFriends = mDbHelper.FetchAllFriends();
			startManagingCursor(curFriends);
			int[] listFields = new  int[] { R.id.tvFriend };
			String[] dbColumns = new String[] {Friends.name };
			m_adapter = new EfficientAdapter(this, R.layout.friends_list_item, curFriends, dbColumns,listFields);
			mListView.setAdapter(m_adapter);

			mListView.setOnItemClickListener(new OnItemClickListener() 
			{

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int position,
						long id) {
					
					Toast.makeText(FriendList.this, "Error "+position, Toast.LENGTH_LONG).show();

				}
			});
			

		}
		catch (Throwable er) 
		{
			Toast.makeText(this, "Error "+er.getMessage(), Toast.LENGTH_LONG).show();

		}
		
	}
   
 public class EfficientAdapter extends SimpleCursorAdapter implements OnClickListener {

          	
        private Context context;
        private Cursor currentCursor;
    	public EfficientAdapter(Context context, int layout, Cursor c,String[] from, int[] to) 
        {
			super(context, layout, c, from, to);
			this.currentCursor = c;
			this.context = context;
			
		}
		
        @Override
        public View getView(int position, View convertView, ViewGroup parent) 
        {
        	View v = convertView;
        	
        	if (v == null) 
             {
        		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            	v = inflater.inflate(R.layout.friends_list_item, null);
             }
        	currentCursor.moveToPosition(position);
            TextView tvFriend = (TextView) v.findViewById(R.id.tvFriend);
            TextView tvFriendType = (TextView) v.findViewById(R.id.tvFriendType);
            Button btnDeleteFriend = (Button) v.findViewById(R.id.btnDeleteFriend);
            Button btnEditFriend= (Button) v.findViewById(R.id.btnEditFriend);
            
           
            btnDeleteFriend.setOnClickListener(this);
            btnEditFriend.setOnClickListener(this);
            
            String name = currentCursor.getString(currentCursor.getColumnIndex(Friends.name));
            int intType = currentCursor.getInt(currentCursor.getColumnIndex(Friends.type));
           
            tvFriend.setText(Param.Convert(name));
            tvFriendType.setText(Type[intType].toString());
            
            tvFriend.setTag(position);
            btnDeleteFriend.setTag(position);
            btnEditFriend.setTag(position);
        	return (v);   
                
                 
        }
       

       	@Override
		public void onClick(View v) 
		{
			
			
			
			if(v.getId()==R.id.btnDeleteFriend)
			{
				Button btnDeleteFriend = (Button)v;
				Integer _pos= (Integer) btnDeleteFriend.getTag();
				currentCursor.moveToPosition(_pos);
				//Toast.makeText(context, "text-" + String.valueOf(_pos), Toast.LENGTH_LONG).show();
				
				currentCursor.moveToPosition(_pos);
				mFriendID = currentCursor.getInt(currentCursor.getColumnIndex(Friends._ID));
				FriendList.this.showDialog(DIALOG_YES_NO_LONG_MESSAGE);
			}
			if(v.getId()==R.id.btnEditFriend)
			{
				
				Button btnEditFriend = (Button)v;
				Integer _pos= (Integer) btnEditFriend.getTag();
				currentCursor.moveToPosition(_pos);
				
				long mFriendID = currentCursor.getInt(currentCursor.getColumnIndex(Friends._ID));
           		Intent intentEditMessage = new Intent(context,AddEditFriends.class);//MessageTemplateEditor.class);
        		intentEditMessage.putExtra(Friends._ID, mFriendID);
        		intentEditMessage.putExtra("action" , ACTIVITY_EDITFriend);
        		FriendList.this.startActivityForResult(intentEditMessage,ACTIVITY_EDITFriend);
        		
				
				
			}
		}

    }


	
	
	protected Dialog onCreateDialog(int id) 
	 {
	     switch (id) 
	     {
	        	case DIALOG_YES_NO_LONG_MESSAGE:
	       		return new AlertDialog.Builder(FriendList.this)
	            .setIcon(R.drawable.icon)
	            .setTitle("Confirmation")
	            .setMessage("Are you sure you want to delete this Friend/Colleague?")
	            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int whichButton) 
	                    {
	                    	mDbHelper.DeleteFriend(mFriendID);
	                    	fillData();
	        				return;
	                        
	                    }
	                })
	               .setNegativeButton("Cancel", new DialogInterface.OnClickListener() 
	                {
	                    public void onClick(DialogInterface dialog, int whichButton) 
	                    {
                      
	                    }
	                })
	                .create();
	        }
	        return null;
	 }
   
	protected void onActivityResult(int requestCode, int resultCode,Intent intent) 
	{
	    super.onActivityResult(requestCode, resultCode, intent);
	    switch(requestCode)
        {
        	case ACTIVITY_ADDFriend:
        	if( resultCode == RESULT_OK)
        	{
        		fillData();
        	}break;
        	case ACTIVITY_EDITFriend:
            	if( resultCode == RESULT_OK)
            	{
            		fillData();
            	}break;
        }	
	    
	}
    
}