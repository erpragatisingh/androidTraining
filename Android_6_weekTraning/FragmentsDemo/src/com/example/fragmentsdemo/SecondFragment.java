package com.example.fragmentsdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View inflate = inflater.inflate(R.layout.activity_main, container, false);
		return inflate;
	}
	
	
	public void setText(String text) {
		TextView textView = (TextView)getView().findViewById(R.id.fragmentTextView);
		textView.setText(text);
	}
}
