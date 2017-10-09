package entites;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Donation
 *
 */
@Entity

public class Donation implements Serializable {

	   
	@Id
	private Integer idDonation;
	private String type;
	private String description;
	private String img;
	private float amount;
	private static final long serialVersionUID = 1L;

	public Donation() {
		super();
	}   
	public Integer getIdDonation() {
		return this.idDonation;
	}

	public void setIdDonation(Integer idDonation) {
		this.idDonation = idDonation;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}   
	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
   
}
