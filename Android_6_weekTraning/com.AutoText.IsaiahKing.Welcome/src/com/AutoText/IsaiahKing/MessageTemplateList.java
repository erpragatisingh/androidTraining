package com.AutoText.IsaiahKing;
import com.AutoText.IsaiahKing.AutoText.MessageTemplate;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageTemplateList extends Activity implements OnClickListener
{
	Button mbtnSettings;
	Button mbtnAddMessage;
	private MessageDbAdapter mDbHelper;
	private static Cursor messageCursor;
	private ListView lv;
	public static final int ACTIVITY_EDITMESSAGE = 1;
	private static final int DIALOG_YES_NO_LONG_MESSAGE = 2;
	public static final int ACTIVITY_ADDMESSAGE = 4;
	private Long mMessageID;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	try
    	{
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.message_list);
    		lv = (ListView)findViewById(R.id.lvMessagermain);
    		mDbHelper = new MessageDbAdapter(this);
    		mDbHelper.open();
    		mbtnSettings = (Button)findViewById(R.id.btnSettings);
    		mbtnAddMessage = (Button)findViewById(R.id.btnAddMessage);
    		mbtnSettings.setOnClickListener(this);
    		mbtnAddMessage.setOnClickListener(this);
    		fillData();
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
			messageCursor = mDbHelper.FetchAllMessage();
			startManagingCursor(messageCursor);
			lv.setAdapter(new MessageListAdapter(this));
			
		}
		catch (Throwable er) 
		{
			Toast.makeText(this, "Error "+er.getMessage(), Toast.LENGTH_LONG).show();

		}
		
	}
    /*
    @Override
    protected void onSaveInstanceState(Bundle outState) 
	{
        super.onSaveInstanceState(outState);
        outState.putLong(MessageTemplate._ID, mMessageID);
    }*/
    private class MessageListAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        //private Context context;
        public MessageListAdapter (Context context) 
        {
            mInflater = LayoutInflater.from(context);
            //this.context = context;
        }
                
        @Override
        public int getCount() 
        {
        	// TODO Auto-generated method stub
            return messageCursor.getCount();
        }
        
        @Override
        public Object getItem(int position) 
        {
        	// TODO Auto-generated method stub
           	return messageCursor; 
        }
        
        @Override
        public long getItemId(int position) 
        {
        	// TODO Auto-generated method stub
        	return 0;
        }
		
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) 
        {
             final ViewHolder holder;
           
             if (convertView == null) 
             {
            	 
            	 convertView = mInflater.inflate(R.layout.message_list_item, null);
                 holder = new ViewHolder();
                 holder.text = (TextView) convertView.findViewById(R.id.tvMessage);
                 holder.buttonDelete= (Button) convertView.findViewById(R.id.btnDeleteMsg);
                 holder.buttonEdit= (Button) convertView.findViewById(R.id.btnEditMsg);
                 holder.buttonEdit.setOnClickListener(new View.OnClickListener() 
              	 {
                	private int pos=position;
                   	@Override
              		public void onClick(View v) 
              		{
                		//Intent intent = new Intent(MessageTemplateList.this,MessageTemplateEditor.class);
                		//Toast.makeText(context, "Delete-" + String.valueOf(holder.buttonDelete.getId()), Toast.LENGTH_SHORT).show();
                   		
                   		messageCursor.moveToPosition(pos);
                   	    mMessageID = messageCursor.getLong(messageCursor.getColumnIndex(MessageTemplate._ID));
                   		Intent intentEditMessage = new Intent(MessageTemplateList.this,MessageTemplateEditor.class);
                		intentEditMessage.putExtra(MessageTemplate._ID,mMessageID);
                		intentEditMessage.putExtra("action" , ACTIVITY_EDITMESSAGE);
                		startActivityForResult(intentEditMessage,ACTIVITY_EDITMESSAGE);
                    }
              	 });
                 holder.buttonDelete.setOnClickListener(new View.OnClickListener() 
              	 { 
                	private int pos=position;
                	@Override
              		public void onClick(View v) 
              		{
                		messageCursor.moveToPosition(pos);
                   	    mMessageID = messageCursor.getLong(messageCursor.getColumnIndex(MessageTemplate._ID));
                		showDialog(DIALOG_YES_NO_LONG_MESSAGE);
                		
                    }
              	 });
                 convertView.setTag(holder);
                
            } else {
                // Get the ViewHolder back to get fast access to the TextView
                // and the ImageView.
                holder = (ViewHolder) convertView.getTag();
            }

            //Bind the data efficiently with the holder.
             messageCursor.moveToPosition(position);  	
             holder.text.setText(messageCursor.getString(messageCursor.getColumnIndex(MessageTemplate.MessageText)));
             //holder.buttonDelete.setId(messageCursor.getInt(messageCursor.getColumnIndex(MessageTemplate._ID)));
             //holder.buttonEdit.setId(messageCursor.getInt(messageCursor.getColumnIndex(MessageTemplate._ID)));
             return convertView;
        }

         class ViewHolder 
         {
            TextView text;
            Button buttonDelete;
            Button buttonEdit;
         }

    }

	public void onClick(View v)
	 	{
	    	 if(v.getId()==R.id.btnSettings)
	  		 {
	    		Intent intentSetting = new Intent(this,Settings.class);
	  			startActivity(intentSetting);
	  		 }
	    	 if(v.getId()==R.id.btnAddMessage)
	  		 {
	    		 Intent intentSetting = new Intent(this,MessageTemplateEditor.class);
		  		 startActivityForResult(intentSetting,ACTIVITY_ADDMESSAGE);
	  		 }
	 	}
	@Override
	protected Dialog onCreateDialog(int id) 
	 {
	     switch (id) 
	     {
	        	case DIALOG_YES_NO_LONG_MESSAGE:
	       		return new AlertDialog.Builder(MessageTemplateList.this)
	            .setIcon(R.drawable.alert_dialog_icon)
	            .setTitle("Confirmation")
	            .setMessage("Are you sure you want to delete this Message Template?")
	            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	             public void onClick(DialogInterface dialog, int whichButton) 
	                    {
	                    	mDbHelper.DeleteMessage(mMessageID);
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
    @Override
	protected void onActivityResult(int requestCode, int resultCode,Intent intent) 
	{
	    super.onActivityResult(requestCode, resultCode, intent);
	    switch(requestCode)
        {
        	case ACTIVITY_ADDMESSAGE:
        	if( resultCode == RESULT_OK)
        	{
        		fillData();
        	}break;
        	case ACTIVITY_EDITMESSAGE:
            	if( resultCode == RESULT_OK)
            	{
            		fillData();
            	}break;
        }	
	    
	}
	 
}