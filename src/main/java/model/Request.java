package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the Requests database table.
 * 
 */
@Entity
@Table(name="Requests")
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RequestId")
	private int requestId;

	@Column(name="deposit_date")
	private Date depositDate;

	@Column(name="deposit_hour")
	private Date depositHour;

	@Column(name="education_scolarity")
	private String educationScolarity;

	@Column(name="end_date_mandate")
	private Date endDateMandate;

	@Column(name="experience_year")
	private String experienceYear;

	private String manager;

	@Column(name="requested_profil")
	private String requestedProfil;

	@Column(name="Start_date_mandate")
	private Date start_date_mandate;

	private int statuss;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ClientId")
	private Client client;

	public Request() {
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Date getDepositDate() {
		return this.depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public Date getDepositHour() {
		return this.depositHour;
	}

	public void setDepositHour(Date depositHour) {
		this.depositHour = depositHour;
	}

	public String getEducationScolarity() {
		return this.educationScolarity;
	}

	public void setEducationScolarity(String educationScolarity) {
		this.educationScolarity = educationScolarity;
	}

	public Date getEndDateMandate() {
		return this.endDateMandate;
	}

	public void setEndDateMandate(Date endDateMandate) {
		this.endDateMandate = endDateMandate;
	}

	public String getExperienceYear() {
		return this.experienceYear;
	}

	public void setExperienceYear(String experienceYear) {
		this.experienceYear = experienceYear;
	}

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getRequestedProfil() {
		return this.requestedProfil;
	}

	public void setRequestedProfil(String requestedProfil) {
		this.requestedProfil = requestedProfil;
	}

	public Date getStart_date_mandate() {
		return this.start_date_mandate;
	}

	public void setStart_date_mandate(Date start_date_mandate) {
		this.start_date_mandate = start_date_mandate;
	}

	public int getStatuss() {
		return this.statuss;
	}

	public void setStatuss(int statuss) {
		this.statuss = statuss;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}