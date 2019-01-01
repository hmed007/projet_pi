package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ApplicantRessources database table.
 * 
 */
@Entity
@Table(name="ApplicantRessources")
@NamedQuery(name="ApplicantRessource.findAll", query="SELECT a FROM ApplicantRessource a")
public class ApplicantRessource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppResId")
	private int appResId;

	//bi-directional many-to-one association to Applicant
	@ManyToOne
	@JoinColumn(name="applicantId")
	private Applicant applicant;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="ressourceId")
	private Ressource ressource;

	public ApplicantRessource() {
	}

	public int getAppResId() {
		return this.appResId;
	}

	public void setAppResId(int appResId) {
		this.appResId = appResId;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

}