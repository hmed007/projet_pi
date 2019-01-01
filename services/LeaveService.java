package tn.esprit.com.ProjetPi.services;

import javax.ejb.Stateless;

import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.utilities.GenericDAO;

/**
 * Session Bean implementation class LeaveService
 */
@Stateless
public class LeaveService extends GenericDAO<Leave> implements LeaveServiceRemote, LeaveServiceLocal {

    /**
     * Default constructor. 
     */
    public LeaveService() {
    	super(Leave.class);
    }

}
