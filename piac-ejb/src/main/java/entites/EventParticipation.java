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
