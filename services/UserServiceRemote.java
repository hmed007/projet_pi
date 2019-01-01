package tn.esprit.com.ProjetPi.services;

import javax.ejb.Remote;

import tn.esprit.com.ProjetPi.entities.User;
import tn.esprit.com.ProjetPi.utilities.IGenericDAO;

@Remote
public interface UserServiceRemote extends IGenericDAO<User> {

}
