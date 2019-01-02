package beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Answer;
import model.Question;
import services.Consommation;

@ManagedBean
@SessionScoped
public class consommationBean {
	private List dash;
	private List<Question> questions;
	private List<Answer> answers;
	private int questionSelected;
	public int getQuestionSelected() {
		return questionSelected;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setQuestionSelected(int questionSelected) {
		this.questionSelected = questionSelected;
		
	}

	public String questionAnswers(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action = params.get("action");
		System.out.println(action);
		answers= consommation.Answers(action);
		return "Reponses.xhtml";
	}
	
	public String deleteQuestion(){
		Map<String,String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String action = params.get("del");
		System.out.println(action);
		consommation.DeleteQuestion(action);
		return "ListQuestion.xhtml";
	}
	
	@EJB
	Consommation consommation;
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@PostConstruct
	public void init(){
		dash=consommation.dash();
	}

	public List<Question> allQuestions(){
		questions=consommation.questions();
		return questions;
	}
	public List getDash() {
		return dash;
	}

	public void setDash(List list) {
		this.dash = list;
	}
	
}
