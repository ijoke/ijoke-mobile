package br.com.ijoke.activity;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.ijoke.R;
import br.com.ijoke.entity.JokeEntity;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class JokeReaderFragment extends RoboFragment{
	
	@InjectView(R.id.section_label)
	private TextView txtJokeReader;
	
	private JokeEntity joke;
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_reader, container, false);
        return rootView;
    }
    
    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
      
        if (this.joke != null){
        	txtJokeReader.setText(joke.getJokeDescription());
        }else{
        	txtJokeReader.setText("Não há novas piadas.");
        }
        
    }
    
    public void updateJoke(JokeEntity joke){
    	this.joke = joke;
    	txtJokeReader.setText(joke.getJokeDescription());
    }
}
