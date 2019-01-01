package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the Mandates database table.
 * 
 */
@Entity
@Table(name="Mandates")
@NamedQuery(name="Mandate.findAll", query="SELECT m FROM Mandate m")
public class Mandate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MandateId")
	private int mandateId;

	@Column(name="end_date")
	private Date endDate;

	private float fee;

	@Column(name="nb_task_done")
	private int nbTaskDone;

	private int nb_task_Todo;

	@Column(name="Start_date")
	private Date start_date;
	
	@Column(name="ActualEndDate")
	private Date actualEndDate;
	
	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	//bi-directional many-to-one association to MandateHistory
	@OneToMany(mappedBy="mandate")
	private List<MandateHistory> mandateHistories;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	private Ressource ressource;

	public Mandate() {
	}

	public int getMandateId() {
		return this.mandateId;
	}

	public void setMandateId(int mandateId) {
		this.mandateId = mandateId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getNbTaskDone() {
		return this.nbTaskDone;
	}

	public void setNbTaskDone(int nbTaskDone) {
		this.nbTaskDone = nbTaskDone;
	}

	public int getNb_task_Todo() {
		return this.nb_task_Todo;
	}

	public void setNb_task_Todo(int nb_task_Todo) {
		this.nb_task_Todo = nb_task_Todo;
	}

	public Date getStart_date() {
		return this.start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public List<MandateHistory> getMandateHistories() {
		return this.mandateHistories;
	}

	public void setMandateHistories(List<MandateHistory> mandateHistories) {
		this.mandateHistories = mandateHistories;
	}

	public MandateHistory addMandateHistory(MandateHistory mandateHistory) {
		getMandateHistories().add(mandateHistory);
		mandateHistory.setMandate(this);

		return mandateHistory;
	}

	public MandateHistory removeMandateHistory(MandateHistory mandateHistory) {
		getMandateHistories().remove(mandateHistory);
		mandateHistory.setMandate(null);

		return mandateHistory;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

}