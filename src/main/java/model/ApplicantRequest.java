package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the ApplicantRequests database table.
 * 
 */
@Entity
@Table(name="ApplicantRequests")
@NamedQuery(name="ApplicantRequest.findAll", query="SELECT a FROM ApplicantRequest a")
public class ApplicantRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApplicantRequestId")
	private int applicantRequestId;

	@Column(name="app_req_date")
	private Date appReqDate;

	@Column(name="app_req_state")
	private int appReqState;

	private String specialty;

	//bi-directional many-to-one association to Applicant
	@ManyToOne
	@JoinColumn(name="applicantId")
	private Applicant applicant;

	public ApplicantRequest() {
	}

	public int getApplicantRequestId() {
		return this.applicantRequestId;
	}

	public void setApplicantRequestId(int applicantRequestId) {
		this.applicantRequestId = applicantRequestId;
	}

	public Date getAppReqDate() {
		return this.appReqDate;
	}

	public void setAppReqDate(Date appReqDate) {
		this.appReqDate = appReqDate;
	}

	public int getAppReqState() {
		return this.appReqState;
	}

	public void setAppReqState(int appReqState) {
		this.appReqState = appReqState;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}