package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Answers database table.
 * 
 */
@Entity
@Table(name="Answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AnswerId")
	private int answerId;

	private String answer;

	private int type;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="questionId")
	private Question question;

	public Answer() {
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}