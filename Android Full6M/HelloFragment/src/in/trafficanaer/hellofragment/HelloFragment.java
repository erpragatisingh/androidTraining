package in.trafficanaer.hellofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import in.wptrafficanalyzer.hellofragment.R;

import android.view.View;
import android.view.ViewGroup;

public class HelloFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
		View v = inflater.inflate(R.layout.hello_fragment_layout, null);
		return v;
	}
	
}
