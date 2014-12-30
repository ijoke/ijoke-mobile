package br.com.ijoke.entity;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class AppConfig {

	
	private Integer timeForNewJokeInMin;
	private Boolean repeatJoke;
	
	
	public Integer getTimeForNewJokeInMin() {
		return timeForNewJokeInMin;
	}
	public void setTimeForNewJokeInMin(Integer timeForNewJokeInMin) {
		this.timeForNewJokeInMin = timeForNewJokeInMin;
	}
	public Boolean getRepeatJoke() {
		return repeatJoke;
	}
	public void setRepeatJoke(Boolean repeatJoke) {
		this.repeatJoke = repeatJoke;
	}
	
}
