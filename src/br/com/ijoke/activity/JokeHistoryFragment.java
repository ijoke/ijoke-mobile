package br.com.ijoke.activity;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.ijoke.R;

/**
 * 
 * @author Wagner Jeronimo
 *
 */

public class JokeHistoryFragment extends RoboFragment {

    @InjectView(R.id.section_label)
    TextView txtHistory;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_history, container, false);
        
        return rootView;
    }
    
    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
        txtHistory.setText("Histórico de piadas lidas.");
    }
	
}
