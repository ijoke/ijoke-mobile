package br.com.ijoke.buffer;

import br.com.ijoke.entity.AppConfig;


/**
 * 
 * @author root
 *
 */
public final class AppBuffer {
	
	private static AppConfig appConfig;
	
	
	public static AppConfig getAppConfig(){
		return AppBuffer.appConfig;
	}
	
	protected static void setAppConfig(AppConfig appConfig){
		AppBuffer.appConfig = appConfig;
	}

}
