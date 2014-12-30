package br.com.ijoke;

import android.app.Application;
import android.content.Intent;

import br.com.ijoke.buffer.BufferBuilder;
import br.com.ijoke.module.FindClassInjectableModule;
import br.com.ijoke.service.JokePullService;
import roboguice.RoboGuice;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class IJokeApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, 
	            RoboGuice.newDefaultRoboModule(this), new FindClassInjectableModule(this));
		
		BufferBuilder bufferBuilder = RoboGuice.getBaseApplicationInjector(this).getInstance(BufferBuilder.class);
		bufferBuilder.load();
		
		Intent mServiceIntent = new Intent(this.getApplicationContext(), JokePullService.class);
		mServiceIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		this.getApplicationContext().startService(mServiceIntent);
		
	}

	
	
}
