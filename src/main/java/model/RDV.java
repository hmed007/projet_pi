package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the RDVs database table.
 * 
 */
@Entity
@Table(name="RDVs")
@NamedQuery(name="RDV.findAll", query="SELECT r FROM RDV r")
public class RDV implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RdvId")
	private int rdvId;

	@Column(name="DateRdv")
	private Date dateRdv;

	@Column(name="StateRdv")
	private int stateRdv;

	//bi-directional many-to-one association to Applicant
	@ManyToOne
	@JoinColumn(name="ApplicantId")
	private Applicant applicant;

	public RDV() {
	}

	public int getRdvId() {
		return this.rdvId;
	}

	public void setRdvId(int rdvId) {
		this.rdvId = rdvId;
	}

	public Date getDateRdv() {
		return this.dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public int getStateRdv() {
		return this.stateRdv;
	}

	public void setStateRdv(int stateRdv) {
		this.stateRdv = stateRdv;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}