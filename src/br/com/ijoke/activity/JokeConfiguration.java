package br.com.ijoke.activity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.text.method.DigitsKeyListener;
import br.com.ijoke.R;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class JokeConfiguration extends PreferenceActivity {

	
	
	EditTextPreference telFavorito;
	 
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  addPreferencesFromResource(R.xml.configuration);

	  /*telFavorito = (EditTextPreference)findPreference(getString(R.string.pref_default_number_key));
	  telFavorito.getEditText().setKeyListener(DigitsKeyListener.getInstance());
	  String tel = telFavorito.getText();
	  telFavorito.setSummary(tel.equals("") ? getString(R.string.pref_default_number_summary) : tel);
	  telFavorito.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {
	   
	   @Override
	   public boolean onPreferenceChange(Preference preference, Object newValue) {
	    telFavorito.setSummary(newValue.toString());
	    return true;
	   }
	  });*/
	 }
}
