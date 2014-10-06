package br.com.ijoke.activity;

import br.com.ijoke.R;
import roboguice.inject.InjectFragment;
import android.support.v4.app.Fragment;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class HomeActivityHelperImpl implements HomeActivityHelper {

	@InjectFragment(R.layout.fragment_joke_reader)
	JokeReaderFragment readerFragment;
	
	@InjectFragment(R.layout.fragment_joke_history)
	JokeHistoryFragment historyFragment;
	
	@InjectFragment(R.layout.fragment_joke_configuration)
	JokeConfigurationFragment configFragment;
	
	public Fragment getFragment(int position) {
		switch (position) {
		case 0: return readerFragment;
		case 1: return historyFragment;	
		case 2: return configFragment;	
		default: return readerFragment;
		}
	}
	
}
