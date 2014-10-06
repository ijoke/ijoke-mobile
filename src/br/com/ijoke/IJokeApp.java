package br.com.ijoke;

import br.com.ijoke.buffer.BufferBuilder;
import br.com.ijoke.module.FindClassInjectableModule;
import roboguice.RoboGuice;
import android.app.Application;

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
	}

	
	
}
