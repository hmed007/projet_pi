package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import interfaces.StatLocal;
import interfaces.StatRemote;

@Stateful
@LocalBean
public class StatService implements  StatRemote,StatLocal{
	
	@PersistenceContext(unitName="projetpi1-ejb")
	EntityManager em;
	
	public long NumberApplicantState(){
		String sql="SELECT COUNT(a.id) FROM Applicant a WHERE a.applicantState=0";
		Query q = em.createQuery(sql);
		Long count=(Long) q.getSingleResult();
		return count;
	}
	
	public long NumberApplicantState1(){
		String sql="SELECT COUNT(a.id) FROM Applicant a WHERE a.applicantState=1";
		Query q = em.createQuery(sql);
		Long count=(Long) q.getSingleResult();
		return count;
	}
	
	public long NumberApplicantState2(){
		String sql="SELECT COUNT(a.id) FROM Applicant a WHERE a.applicantState=2";
		Query q = em.createQuery(sql);
		Long count=(Long) q.getSingleResult();
		return count;
	}
	
	public long NumberApplicantState3(){
		String sql="SELECT COUNT(a.id) FROM Applicant a WHERE a.applicantState=3";
		Query q = em.createQuery(sql);
		Long count=(Long) q.getSingleResult();
		return count;
	}
	
}
