package ramansingh.fragment_og_example;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class My_frag extends Fragment {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	Log.d("LOG EXAMPLE", "[FRAGMENT]:onCreate()");
	
		
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.d("LOG_EXAMPLE", "[FRAGMENT]:onAttach()");
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d("LOG_EXAMPLE", "[FRAGMENT]: onActivityCreated())");
				
				
	}
	
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("LOG EXAMPLE", "[FRAGMENT]:onResume()");
		
	}
	
	public void onResume(){
		super.onResume();
		Log.d("LOG EXAMPLE", "[FRAGMENT]:onResume()");
	}

	 @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("LOG EXAMPLE", "[FRAGMENT]:onPause()");
		
	}

	
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("LOG EXAMPLE", "[FRAGMENT]:onStop()");
		
	}
	
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("LOG EXAMPLE", "[FRAGMENT]:onDestroy()");
		
	}
	
	
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d("LOG EXAMPLE", "[FRAGMENT]:onDestroy()");
		
	}
	
	
}