package br.com.ijoke.module;

import android.content.Context;

import com.google.inject.Binder;
import com.google.inject.Module;

import br.com.ijoke.buffer.BufferBuilder;
import br.com.ijoke.buffer.BufferBuilderImpl;
import br.com.ijoke.service.ConfigService;
import br.com.ijoke.service.ConfigServiceImpl;
import br.com.ijoke.service.DataService;
import br.com.ijoke.service.DataServiceImpl;
import br.com.ijoke.service.JokeService;
import br.com.ijoke.service.JokeServiceImpl;
import br.com.ijoke.service.JokeRestClientService;
import br.com.ijoke.service.JokeRestClientServiceImpl;

/**
 * 
 * Classe reponsavel por registrar as implementacoes das interfaces.
 * 
 * 
 * @author wagneraraujo-sao
 *
 */
public class FindClassInjectableModule implements Module {

	private Context context;
	
	public FindClassInjectableModule(Context context){
		this.context = context;
	}
	
	
	@Override
	public void configure(Binder binder) {
		binder.bind(BufferBuilder.class).to(BufferBuilderImpl.class);
		binder.bind(ConfigService.class).to(ConfigServiceImpl.class);
		binder.bind(JokeRestClientService.class).to(JokeRestClientServiceImpl.class);
		binder.bind(JokeService.class).to(JokeServiceImpl.class);
		binder.bind(DataService.class).toInstance(new DataServiceImpl(this.context));
	}
	
}
