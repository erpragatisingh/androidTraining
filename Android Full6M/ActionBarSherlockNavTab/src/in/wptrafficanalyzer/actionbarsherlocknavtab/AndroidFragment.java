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


public class AndroidFragment extends SherlockListFragment implements ActionBar.TabListener{
	
	
	/** An array of items to display in ArrayList */
    String android_versions[] = new String[]{
            "Jelly Bean",
            "IceCream Sandwich",
            "HoneyComb",
            "Ginger Bread",
            "Froyo"
    };
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
    		Bundle savedInstanceState) {
    	 /** Creating array adapter to set data in listview */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_multiple_choice, android_versions);

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
		ft.add(android.R.id.content, this,"android");
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
