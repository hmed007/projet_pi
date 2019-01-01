package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import interfaces.ConsommationLocal;
import interfaces.ConsommationRemote;
import model.Answer;
import model.Message;
import model.Question;

@Stateful
@LocalBean
public class Consommation implements ConsommationLocal,ConsommationRemote{
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;

	@Override
	public void consommation(String q,String r1,String r2,String r3) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/AddFrenshQuestionJ");
		final Form form = new Form()
	            .param("ques", q)
	            .param("rep1", r1)
	            .param("rep2", r2)
	            .param("rep3", r3);
		Response response=target.request().post(Entity.form(form));
		String res=response.readEntity(String.class);
		System.out.println(res);
		response.close();
	}
	@Override
	public List dash() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/DashJ");
		Response response=target.request().get();
		List res=response.readEntity(List.class);
			  return res;
		// TODO Auto-generated method stub
	
	}
	@Override
	public List<Question> questions() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/QuestionListJ");
		Response response=target.request().get();
		List<Question> res=response.readEntity(List.class);
		return res;
		
	}
	@Override
	public List<Answer> Answers(String id) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/AnswersJ");
		final Form form = new Form()
	            .param("id", id);
		Response response=target.request().post(Entity.form(form));
		List<Answer> res=response.readEntity(List.class);
		System.out.println(res);
		response.close();
		return res;
	}
	@Override
	public void DeleteQuestion(String id) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/DeleteQuestionJ");
		final Form form = new Form()
	            .param("id", id);
		Response response=target.request().post(Entity.form(form));
		String res=response.readEntity(String.class);
		System.out.println(res);
		response.close();
	}
	@Override
	public void consommationTechnique(String q, String r1, String r2, String r3) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/AddTechnicalQuestionJ");
		final Form form = new Form()
	            .param("ques", q)
	            .param("rep1", r1)
	            .param("rep2", r2)
	            .param("rep3", r3);
		Response response=target.request().post(Entity.form(form));
		String res=response.readEntity(String.class);
		System.out.println(res);
		response.close();
		
	}



}
