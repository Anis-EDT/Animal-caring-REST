package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: EventInterrested
 *
 */
@Entity

public class EventInterrested implements Serializable {

	   
	@Id
	private Integer idInterrested;
	private Timestamp timeInterrested;
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

	public EventInterrested() {
		super();
	}   
	public Integer getIdInterrested() {
		return this.idInterrested;
	}

	public void setIdInterrested(Integer idInterrested) {
		this.idInterrested = idInterrested;
	}   
	public Timestamp getTimeInterrested() {
		return this.timeInterrested;
	}

	public void setTimeInterrested(Timestamp timeInterrested) {
		this.timeInterrested = timeInterrested;
	}
   
}
