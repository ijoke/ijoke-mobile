package br.com.ijoke.vo;
/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class JokeVO {

	private String id;
	private String jokeTitle;
	private String jokeDescription;
	private Integer likes;
	private String owner;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJokeTitle() {
		return jokeTitle;
	}
	public void setJokeTitle(String jokeTitle) {
		this.jokeTitle = jokeTitle;
	}
	public String getJokeDescription() {
		return jokeDescription;
	}
	public void setJokeDescription(String jokeDescription) {
		this.jokeDescription = jokeDescription;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
