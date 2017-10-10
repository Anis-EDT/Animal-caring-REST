package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Respond
 *
 */
@Entity

public class Respond implements Serializable {

	   
	@Id
	private Integer idRespond;
	private String contentRespond;
	private boolean enabled;
	private Date createdAt;
	private String image;
	private String video;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private static final long serialVersionUID = 1L;

	public Respond() {
		super();
	}   
	public Integer getIdRespond() {
		return this.idRespond;
	}

	public void setIdRespond(Integer idRespond) {
		this.idRespond = idRespond;
	}   
	public String getContentRespond() {
		return this.contentRespond;
	}

	public void setContentRespond(String contentRespond) {
		this.contentRespond = contentRespond;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}   
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}   
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}   
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
   
}
