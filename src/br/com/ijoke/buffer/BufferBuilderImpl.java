package br.com.ijoke.buffer;

import com.google.inject.Inject;

import br.com.ijoke.entity.AppConfig;
import br.com.ijoke.service.ConfigService;

/**
 * 
 * @author root
 *
 */
public class BufferBuilderImpl implements BufferBuilder{

	@Inject
	private ConfigService configService;
	
	public void load(){
		AppConfig appConfig = configService.getConfig();
		AppBuffer.setAppConfig(appConfig);
	}
	
	
}
