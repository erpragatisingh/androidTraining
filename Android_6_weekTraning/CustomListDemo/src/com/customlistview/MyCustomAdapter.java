package com.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCustomAdapter extends BaseAdapter {
	String[] data1, data2;
	Context activity;
	LayoutInflater layoutInflater;

	
	public MyCustomAdapter(Context mActivity,String[] mData1, String[] mData2) {
		activity = mActivity;
		data1 = mData1;
		data2 = mData2;
		layoutInflater = ((Activity)activity).getLayoutInflater();
	}

	public int getCount() {
		return data1.length;
	}

	public Object getItem(int position) {

		return null;
	}

	public long getItemId(int position) {

		return 0;
	}
	
	static class MyViewHolder {
		TextView textView;
		TextView textView2;
		ImageView imageView;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		MyViewHolder viewHolder;
		if (convertView == null) {
			viewHolder = new MyViewHolder();
			convertView = layoutInflater.inflate(R.layout.list_row, null);
			viewHolder.textView = (TextView)convertView.findViewById(R.id.text1);
			viewHolder.textView2 = (TextView)convertView.findViewById(R.id.text2);
			viewHolder.imageView = (ImageView)convertView.findViewById(R.id.image);
			convertView.setTag(viewHolder);
		} else 
			viewHolder = (MyViewHolder)convertView.getTag();
			
			viewHolder.textView.setText(data1[position]);
			viewHolder.textView2.setText(data2[position]);
			viewHolder.imageView.setBackgroundResource(R.drawable.icon);
		return convertView;
	}

}








