package services;

import java.sql.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import interfaces.ArrivalLocal;
import interfaces.ArrivalRemote;
import model.Applicant;
import model.Arrival;

@Stateful
@LocalBean
public class ArrivalService implements ArrivalLocal,ArrivalRemote{
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;

	@Override
	public void AddArrival(Date d,int id) {
		Arrival arrival=new Arrival();
		arrival.setDateArrival(d);
		arrival.setApplicantId(id);
		arrival.setApplicant(em.find(Applicant.class, id));
		Applicant a=em.find(Applicant.class, id);
		a.setArrival(arrival);
		em.persist(arrival);
		
	}
	
}
