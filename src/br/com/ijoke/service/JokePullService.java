package br.com.ijoke.service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import br.com.ijoke.entity.JokeEntity;
import br.com.ijoke.utils.NotificationUtils;
import com.google.inject.Inject;
import roboguice.service.RoboIntentService;

public class JokePullService extends RoboIntentService{

	public static final String LOG_TAG = "JokePullService";
	
	@Inject
	private JokeRestClientService jokeRestClient;
	
	@Inject
	private JokeService jokeService;
	
	public JokePullService() {
		super("JokePullService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		while (true){
			JokeEntity jokeNotRead = jokeService.getJokeNotRead();
			
			//verificando se tem piadas nao lidas.
			if (jokeNotRead == null){
				JokeEntity jokeEntity = jokeRestClient.getRandomJoke();
				jokeService.saveJoke(jokeEntity);
				NotificationUtils.criarNotificacao(getApplicationContext(), jokeEntity);
			}

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            prefs.getInt("timeForPullJokeEntry",30);
			SystemClock.sleep(30000); // 30 seconds
		}
		
		
	}

	
	
}
