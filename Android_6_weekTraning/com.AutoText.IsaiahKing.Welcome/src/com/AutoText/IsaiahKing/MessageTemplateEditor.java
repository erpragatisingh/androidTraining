package com.AutoText.IsaiahKing;

import com.AutoText.IsaiahKing.AutoText.MessageTemplate;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MessageTemplateEditor extends Activity 
{
	private static final int REVERT_ID = Menu.FIRST;
	private static final int SAVE_ID = Menu.FIRST + 1;
	private Long mMessageID;
	private MessageDbAdapter mDbHelper;
	private boolean IsReturn = false;
	Integer action;
	EditText mText;
	String addMessage;
	private AlertDialog alertDialog;
	public static class LinedEditText extends EditText {
        private Rect mRect;
        private Paint mPaint;

        // we need this constructor for LayoutInflater
        public LinedEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            
            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(0x00000000);
        }
        
        @Override
        protected void onDraw(Canvas canvas) {
            int count = getLineCount();
            Rect r = mRect;
            Paint paint = mPaint;

            for (int i = 0; i < count; i++) {
                int baseline = getLineBounds(i, r);

                canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
            }

            super.onDraw(canvas);
        }
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_editor);
        mDbHelper = new MessageDbAdapter(this);
		mDbHelper.open();
        Bundle extras = getIntent().getExtras();
        mMessageID = savedInstanceState!=null ? savedInstanceState.getLong(MessageTemplate._ID): null;
	    if(mMessageID == null)
		{
			mMessageID = extras !=null? extras.getLong(MessageTemplate._ID) : null;
		}
	    action = extras !=null? extras.getInt("action"): 0;
	    fillData();
    }
    private void fillData()
    {
    	mText = (EditText) findViewById(R.id.etMessage);
    	if(mMessageID!=null && mMessageID>0)
    	{
    		Cursor curMessage = mDbHelper.FetchMessagebyID(mMessageID);
    		String strMessage = curMessage.getString(curMessage.getColumnIndex(MessageTemplate.MessageText));
    		mText.setTextKeepState(strMessage);
    	}
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) 
	{
        super.onSaveInstanceState(outState);
        outState.putLong(MessageTemplate._ID, mMessageID);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        super.onCreateOptionsMenu(menu);
        menu.add(0, REVERT_ID, 0, "Revert")
            .setIcon(android.R.drawable.ic_menu_revert);	
        menu.add(0, SAVE_ID, 0, "Save")
        	.setIcon(android.R.drawable.ic_menu_save);	
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        // Handle all of the possible menu actions.
        switch (item.getItemId()) 
        {
        	case REVERT_ID:
        			setResult(RESULT_CANCELED);
        			finish();
        		 break;
        	case SAVE_ID:
        		
        			addMessage = mText.getText().toString();
        			if(addMessage.length()==0)
        			{
        				alertDialog = new AlertDialog.Builder(this).create();
		            	alertDialog.setTitle("Message Template");
						alertDialog.setMessage("Please enter Message.");
		            	alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		   	             public void onClick(DialogInterface dialog, int which) 
		   	             {
		   	                     return;
		   	             }
		   	         	});
		            	alertDialog.show();	
        			}
        			else
        			{
        				if(action.equals(MessageTemplateList.ACTIVITY_EDITMESSAGE))
        				{
        					IsReturn = mDbHelper.EditMessage(mMessageID, addMessage);
        				}
        				else
        				{
        					IsReturn = mDbHelper.AddNewMessage(addMessage);
        				}
        				if(IsReturn)
        				{
        					setResult(RESULT_OK);
            				finish();
        				}
        			}
        			
        		break;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
}