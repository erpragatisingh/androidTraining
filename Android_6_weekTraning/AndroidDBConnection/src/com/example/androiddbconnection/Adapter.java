package com.example.androiddbconnection;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends BaseAdapter{
	private ArrayList<ModelClass> data;
	private static LayoutInflater inflater = null; 
	private Integer[] imgid = {R.drawable.solo};
	
	
	public Adapter(Context context, ArrayList<ModelClass> d){
		data = d;
		inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.list_row1, null);
			holder = new ViewHolder();
		   holder.txt_itemName = (TextView) convertView.findViewById(R.id.themeTourList_title);
		   holder.itemImage = (ImageView) convertView.findViewById(R.id.themeTourList_image);
		   holder.txt_tourPrice = (TextView)convertView.findViewById(R.id.themeTourList_price);
		   convertView.setTag(holder);
	  } else {
	   holder = (ViewHolder) convertView.getTag();
	  }
	   
	  holder.txt_itemName.setText(data.get(position).gettourname());
	  holder.txt_tourPrice.setText(data.get(position).getPrice());
	  holder.itemImage.setImageResource(imgid[data.get(position).getImageNumber() - 1]);
	 
	  return convertView;
	 }
	static class ViewHolder {
		  TextView txt_itemName;
		  ImageView itemImage;
		  TextView txt_tourPrice;
	}

}
