package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EventParticipation
 *
 */
@Entity

public class EventParticipation implements Serializable {

	   
	@Id
	private Integer idParticipation;
	private Timestamp timeParticipation;
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	private  Event event;
	
	
	
	
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	private static final long serialVersionUID = 1L;

	public EventParticipation() {
		super();
	}   
	public Integer getIdParticipation() {
		return this.idParticipation;
	}

	public void setIdParticipation(Integer idParticipation) {
		this.idParticipation = idParticipation;
	}   
	public Timestamp getTimeParticipation() {
		return this.timeParticipation;
	}

	public void setTimeParticipation(Timestamp timeParticipation) {
		this.timeParticipation = timeParticipation;
	}
   
}
