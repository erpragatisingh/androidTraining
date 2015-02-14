package sachit.myfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MyfragmentActivity extends ListFragment {
	private String[] mListItems = new String[] {"Mobility Weblog","TechCrunch","Manning Books"};
	public MyfragmentActivity() {
		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
	super.onActivityCreated(savedInstanceState);
	setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.frag_summary_textview, mListItems));
	}
	/*@Override
	public void onListItemClick(ListView l,View v, int position, long id) {
	DetailsWebFragment frag = (DetailsWebFragment)getFragmentManager().findFragmentById(R.id.frag_details_webview);
	frag.updateDetails(mListItemsUrls[position]);
	mPosition = position; // remember current position
	}*/
	}