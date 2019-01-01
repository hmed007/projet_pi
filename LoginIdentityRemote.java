package interfaces;

import javax.ejb.Remote;

import model.Applicant;
import model.User;

@Remote
public interface LoginIdentityRemote {
	public String LoginIdentity(String email,String pass);
	public int LoggedUser(String email);
	public int LoggedUser();

}
