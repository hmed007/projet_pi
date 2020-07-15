package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Applicant;

@Remote
public interface MailRemote {
	public void envoyerEmail(String username,String mail) ;
	public List<Applicant> PreEmployed() ;
}
