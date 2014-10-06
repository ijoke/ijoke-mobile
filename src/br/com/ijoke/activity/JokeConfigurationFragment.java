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

	@InjectView(R.id.btnNotificacao)
	Button btnNotificacao;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_configuration, container, false);
        return rootView;
    }
    
    @Override
    public void onActivityCreated( Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );
        btnNotificacao.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NotificationUtils.criarNotificacao(v.getContext(), "Uma nova piada chegou!", "Uma nova piada", "Clique aqui para ler a nova piada", HomeActivity.class);
				
			}
		});
        
       
    }
	
}
