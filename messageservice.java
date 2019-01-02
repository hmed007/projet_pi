package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import interfaces.messageinterfacelocal;
import model.Message;

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
	public List<Message> ListMessage(String mail) {
		TypedQuery<Message> query = em.createQuery(
			      "SELECT e FROM Message  e where e.EmailReciever=:email", Message.class).setParameter("email", mail);
			  List<Message> results = query.getResultList();
			  return results;
		// TODO Auto-generated method stub
	
	}
	public List<Message> allMessage() {
		TypedQuery<Message> query = em.createQuery(
			      "SELECT e FROM Message  e", Message.class);
			  List<Message> results = query.getResultList();
			  return results;
		// TODO Auto-generated method stub
	
	}
	public String GetEmail(int id){
		
		TypedQuery<String> query = em.createQuery(
			      "SELECT e.email FROM User e where e.id=:id", String.class).setParameter("id", id);
		 String results = query.getSingleResult();
		  return results;
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
			  System.out.println("MAILLLLLLLLLLLLLLLLL ====>"+bestMails.get(0));
			  return bestMails.get(0);
	}
	
	public long Countreclamation1(){
		 
	
		String sql ="Select count(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='1' and m.object='Reclamation' ";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		System.out.println("44444444444444444444444444444444444444"+count);
		return count;
	
		
		
	}
	public long Countreclamation2(){
		 
		
		String sql ="Select count(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='2' and m.object='Reclamation' ";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		System.out.println("44444444444444444444444444444444444444"+count);
		return count;
	
		
		
	}
	
	public long Countreclamation3(){
		 
		
		String sql ="Select count(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='3' and m.object='Reclamation' ";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		System.out.println("44444444444444444444444444444444444444"+count);
		return count;
	
		
		
	}
	public long Countreclamation4(){
		 
		
		String sql ="Select count(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='4' and m.object='Reclamation' ";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		System.out.println("44444444444444444444444444444444444444"+count);
		return count;
	
		
		
	}
	
	
	
	public long Countsatisfaction1(){
		String sql ="Select COUNT(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='1' and m.object='Satisfaction'";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		return count;
		
		
	}
	
	
	public long Countsatisfaction2(){
		String sql ="Select COUNT(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='2' and m.object='Satisfaction'";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		return count;
		
		
	}
	public long Countsatisfaction3(){
		String sql ="Select COUNT(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='3' and m.object='Satisfaction'";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		return count;
		
		
	}
	public long Countsatisfaction4(){
		String sql ="Select COUNT(m.id) FROM Message m where DATEPART(quarter,m.sentDate)='4' and m.object='Satisfaction'";
		Query q =em.createQuery(sql);
		long count=(long) q.getSingleResult();
		return count;
		
		
	}
	
}
