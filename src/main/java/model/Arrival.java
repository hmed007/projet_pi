package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the Arrivals database table.
 * 
 */
@Entity
@Table(name="Arrivals")
@NamedQuery(name="Arrival.findAll", query="SELECT a FROM Arrival a")
public class Arrival implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ArrivalId")
	private int arrivalId;

	@Column(name="ApplicantId")
	private int applicantId;

	@Column(name="DateArrival")
	private Date dateArrival;

	//bi-directional one-to-one association to Applicant
	@OneToOne
	@JoinColumn(name="ArrivalId")
	private Applicant applicant;

	public Arrival() {
	}

	public int getArrivalId() {
		return this.arrivalId;
	}

	public void setArrivalId(int arrivalId) {
		this.arrivalId = arrivalId;
	}

	public int getApplicantId() {
		return this.applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public Date getDateArrival() {
		return this.dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}