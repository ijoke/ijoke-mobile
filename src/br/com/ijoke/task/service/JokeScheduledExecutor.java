package br.com.ijoke.task.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.Intent;

public class JokeScheduledExecutor implements Runnable{
	
	private Context context;
	
	public JokeScheduledExecutor(Context context) {
		this.context = context;
		 ScheduledExecutorService scheduler =
				    Executors.newSingleThreadScheduledExecutor();

				scheduler.scheduleAtFixedRate(this
				      , 0, 1, TimeUnit.MINUTES);
	}
	
	
	@Override
	public void run() {
		Intent mServiceIntent = new Intent(context, JokePullService.class);
		context.startService(mServiceIntent);
		//mServiceIntent.setData(Uri.parse(dataUrl));
	}

}
