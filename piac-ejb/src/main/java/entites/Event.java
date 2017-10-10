package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	   
	@Id
	private Integer idEvent;
	private String name;
	private String description;
	private Date dateBegin;
	private Date dateEnd;
	private String type;
	private Date dateCreated;
	private String location;
	private Integer nbParticipation;
	private Integer nbParticipated;
	private Integer nbInterrested;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event() {
		super();
	}   
	public Integer getIdEvent() {
		return this.idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}   
	public Integer getNbInterrested() {
		return nbInterrested;
	}
	public void setNbInterrested(Integer nbInterrested) {
		this.nbInterrested = nbInterrested;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Date getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}   
	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public Integer getNbParticipation() {
		return this.nbParticipation;
	}

	public void setNbParticipation(Integer nbParticipation) {
		this.nbParticipation = nbParticipation;
	}   
	public Integer getNbParticipated() {
		return this.nbParticipated;
	}

	public void setNbParticipated(Integer nbParticipated) {
		this.nbParticipated = nbParticipated;
	}
   
}
