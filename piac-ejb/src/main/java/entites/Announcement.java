package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Announcement
 *
 */
@Entity

public class Announcement implements Serializable {

	   
	@Id
	private Integer idAnnouncement;
	private String title;
	private String description;
	private float price;
	private Timestamp timeCreated;
	private Timestamp timeModified;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private static final long serialVersionUID = 1L;

	public Announcement() {
		super();
	}   
	public Integer getIdAnnouncement() {
		return this.idAnnouncement;
	}

	public void setIdAnnouncement(Integer idAnnouncement) {
		this.idAnnouncement = idAnnouncement;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}   
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}   
	public Timestamp getTimeModified() {
		return this.timeModified;
	}

	public void setTimeModified(Timestamp timeModified) {
		this.timeModified = timeModified;
	}
   
}
