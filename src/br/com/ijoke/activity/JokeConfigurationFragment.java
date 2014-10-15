package br.com.ijoke.activity;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import br.com.ijoke.R;
import br.com.ijoke.utils.NotificationUtils;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class JokeConfigurationFragment extends RoboFragment {

	
	
	public JokeConfigurationFragment(){
		super();
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_joke_configuration, container, false);
        return rootView;
    }
    
}
