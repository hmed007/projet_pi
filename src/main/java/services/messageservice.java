package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import interfaces.messageinterfacelocal;
import model.Message;
import model.Project;

@Stateful
@LocalBean
public class messageservice implements messageinterfacelocal {
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;
	
	@Override
	public void EnvoyerMessage(Message msg) {
		// TODO Auto-generated method stub
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
	
      msg.setSentDate(date);
      
      String sql = "SELECT COUNT(m.id) FROM User m WHERE m.email=:email";
		Query query = em.createQuery(sql);
		query.setParameter("email", msg.getEmailReciever());
		long count=(long)query.getSingleResult();
		if (count==1){
		em.persist(msg);}
		else {System.out.println("ce mail n'existe pas");}
	}

	@Override
	public List<Message> ListMessage() {
		TypedQuery<Message> query = em.createQuery(
			      "SELECT e FROM Message  e where e.EmailReciever=:email", Message.class).setParameter("email", "haythem.benjeddou@esprit.tn");
			  List<Message> results = query.getResultList();
			  return results;
		// TODO Auto-generated method stub
	}
	/*
	@Override
	public int nbProjects() {
		TypedQuery<Project> query = em.createQuery(
			      "SELECT count(Total_number_ressource) FROM Project ", Project.class);
			  integer results = query.getResultList();
			  return results;
		// TODO Auto-generated method stub
	}
	*/
	
	public List<Message> allMessage() {
		TypedQuery<Message> query = em.createQuery(
			      "SELECT e FROM Message  e", Message.class);
			  List<Message> results = query.getResultList();
			  return results;
		// TODO Auto-generated method stub
	
	}

	@Override
	public List<Message> filterbyobject(String filter) {
		// TODO Auto-generated method stub
		TypedQuery<Message> query = em.createQuery(
			      "SELECT e FROM Message  e where e.object=:object", Message.class).setParameter("object", filter);
			  List<Message> results = query.getResultList();
			  return results;
	}

	@Override
	public String topresource() {
		TypedQuery<String> query = em.createQuery(
				"select m.EmailReciever from Message m where m.object=:object group by m.EmailReciever", String.class).setParameter("object","Satisfaction");
			  List<String>bestMails=query.getResultList();
			  System.out.println("MAIL ====>"+bestMails.get(0));
			  return bestMails.get(0);
	}
}
