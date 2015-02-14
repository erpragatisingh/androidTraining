package com.listcustom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Wadap extends ArrayAdapter<Wtho>{
	Context c1;
	int c2;
	Wtho dataw[];

	public Wadap(Context context, int textViewResourceId, Wtho[] data) {
		super(context, textViewResourceId, data);
		c1= context;
		c2= textViewResourceId;
		dataw= data;
		// TODO Auto-generated constructor stub
	}
	


	public View getView(int position, View convertView, ViewGroup parent){
		View row = convertView;
        WeatherHolder holder;
        
        
            LayoutInflater inflater = ((Activity)c1).getLayoutInflater();
            row = inflater.inflate(c2, parent, false);
            
            holder = new WeatherHolder();
            holder.imgIcon = (ImageView)row.findViewById(R.id.imageView1);
            holder.txtTitle = (TextView)row.findViewById(R.id.textView1);
            System.out.println("ppppppppppppppppp");
            
       
        
        
        Wtho weather = dataw[position];
        holder.txtTitle.setText(weather.text);
        holder.imgIcon.setImageResource(weather.icon);
        row.setTag(holder);
        
        return row;
		
	}
	
	 static class WeatherHolder
	    {
	        ImageView imgIcon;
	        TextView txtTitle;
	    }

}
