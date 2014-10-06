package br.com.ijoke.service;

import br.com.ijoke.entity.AppConfig;


/**
 * 
 * @author root
 *
 */
public interface ConfigService {

	
	/**
	 * Pega as configuracoes da aplicacao.
	 * @return
	 */
	AppConfig getConfig();
	
	
	/**
	 * Salva a config no banco.
	 * @param appConfig
	 */
	void saveConfig(AppConfig appConfig);
	
}
