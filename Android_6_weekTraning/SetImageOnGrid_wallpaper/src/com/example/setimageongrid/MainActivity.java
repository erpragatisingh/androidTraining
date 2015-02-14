package com.example.setimageongrid;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	/**
	 * Cursor used to access the results from querying for images on the SD
	 * card.
	 */
	private Cursor cursor;
	/*
	 * Column index for the Thumbnails Image IDs.
	 */
	private int columnIndex;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up an array of the Thumbnail Image ID column we wan
		String[] projection = { MediaStore.Images.Thumbnails._ID };
		// Create the cursor pointing to the SDCard
		cursor = managedQuery(
				MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI,

				projection, // Which columns to return
				null, // Return all rows
				null, MediaStore.Images.Thumbnails.IMAGE_ID);
		// Get the column index of the Thumbnails Image ID
		columnIndex = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);
		GridView sdcardImages = (GridView) findViewById(R.id.sdcard);
		sdcardImages.setAdapter(new ImageAdapter(this));
		// Set up a click listener
		sdcardImages.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View v, int position,
					long id) {
				// Get the data location of the image
				String[] projection = { MediaStore.Images.Media.DATA };
				cursor = managedQuery(
						MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
						projection, // Which columns to return
						null, // Return all rows
						null, null);
				columnIndex = cursor
						.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				cursor.moveToPosition(position);

				// Get image filename
				String imagePath = cursor.getString(columnIndex);
				// Use this path to do further processing, i.e. full screen
				// display
				 	
			WallpaperManager wpm=  WallpaperManager.getInstance(getApplicationContext());
			try {
				wpm.setResource(R.drawable.ic_launcher);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
				
			}
		});
	}

	/**
	 * Adapter for our image files.
	 */
  
	private class ImageAdapter extends BaseAdapter {

		private Context context;

		public ImageAdapter(Context localContext) {
			context = localContext;
		}

		public int getCount() {
			return cursor.getCount();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {

			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView picturesView;
			if (convertView == null) {
				picturesView = new ImageView(context);
				// Move cursor to current position
				cursor.moveToPosition(position);
				// Get the current value for the requested column
				int imageID = cursor.getInt(columnIndex);
				// Set the content of the image based on the provided URI
				picturesView.setImageURI(Uri.withAppendedPath(
						MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, ""
								+ imageID));
				picturesView.setScaleType(ImageView.ScaleType.FIT_CENTER);
				picturesView.setPadding(8, 8, 8, 8);
				picturesView
						.setLayoutParams(new GridView.LayoutParams(100, 100));
			} else {
				picturesView = (ImageView) convertView;
			}
			return picturesView;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		 
		switch (event.getKeyCode()) {
		case KeyEvent.KEYCODE_VOLUME_DOWN:
			
			Toast.makeText(getApplicationContext(), "uolume up", 1).show();
			
			break;

		default:
			break;
		}
		
		
		return super.onKeyDown(keyCode, event);
	}
	
}
