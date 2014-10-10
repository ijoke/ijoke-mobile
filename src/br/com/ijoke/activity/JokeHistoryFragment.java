package br.com.ijoke.activity;

import java.util.List;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import br.com.ijoke.R;
import br.com.ijoke.activity.adapter.StableArrayAdapter;
import br.com.ijoke.entity.JokeEntity;

/**
 * 
 * @author Wagner Jeronimo
 *
 */

public class JokeHistoryFragment extends RoboFragment {

    @InjectView(R.id.listViewHistory)
    private ListView listView;
    
    private Context context;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
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
    		this.listView.setAdapter(new StableArrayAdapter(context, R.layout.fragment_joke_history, jokes));
    		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			        @Override
                public void onItemClick(AdapterView<?> parent, final View view,
                    int position, long id) {
                  final JokeEntity item = (JokeEntity) parent.getItemAtPosition(position);
                  view.animate().setDuration(2000).alpha(0)
                      .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                        	jokes.remove(item);
                          adapter.notifyDataSetChanged();
                          view.setAlpha(1);
                        }
                      });
                }

              });
    	}
    }
    
    
	
}
