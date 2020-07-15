package interfaces;

import java.util.List;

import javax.ejb.Local;

import model.Applicant;

@Local
public interface MailLocal {
	public void envoyerEmail(String username,String mail) ;
	public List<Applicant> PreEmployed() ;

}
