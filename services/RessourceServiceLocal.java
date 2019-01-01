package tn.esprit.com.ProjetPi.services;

import javax.ejb.Local;

import tn.esprit.com.ProjetPi.entities.Ressource;
import tn.esprit.com.ProjetPi.utilities.IGenericDAO;

@Local
public interface RessourceServiceLocal extends IGenericDAO<Ressource>{

}
