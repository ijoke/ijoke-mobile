package br.com.ijoke.entity;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.ijoke.dao.PersistenceBean;

/**-
 * 
 * @author Wagner Jeronimo
 *
 */
public class JokeEntity extends PersistenceBean {

	public static final String OBJ_NAME = "JOKE_ENTITY";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7133380197456673267L;
	
	private Integer id;
	private String jokeTitle;
	private String jokeDescription;
	private String datCreation;
	private Boolean like;
	private Boolean sync;
	private Boolean read;
	private String remoteId;
	
	

	public JokeEntity() {
		super("joke", new String[]{"id","joke_title","joke_description",
				"dat_creation","like","sync","read","remote_id"});
		
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

	public String getDatCreation() {
		return datCreation;
	}

	public void setDatCreation(String datCreation) {
		this.datCreation = datCreation;
	}

	public Boolean getLike() {
		return like;
	}

	public void setLike(Boolean like) {
		this.like = like;
	}

	public Boolean getSync() {
		return sync;
	}

	public void setSync(Boolean sync) {
		this.sync = sync;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return this.id;
	}
	
	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(String remoteId) {
		this.remoteId = remoteId;
	}


	@Override
	public ContentValues getContentValues() {
		ContentValues val = new ContentValues();
		val.put( "id", this.getId() );
		val.put( "joke_title", this.getJokeTitle());
		val.put( "joke_description", this.getJokeDescription());
		val.put( "dat_creation", this.getDatCreation());
		val.put( "like", this.getLike() ? 1 : 0);
		val.put( "sync", this.getSync() ? 1 : 0);
		val.put( "read", this.getRead() ? 1 : 0);
		val.put( "remote_id", this.getRemoteId());
		return val;
	}

	@Override
	public void setBean(Cursor cr) {
		this.setId(cr.getInt(0));
		this.setJokeTitle(cr.getString(1));
		this.setJokeDescription(cr.getString(2));
		this.setDatCreation(cr.getString(3));
		this.setLike(Boolean.valueOf(cr.getString(4)));
		this.setSync(Boolean.valueOf(cr.getString(5)));
		this.setRead(Boolean.valueOf(cr.getString(6)));
		this.setRemoteId(cr.getString(7));
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datCreation == null) ? 0 : datCreation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((jokeDescription == null) ? 0 : jokeDescription.hashCode());
		result = prime * result
				+ ((jokeTitle == null) ? 0 : jokeTitle.hashCode());
		result = prime * result + ((like == null) ? 0 : like.hashCode());
		result = prime * result + ((sync == null) ? 0 : sync.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JokeEntity other = (JokeEntity) obj;
		if (datCreation == null) {
			if (other.datCreation != null)
				return false;
		} else if (!datCreation.equals(other.datCreation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jokeDescription == null) {
			if (other.jokeDescription != null)
				return false;
		} else if (!jokeDescription.equals(other.jokeDescription))
			return false;
		if (jokeTitle == null) {
			if (other.jokeTitle != null)
				return false;
		} else if (!jokeTitle.equals(other.jokeTitle))
			return false;
		if (like == null) {
			if (other.like != null)
				return false;
		} else if (!like.equals(other.like))
			return false;
		if (sync == null) {
			if (other.sync != null)
				return false;
		} else if (!sync.equals(other.sync))
			return false;
		return true;
	}
	
}
