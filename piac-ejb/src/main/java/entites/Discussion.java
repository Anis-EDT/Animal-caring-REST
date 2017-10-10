package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Discussion
 *
 */
@Entity

public class Discussion implements Serializable {

	@Id
	private Integer idDiscussion;
	private String subjectDiscussion;
	private String contentDiscussion;
	private Integer nbResponds;
	private Date createdAt;
	private boolean enabled;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private static final long serialVersionUID = 1L;

	public Discussion() {
		super();
	}   
	public Integer getIdDiscussion() {
		return this.idDiscussion;
	}

	public void setIdDiscussion(Integer idDiscussion) {
		this.idDiscussion = idDiscussion;
	}   
	public String getSubjectDiscussion() {
		return this.subjectDiscussion;
	}

	public void setSubjectDiscussion(String subjectDiscussion) {
		this.subjectDiscussion = subjectDiscussion;
	}   
	public String getContentDiscussion() {
		return this.contentDiscussion;
	}

	public void setContentDiscussion(String contentDiscussion) {
		this.contentDiscussion = contentDiscussion;
	}   
	public Integer getNbResponds() {
		return this.nbResponds;
	}

	public void setNbResponds(Integer nbResponds) {
		this.nbResponds = nbResponds;
	}   
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
   
}
