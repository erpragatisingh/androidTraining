package com.example.music;


import android.media.MediaPlayer;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.MediaStore.Video.Thumbnails;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Movie;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MusicPlayer extends Activity {
	Cursor musiccursor, thumbnailCursor;
	int music_column_index;
	int count;
	ListView musiclist;
    MediaPlayer mMediaPlayer;
    LayoutInflater l1;
    String[] thumbnailColumns;
    int indexColumn;
    int id1;
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music();
    }

    private void music() {
		// TODO Auto-generated method stub
    	System.gc();
    	
        String[] proj = { MediaStore.Video.Media._ID,
MediaStore.Video.Media.DATA,
MediaStore.Video.Media.DISPLAY_NAME,
MediaStore.Video.Media.SIZE
,MediaStore.Video.Media.ALBUM};
       
        System.out.println(proj);
        musiccursor = managedQuery(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
proj, null, null, null);
        String[] thumbnailColumns = { MediaStore.Video.Thumbnails._ID };
        
        if ( (musiccursor != null) && musiccursor.moveToFirst() )
        {
        	System.out.println(thumbnailColumns);
        int id1 = musiccursor.getInt(musiccursor
                .getColumnIndex(MediaStore.Video.Media.DATA));
        System.out.println("Hello"+id1);
       thumbnailCursor = getContentResolver().query(
                MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                thumbnailColumns, null, null, MediaStore.Video.Thumbnails.VIDEO_ID);
        }
        indexColumn = thumbnailCursor.getColumnIndexOrThrow(MediaStore.Video.Thumbnails._ID);
        System.out.println(indexColumn);
        count = musiccursor.getCount();
        System.out.println(count);
        
        musiclist = (ListView) findViewById(R.id.listView1);
        musiclist.setAdapter(new MusicAdapter(this));

        musiclist.setOnItemClickListener(musicgridlistener);
        mMediaPlayer = new MediaPlayer();
    }  
       
    private OnItemClickListener musicgridlistener = new OnItemClickListener() {
        

		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			// TODO Auto-generated method stub
			 System.gc();
			
             music_column_index = musiccursor
.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
             musiccursor.moveToPosition(position);
            
             
			
             String filename = musiccursor.getString(music_column_index);
             String f1= musiccursor.getString(musiccursor.getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM));
             System.out.println(f1);
             System.out.println(filename);
             Intent i= new Intent(MusicPlayer.this, second.class);
             i.putExtra("name", filename);
             startActivity(i);
             

       /*      try {
                   if (mMediaPlayer.isPlaying()) {
                         mMediaPlayer.reset();
                   }
                   mMediaPlayer.setDataSource(filename);
                   mMediaPlayer.prepare();
                   mMediaPlayer.start();
             } catch (Exception e) {
System.out.println("AAA");
             }*/
       }

			
		
  };

  public class MusicAdapter extends BaseAdapter {
        private Context mContext;

        public MusicAdapter(Context c) {
              mContext = c;
              l1= ((Activity)mContext).getLayoutInflater();
        }

        public int getCount() {
        	 System.out.println("SES");
              return count;
             
        }

        public Object getItem(int position) {
              return position;
        }

        public long getItemId(int position) {
              return position;
        }

      

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			 System.gc();
			
			 System.out.println("SESi");
			 convertView= l1.inflate(R.layout.list_row, null);
             TextView tv = (TextView)convertView.findViewById(R.id.textView14);
             ImageView i1= (ImageView)convertView.findViewById(R.id.imageView14);
           
             String id = null; 
                          
          //   if (convertView == null) {
         
            	 musiccursor.moveToPosition(position);
            	 System.out.println("ImageID");
                   id = musiccursor.getString(musiccursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
                  
                   System.out.println("XXXXXX");
                   musiccursor.moveToPosition(position);
 //int imageId = thumbnailCursor.getInt(indexColumn);
              
                   // Set content of the image
                   i1.setImageURI(Uri.withAppendedPath(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, "" + id1));

                   id += "\n"+" Size(KB):" + musiccursor.getString(musiccursor.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE));
                   
                   musiccursor.moveToPosition(position);
                   id += "\n"+" Album:" + musiccursor.getString(musiccursor.getColumnIndexOrThrow(MediaStore.Video.Media.ALBUM));
                   tv.setText(id);
                  
                //   	   i1.setImageBitmap(bmap);
                 //  bmThumbnail = ThumbnailUtils.createVideoThumbnail(thumbnailCursor, Thumbnails.MICRO_KIND);
                  
                  
                   tv.setBackgroundColor(Color.MAGENTA);
                   tv.setTextColor(Color.RED);
                   System.out.println("YYYYYYYYYYYYYY");
                  
             
             return convertView;
             
       }
		 
  }
}