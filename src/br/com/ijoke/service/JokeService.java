package br.com.ijoke.service;

import java.util.List;

import br.com.ijoke.entity.JokeEntity;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public interface JokeService {

	JokeEntity getJokeNotRead();
	
	JokeEntity getJokeById(Integer id);
	
	List<JokeEntity> listAllJoke();
	
	JokeEntity saveJoke(JokeEntity joke);
	
	void removeJoke(JokeEntity joke);
	
	void removeLastJoke();
	
}
