package br.com.ijoke.service;

import java.util.List;

import br.com.ijoke.entity.JokeEntity;

import com.google.inject.Inject;

/**
 * 
 * @author Wagner Araujo
 *
 */
public class JokeServiceImpl implements JokeService {

	@Inject
	private DataService dataService;
	
	@Override
	public JokeEntity getJokeById(Integer id) {
		return this.dataService.getById(JokeEntity.class, id);
	}

	@Override
	public List<JokeEntity> listAllJoke() {
		return this.dataService.getList(JokeEntity.class,"id desc" );
		
	}

	@Override
	public JokeEntity saveJoke(JokeEntity joke) {
		if (listAllJoke().size() >= 30){
			this.removeLastJoke();
		}
		return this.dataService.insertOrUpdate(joke);
	}

	@Override
	public void removeJoke(JokeEntity joke) {
		this.dataService.deleteById(joke);
	}

	@Override
	public void removeLastJoke() {
		//TODO ARRUMAR UM JEITO MELHOR DE FAZER ISSO.
		JokeEntity joke = this.dataService.getList(JokeEntity.class, "id" ).get(0);
		removeJoke(joke);
	}

	@Override
	public JokeEntity getJokeNotRead() {
		return dataService.findUniqueResult(JokeEntity.class, "read=?", new String[]{String.valueOf(0)});
	}

}
