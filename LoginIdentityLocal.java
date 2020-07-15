package interfaces;

import javax.ejb.Local;

import model.Applicant;
import model.User;

@Local
public interface LoginIdentityLocal {
	public String LoginIdentity(String email,String pass);
	public int LoggedUser(String email);
	public int LoggedUser();
}
