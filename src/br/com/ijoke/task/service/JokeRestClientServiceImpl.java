package br.com.ijoke.task.service;

import java.util.Date;

import br.com.ijoke.entity.JokeEntity;
import br.com.ijoke.task.vo.JokeVO;
import br.com.ijoke.utils.DateUtils;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class JokeRestClientServiceImpl implements JokeRestClientService {
	 
	@Override
	public JokeEntity getRandomJoke() {
		return JokeEntityAdapter.adapter(this.getJokeVOMock());
		
	}
	
	private JokeVO getJokeVOMock() {
		JokeVO vo = new JokeVO();
		vo.setId("10");
		vo.setJokeDescription("Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues ");
		
		vo.setJokeTitle("Piada de portugues");
		vo.setLikes(10);
		vo.setOwner("@wagner");
		
		return vo;
	}

	static class JokeEntityAdapter {
		
		public static JokeEntity adapter(JokeVO jokeVO){
			JokeEntity jokeEntity = new JokeEntity();
			jokeEntity.setDatCreation(DateUtils.formatddmmyyyy(new Date()));
			jokeEntity.setJokeDescription(jokeVO.getJokeDescription());
			jokeEntity.setJokeTitle(jokeVO.getJokeTitle());
			jokeEntity.setLike(Boolean.FALSE);
			jokeEntity.setSync(Boolean.FALSE);
			jokeEntity.setRead(Boolean.FALSE);
			jokeEntity.setRemoteId(jokeVO.getId());
			return jokeEntity;
		}
	}

}
