package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the MandateHistories database table.
 * 
 */
@Entity
@Table(name="MandateHistories")
@NamedQuery(name="MandateHistory.findAll", query="SELECT m FROM MandateHistory m")
public class MandateHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MandatehistoryId")
	private int mandatehistoryId;

	@Column(name="ProjectId")
	private int projectId;

	@Column(name="RessourceId")
	private int ressourceId;

	private Date saveDate;

	//bi-directional many-to-one association to Mandate
	@ManyToOne
	@JoinColumn(name="MandateId")
	private Mandate mandate;

	public MandateHistory() {
	}

	public int getMandatehistoryId() {
		return this.mandatehistoryId;
	}

	public void setMandatehistoryId(int mandatehistoryId) {
		this.mandatehistoryId = mandatehistoryId;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getRessourceId() {
		return this.ressourceId;
	}

	public void setRessourceId(int ressourceId) {
		this.ressourceId = ressourceId;
	}

	public Date getSaveDate() {
		return this.saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Mandate getMandate() {
		return this.mandate;
	}

	public void setMandate(Mandate mandate) {
		this.mandate = mandate;
	}

}