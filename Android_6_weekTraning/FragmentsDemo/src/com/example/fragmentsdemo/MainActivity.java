package com.example.fragmentsdemo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements MyFragment.MyListner{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_layout);
	}

	@Override
	public void onSelected(String link) {
		SecondFragment fragment =
				(SecondFragment)getFragmentManager().findFragmentById(R.id.detailFragment);
		if (fragment!=null && fragment.isInLayout()) {
			fragment.setText(link);
		}
	}

}
