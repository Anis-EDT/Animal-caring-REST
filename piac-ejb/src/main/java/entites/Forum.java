package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Forum
 *
 */
@Entity

public class Forum implements Serializable {
//commit test by omar reg
	   
	@Id
	private Integer idForum;
	private String nameForum;
	private String descForum;
	private Integer nbDiscussions;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private static final long serialVersionUID = 1L;

	public Forum() {
		super();
	}   
	public Integer getIdForum() {
		return this.idForum;
	}

	public void setIdForum(Integer idForum) {
		this.idForum = idForum;
	}   
	public String getNameForum() {
		return this.nameForum;
	}

	public void setNameForum(String nameForum) {
		this.nameForum = nameForum;
	}   
	public String getDescForum() {
		return this.descForum;
	}

	public void setDescForum(String descForum) {
		this.descForum = descForum;
	}   
	public Integer getNbDiscussions() {
		return this.nbDiscussions;
	}

	public void setNbDiscussions(Integer nbDiscussions) {
		this.nbDiscussions = nbDiscussions;
	}
   
}
