package in.wptrafficanalyzer.actionbarsherlocknavtab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockListFragment;

public class AppleFragment extends SherlockListFragment  implements ActionBar.TabListener{
	
    /** An array of items to display in ArrayList */
    String apple_versions[] = new String[]{
            "Mountain Lion",
            "Lion",
            "Snow Leopard",
            "Leopard",
            "Tiger",
            "Panther",
            "Jaguar",
            "Puma"
    };
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, apple_versions);

        /** Setting the array adapter to the listview */
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);

    }    
    
    @Override
    public void onStart() {    	
    	super.onStart();
    	
        /** Setting the multiselect choice mode for the listview */
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.add(android.R.id.content, this,"apple");
		
		ft.attach(this);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.detach(this);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
	
}