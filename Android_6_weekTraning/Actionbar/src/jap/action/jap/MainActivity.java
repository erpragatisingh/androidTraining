package jap.action.jap;

import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				/*Intent i=new Intent(Media.RECORD_SOUND_ACTION);
				startActivity(i);
				*/
					
				Intent i4=new Intent(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
				startActivity(i4);
				
			}
		});
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        
        super.onCreateOptionsMenu(menu);
        CreateMenu(menu);
        return true;
    }
    
   @Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	return MenuChoice(item);
}

	private boolean MenuChoice(MenuItem item) {
	// TODO Auto-generated method stub
	
	switch(item.getItemId())
	{
	case 0:
		//Toast.makeText(getApplicationContext(), item.getTitle(), 2000).show();
		Intent i=new Intent(Media.RECORD_SOUND_ACTION);
		startActivity(i);
		
		break;
	case 1:
		//Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
		Intent i2=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		startActivity(i2);
		break;
	case 2:
		//Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
		Intent i3=new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
		startActivity(i3);
		break;
	case 3:
		//Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
		Intent i4=new Intent(MediaStore.INTENT_ACTION_MEDIA_SEARCH);
		startActivity(i4);
		break;
	case 4:
		//Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_LONG).show();
		Intent i5=new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
		startActivity(i5);
		break;
		
		
	}
	return false;
}

	private void CreateMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem mnu1=menu.add(0,0,0,"Sound Recorder");
		{
			mnu1.setIcon(R.drawable.aston);
			mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		
		MenuItem mnu2=menu.add(0,1,0,"Video Capture");
		{
			mnu2.setIcon(R.drawable.ic_launcher);
			mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		
		MenuItem mnu3=menu.add(0,2,0,"Music Player");
		{
			mnu3.setIcon(R.drawable.ic_launcher);
			mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		
		MenuItem mnu4=menu.add(0,3,0,"Media Search");
		{
			mnu4.setIcon(R.drawable.ic_launcher);
			mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
		
		MenuItem mnu5=menu.add(0,4,0,"Still Image");
		{
			mnu5.setIcon(R.drawable.ic_launcher);
			mnu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		}
	}
	
    
}
