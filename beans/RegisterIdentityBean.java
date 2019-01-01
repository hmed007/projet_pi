package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.RegisterService;

@ManagedBean
@SessionScoped
public class RegisterIdentityBean {
	private String mail;
	private String role;
	private String pass;
	private String confirmpass;
	@EJB
	RegisterService consommation;
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String Register(){
		return consommation.Register(mail, pass, role);
	}
}
