package br.com.ijoke.buffer;

import br.com.ijoke.entity.AppConfig;


/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class BufferFacade {

	/**
	 * 
	 * @param appConfig
	 */
	public static void updateAppConfig(AppConfig appConfig){
		AppBuffer.setAppConfig(appConfig);
	}
	
}
