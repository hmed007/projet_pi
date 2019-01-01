package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ApplicantAnswers database table.
 * 
 */
@Entity
@Table(name="ApplicantAnswers")
@NamedQuery(name="ApplicantAnswer.findAll", query="SELECT a FROM ApplicantAnswer a")
public class ApplicantAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ApplicantAnswerId")
	private int applicantAnswerId;

	private int app_answerId;

	private String questionType;

	//bi-directional many-to-one association to Applicant
	@ManyToOne
	@JoinColumn(name="applicantId")
	private Applicant applicant;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="questionId")
	private Question question;

	public ApplicantAnswer() {
	}

	public int getApplicantAnswerId() {
		return this.applicantAnswerId;
	}

	public void setApplicantAnswerId(int applicantAnswerId) {
		this.applicantAnswerId = applicantAnswerId;
	}

	public int getApp_answerId() {
		return this.app_answerId;
	}

	public void setApp_answerId(int app_answerId) {
		this.app_answerId = app_answerId;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}