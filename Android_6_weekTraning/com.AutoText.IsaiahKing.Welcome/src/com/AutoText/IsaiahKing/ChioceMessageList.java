package com.AutoText.IsaiahKing;


//import com.IsaiahKing.AutoText.AutoText.MessageTemplate;
import com.AutoText.IsaiahKing.AutoText.MessageTemplate;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ChioceMessageList extends Activity
{
	Button mbtnSettings;
	Button mbtnAddMessage;
	private MessageDbAdapter mDbHelper;
	private static Cursor messageCursor;
	private ListView lv;
	public static final int ACTIVITY_EDITMESSAGE = 1;
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	try
    	{
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.choice_message_list);
    		lv = (ListView)findViewById(R.id.lvMessagermainchoice);
    		mDbHelper = new MessageDbAdapter(this);
    		mDbHelper.open();
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
			lv.setAdapter(new EfficientAdapter(this,messageCursor));
			lv.setOnItemClickListener(new OnItemClickListener() 
			{
				public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
			    {
					
					messageCursor.moveToPosition(position);
					String message = messageCursor.getString(messageCursor.getColumnIndex(MessageTemplate.MessageText));
					SharedPreferences settingsfile = getSharedPreferences(Settings.PREF_Name,Context.MODE_WORLD_WRITEABLE);
					Editor editMessage = settingsfile.edit();
					editMessage.putString(Settings.APP_messagetemplate, message);
					editMessage.commit();
					setResult(RESULT_OK);
					finish();
			    }
	     	});
		}
		catch (Throwable er) 
		{
			Toast.makeText(this, "Error "+er.getMessage(), Toast.LENGTH_LONG).show();

		}
		
	}
    private class EfficientAdapter extends CursorAdapter
	{
		private final LayoutInflater mInflater;
    	public EfficientAdapter(Context context, Cursor cursor)
    	{
    		super(context,cursor,true);
    		mInflater = LayoutInflater.from(context);
    	}

    	@Override
		public void bindView(View view, Context context, Cursor cursor) 
		{
			// TODO Auto-generated method stub
    		TextView t = (TextView) view.findViewById(R.id.tvMessagechoice);
    		t.setText(cursor.getString(cursor.getColumnIndex(MessageTemplate.MessageText)));
    		    		
		}

    	@Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) 
        {
			// TODO Auto-generated method stub
    		final View view = mInflater.inflate(R.layout.choice_message_list_item, parent, false);

			return view;

        }
		
		
	}
	 
}