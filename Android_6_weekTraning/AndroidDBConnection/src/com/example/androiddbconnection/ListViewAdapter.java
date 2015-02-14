package com.example.androiddbconnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;


public class ListViewAdapter extends BaseAdapter{

	// Declare Variables
    Context context;
    LayoutInflater inflater;
    //ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    //private Integer[] imgid = {R.drawable.adv_adventure, R.drawable.adv_camel, R.drawable.adv_himalaya, R.drawable.adv_kashmir, R.drawable.adv_ladakh, R.drawable.adv_raft, R.drawable.adv_rafting, R.drawable.adv_wildlife	};
    JSONArray mJSONArray;

 
    public ListViewAdapter(Context context,
           JSONArray arraylist) {
        this.context = context;
      mJSONArray=arraylist;

        imageLoader = new ImageLoader(context);
 
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mJSONArray.length();
	}

	@Override
	public Object getItem(int arg0)   {

        try{
		return mJSONArray.get(arg0);
        }
        catch (Exception e)
        {
            return null;


        }
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView tourname;
        TextView duration;
        ImageView flag;
        
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
        View itemView = inflater.inflate(R.layout.list_row1, parent, false);
     // Get the position from the results

        
     // Locate the TextViews in listview_item.xml
        tourname = (TextView) itemView.findViewById(R.id.themeTourList_title); 
        duration = (TextView) itemView.findViewById(R.id.themeTourList_price);  
        // Locate the ImageView in listview_item.xml
        flag = (ImageView) itemView.findViewById(R.id.themeTourList_image); 
        
        // Capture position and set results to the TextViews
        try
        {
	        tourname.setText(mJSONArray.getJSONObject(position).getString("tour_name"));
	        duration.setText(""+mJSONArray.getJSONObject(position).getString("nights")+" Nights - "+mJSONArray.getJSONObject(position).getString("days")+" Days");
	        try{
	        URL url = new URL("www.futurolicht.com/"+mJSONArray.getJSONObject(position).getString("pic"));
	        Bitmap bitmap = BitmapFactory.decodeStream((InputStream)(url).getContent());
	        flag.setImageBitmap(bitmap);
	        }
	        catch(MalformedURLException e){
	        	Log.d("msg", e.toString());
	        }
	        catch(IOException e){
	        	Log.d("msg", e.toString());
	        }
	        //flag.setImageResource(imgid[(Integer) mJSONArray.get(position)]);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
     // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class to download and cache
        // images
//        try
//        {
//        imageLoader.DisplayImage("www.futurolicht.com/"+mJSONArray.getJSONObject(position).getString("pic"),flag);
//            URL url=new URL("www.futurolicht.com/"+mJSONArray.getJSONObject(position).getString("pic"));
//          Uri uri=null;
//            try
//            {
//
//            uri = Uri.parse( url.toURI().toString() );
//            }
//            catch (Exception e)
//            {
//
//            }
//
//           flag.setImageURI(uri);
//
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }	
        itemView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				HashMap<String, String> resultp = new HashMap<String, String>();
//                resultp = data.get(position);
                // Send single item click data to SingleItemView Class
//                Intent intent = new Intent(context, SingleItemView.class);
//                // Pass all data rank
//                intent.putExtra("rank", resultp.get(MainActivity.RANK));
//                // Pass all data country
//                intent.putExtra("country", resultp.get(MainActivity.COUNTRY));
//                // Pass all data population
//                intent.putExtra("population",
//                        resultp.get(MainActivity.POPULATION));
//                // Pass all data flag
//                intent.putExtra("flag", resultp.get(MainActivity.FLAG));
//                // Start SingleItemView Class
//                context.startActivity(intent);
 
				
			}
		});

		return itemView;
	}
    
}
