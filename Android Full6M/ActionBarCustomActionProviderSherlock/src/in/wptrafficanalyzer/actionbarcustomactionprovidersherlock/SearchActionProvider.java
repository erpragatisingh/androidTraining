package in.wptrafficanalyzer.actionbarcustomactionprovidersherlock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.actionbarsherlock.view.ActionProvider;

public class SearchActionProvider extends ActionProvider{
	Context mContext;

	public SearchActionProvider(Context context) {
		super(context);
		mContext = context;
	}

	@Override
	public View onCreateActionView() {
		LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.search_layout,null);
        return view;
	}
}
