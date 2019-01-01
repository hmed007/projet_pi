package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Applicant;
import model.User;
import services.IdentityLogin;

@ManagedBean
@SessionScoped
public class LoginIdentity {
	@EJB
	IdentityLogin consommation;
	
	private User user;
	private int loggeduser;
	private String mail;
	private String pass;
	
	
	public int getLoggeduser() {
		return loggeduser;
	}
	public void setLoggeduser(int loggeduser) {
		this.loggeduser = loggeduser;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setApplicant(User user) {
		this.user = user;
	}public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String Login(){
		String navigateTo="";
		String res=consommation.LoginIdentity(mail, pass);
		System.out.println(res);
		if(res.contains("Applicant.xhtml")){
			navigateTo="Applicant.xhtml";
		}else if (res.contains("Admin.xhtml")) {
			navigateTo="Admin.xhtml";
		}else if (res.contains("Ressource.xhtml")) {
			navigateTo="Ressource.xhtml";
		}else if (res.contains("Client.xhtml")){
			navigateTo="Client.xhtml";
		}else {
			navigateTo="Index.xhtml";
		}
		int a =consommation.LoggedUser(mail);
		int b =consommation.LoggedUser();
		loggeduser=a;
		System.out.println(a);
		System.out.println(a);
		System.out.println(a);
		System.out.println(b);
		System.out.println(b);
		System.out.println(b);
		return navigateTo;
	}
}
