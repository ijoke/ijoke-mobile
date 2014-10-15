package br.com.ijoke.activity;

import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.text.Html;
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
	
	@InjectView(R.id.txtReadJoke)
	private TextView txtJokeReader;
	
	private JokeEntity joke;
	
	public JokeReaderFragment(){
		super();
	}
	
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_joke_reader, container, false);
        return rootView;
    }
    
    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
      
        if (this.joke != null){
        	txtJokeReader.setText(Html.fromHtml("<b><h1>" + joke.getId() + "<b></h1><br><center><h3>" 
        	        + joke.getJokeDescription() + "</h3></center>"));
        }else{
        	txtJokeReader.setText(Html.fromHtml("<h1>Não há novas piadas.</h1>"));
        }
        
    }
    
    public void updateJoke(JokeEntity joke){
    	this.joke = joke;
    	if (txtJokeReader != null){
    		txtJokeReader.setText(Html.fromHtml("<b><h1>" + joke.getId() + "<b></h1><br><center><h3>" 
    				+ joke.getJokeDescription() + "</h3></center>"));
    	}
    }
}
