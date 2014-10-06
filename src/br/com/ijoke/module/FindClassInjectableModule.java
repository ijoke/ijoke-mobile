package br.com.ijoke.module;

import android.content.Context;
import br.com.ijoke.buffer.BufferBuilder;
import br.com.ijoke.buffer.BufferBuilderImpl;
import br.com.ijoke.service.ConfigService;
import br.com.ijoke.service.ConfigServiceImpl;
import br.com.ijoke.service.DataService;
import br.com.ijoke.service.DataServiceImpl;

import com.google.inject.Binder;
import com.google.inject.Module;

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
		binder.bind(DataService.class).toInstance(new DataServiceImpl(this.context));
		
	}
	
}
