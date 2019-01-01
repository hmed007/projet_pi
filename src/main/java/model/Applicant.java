package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Applicant database table.
 * 
 */
@Entity
@NamedQuery(name="Applicant.findAll", query="SELECT a FROM Applicant a")
public class Applicant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="applicant_state")
	private int applicantState;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="Id")
	private User user;

	//bi-directional many-to-one association to ApplicantAnswer
	@OneToMany(mappedBy="applicant")
	private List<ApplicantAnswer> applicantAnswers;

	//bi-directional many-to-one association to ApplicantRequest
	@OneToMany(mappedBy="applicant")
	private List<ApplicantRequest> applicantRequests;

	//bi-directional many-to-one association to ApplicantRessource
	@OneToMany(mappedBy="applicant")
	private List<ApplicantRessource> applicantRessources;

	//bi-directional one-to-one association to Arrival
	@OneToOne(mappedBy="applicant")
	private Arrival arrival;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="applicant")
	private List<Question> questions;

	//bi-directional many-to-one association to RDV
	@OneToMany(mappedBy="applicant")
	private List<RDV> rdvs;

	public Applicant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApplicantState() {
		return this.applicantState;
	}

	public void setApplicantState(int applicantState) {
		this.applicantState = applicantState;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ApplicantAnswer> getApplicantAnswers() {
		return this.applicantAnswers;
	}

	public void setApplicantAnswers(List<ApplicantAnswer> applicantAnswers) {
		this.applicantAnswers = applicantAnswers;
	}

	public ApplicantAnswer addApplicantAnswer(ApplicantAnswer applicantAnswer) {
		getApplicantAnswers().add(applicantAnswer);
		applicantAnswer.setApplicant(this);

		return applicantAnswer;
	}

	public ApplicantAnswer removeApplicantAnswer(ApplicantAnswer applicantAnswer) {
		getApplicantAnswers().remove(applicantAnswer);
		applicantAnswer.setApplicant(null);

		return applicantAnswer;
	}

	public List<ApplicantRequest> getApplicantRequests() {
		return this.applicantRequests;
	}

	public void setApplicantRequests(List<ApplicantRequest> applicantRequests) {
		this.applicantRequests = applicantRequests;
	}

	public ApplicantRequest addApplicantRequest(ApplicantRequest applicantRequest) {
		getApplicantRequests().add(applicantRequest);
		applicantRequest.setApplicant(this);

		return applicantRequest;
	}

	public ApplicantRequest removeApplicantRequest(ApplicantRequest applicantRequest) {
		getApplicantRequests().remove(applicantRequest);
		applicantRequest.setApplicant(null);

		return applicantRequest;
	}

	public List<ApplicantRessource> getApplicantRessources() {
		return this.applicantRessources;
	}

	public void setApplicantRessources(List<ApplicantRessource> applicantRessources) {
		this.applicantRessources = applicantRessources;
	}

	public ApplicantRessource addApplicantRessource(ApplicantRessource applicantRessource) {
		getApplicantRessources().add(applicantRessource);
		applicantRessource.setApplicant(this);

		return applicantRessource;
	}

	public ApplicantRessource removeApplicantRessource(ApplicantRessource applicantRessource) {
		getApplicantRessources().remove(applicantRessource);
		applicantRessource.setApplicant(null);

		return applicantRessource;
	}

	public Arrival getArrival() {
		return this.arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setApplicant(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setApplicant(null);

		return question;
	}

	public List<RDV> getRdvs() {
		return this.rdvs;
	}

	public void setRdvs(List<RDV> rdvs) {
		this.rdvs = rdvs;
	}

	public RDV addRdv(RDV rdv) {
		getRdvs().add(rdv);
		rdv.setApplicant(this);

		return rdv;
	}

	public RDV removeRdv(RDV rdv) {
		getRdvs().remove(rdv);
		rdv.setApplicant(null);

		return rdv;
	}

}