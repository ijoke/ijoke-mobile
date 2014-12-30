package br.com.ijoke.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import br.com.ijoke.entity.JokeEntity;
import br.com.ijoke.utils.DateUtils;
import br.com.ijoke.vo.JokeVO;
import com.google.gson.GsonBuilder;

/**
 * @author Wagner Jeronimo
 */
public class JokeRestClientServiceImpl implements JokeRestClientService {

    @Override
    public JokeEntity getRandomJoke() {

        return JokeEntityAdapter.adapter(this.findJoke());

    }

    private JokeVO findJoke() {

        JokeVO vo = new JokeVO();
        try {
            URL url = new URL("http://site/get");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            InputStreamReader isr = new InputStreamReader(in);
            return new GsonBuilder().create().fromJson(isr, JokeVO.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		/*vo.setId("10");
        vo.setJokeDescription("Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, Piada de portugues, " +
				"Piada de portugues, Piada de portugues, Piada de portugues ");
		
		vo.setJokeTitle("Piada de portugues");
		vo.setLikes(10);
		vo.setOwner("@wagner");*/

        return vo;
    }

    static class JokeEntityAdapter {

        public static JokeEntity adapter(JokeVO jokeVO) {

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
