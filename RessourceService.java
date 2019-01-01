package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import interfaces.RessourceLocal;
import interfaces.RessourceRemote;
import model.Ressource;
@Stateful
@LocalBean
public class RessourceService implements RessourceRemote,RessourceLocal{
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;
	
	@Override
	public List<Ressource> RessourceList() {
		Query query2 = em.createQuery("SELECT a from Ressource a");
		List<Ressource> rdvs=query2.getResultList();
		return rdvs;
	}

}
