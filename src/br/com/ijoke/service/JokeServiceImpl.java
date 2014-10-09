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
		return this.dataService.getList(JokeEntity.class);
		
	}

	@Override
	public JokeEntity saveJoke(JokeEntity joke) {
		//TODO VER SE NAO ESTOUROU O LIMITE DE 30 JOKES NO BANCO.
		return this.dataService.insertOrUpdate(joke);
	}

	@Override
	public void removeJoke(JokeEntity joke) {
		this.dataService.deleteById(joke);
	}

	@Override
	public void removeLastJoke() {
		//this.dataService.findUniqueResult(JokeEntity.class, "from joke j where j.id", args)
	}

	@Override
	public JokeEntity getJokeNotRead() {
		return dataService.findUniqueResult(JokeEntity.class, "read=?", new String[]{String.valueOf(0)});
	}

}
