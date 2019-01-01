package tn.esprit.com.ProjetPi.services;

import javax.ejb.Stateless;

import tn.esprit.com.ProjetPi.entities.Ressource;
import tn.esprit.com.ProjetPi.utilities.GenericDAO;

/**
 * Session Bean implementation class RessourceService
 */
@Stateless
public class RessourceService extends GenericDAO<Ressource> implements RessourceServiceRemote, RessourceServiceLocal {

    /**
     * Default constructor. 
     */
    public RessourceService() {
    	super(Ressource.class);
    }

}
