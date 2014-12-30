package br.com.ijoke.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import br.com.ijoke.R;
import br.com.ijoke.activity.adapter.StableArrayAdapter;
import br.com.ijoke.entity.JokeEntity;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

/**
 * 
 * @author Wagner Jeronimo
 *
 */

public class JokeHistoryFragment extends RoboFragment {

    @InjectView(R.id.listViewHistory)
    private ListView listView;
    
    private Context context;
    
    public JokeHistoryFragment(){
    	super();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_joke_history, container, false);
        context = rootView.getContext();
        return rootView;
    }
    
    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
    }
    
    public void updateView(final List<JokeEntity> jokes){
    	if ( this.listView != null ){
    		final StableArrayAdapter adapter = new StableArrayAdapter(context, R.layout.fragment_joke_history, jokes);
    		this.listView.setAdapter(adapter);
    	}
    }
    
    
	
}
