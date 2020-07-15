package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Answer;
import model.Message;
import model.Question;

@Remote
public interface ConsommationRemote {
	public void consommation(String q,String r1,String r2,String r3);
	public void consommationTechnique(String q,String r1,String r2,String r3);
	public List dash();
	public List<Question> questions();
	public List<Answer> Answers(String id);
	public void DeleteQuestion(String id);

}
