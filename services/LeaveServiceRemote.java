package tn.esprit.com.ProjetPi.services;

import javax.ejb.Remote;

import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.utilities.IGenericDAO;

@Remote
public interface LeaveServiceRemote extends IGenericDAO<Leave>{

}
