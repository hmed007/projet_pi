package tn.esprit.com.ProjetPi.services;

import javax.ejb.Local;

import tn.esprit.com.ProjetPi.entities.User;
import tn.esprit.com.ProjetPi.utilities.IGenericDAO;

@Local
public interface UserServiceLocal extends IGenericDAO<User> {

	User login(String login, String password);

}
