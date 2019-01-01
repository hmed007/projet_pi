package services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import interfaces.ApplicantLocal;
import interfaces.ApplicantRemote;
import model.Applicant;
import model.ApplicantRessource;
import model.RDV;
import model.Ressource;
import model.User;

@Stateful
@LocalBean
public class ApplicantService implements ApplicantLocal,ApplicantRemote{
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;

	@Override
	public List<Applicant> PreEmployed() {
		int state=1;
		Query query = em.createQuery("SELECT a from Applicant a where a.applicantState=:state");
		query.setParameter("state", state);
		Query query2 = em.createQuery("SELECT a from RDV a");
		List<RDV> rdvs=query2.getResultList();
		List<Applicant> app=query.getResultList();
		List<Applicant> res=new ArrayList<>();
		for (Applicant applicant : app) {
			boolean b=false;
			for (RDV rdv : rdvs) {
				if(applicant.getId()==rdv.getApplicant().getId()){
					b=true;
				}
			}
			if(b==false){
				res.add(applicant);
			}
		}
		return res;
	}

	@Override
	public void FixRDV(int id, Date d, int idr) {
		RDV rdv=new RDV();
		ApplicantRessource ar=new ApplicantRessource();
		rdv.setApplicant(em.find(Applicant.class, id));
		rdv.setDateRdv(d);
		rdv.setStateRdv(0);
		System.out.println(d);
		ar.setApplicant(em.find(Applicant.class, id));
		ar.setRessource(em.find(Ressource.class, idr));
		em.persist(ar);
		em.persist(rdv);
		System.out.println("okok");
		
	}
}
