package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Questions database table.
 * 
 */
@Entity
@Table(name="Questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionId;

	private String category;

	private String question;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	//bi-directional many-to-one association to ApplicantAnswer
	@OneToMany(mappedBy="question")
	private List<ApplicantAnswer> applicantAnswers;

	//bi-directional many-to-one association to Applicant
	@ManyToOne
	private Applicant applicant;

	public Question() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}

	public List<ApplicantAnswer> getApplicantAnswers() {
		return this.applicantAnswers;
	}

	public void setApplicantAnswers(List<ApplicantAnswer> applicantAnswers) {
		this.applicantAnswers = applicantAnswers;
	}

	public ApplicantAnswer addApplicantAnswer(ApplicantAnswer applicantAnswer) {
		getApplicantAnswers().add(applicantAnswer);
		applicantAnswer.setQuestion(this);

		return applicantAnswer;
	}

	public ApplicantAnswer removeApplicantAnswer(ApplicantAnswer applicantAnswer) {
		getApplicantAnswers().remove(applicantAnswer);
		applicantAnswer.setQuestion(null);

		return applicantAnswer;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

}