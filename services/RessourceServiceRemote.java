package tn.esprit.com.ProjetPi.services;

import javax.ejb.Remote;

import tn.esprit.com.ProjetPi.entities.Ressource;
import tn.esprit.com.ProjetPi.utilities.IGenericDAO;

@Remote
public interface RessourceServiceRemote extends IGenericDAO<Ressource> {

}
