package tn.esprit.com.ProjetPi.services;

import javax.ejb.Local;

import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.utilities.IGenericDAO;

@Local
public interface LeaveServiceLocal extends IGenericDAO<Leave> {

}
