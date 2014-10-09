package br.com.ijoke.task.service;

import roboguice.service.RoboIntentService;
import android.content.Intent;
import android.os.SystemClock;
import br.com.ijoke.entity.JokeEntity;
import br.com.ijoke.service.JokeService;
import br.com.ijoke.utils.NotificationUtils;

import com.google.inject.Inject;

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
			
			SystemClock.sleep(30000); // 30 seconds
		}
		
		
	}

	
	
}
