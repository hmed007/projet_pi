package beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Applicant;
import services.MailService;

@ManagedBean
@SessionScoped
public class MailBean {
	@EJB
	MailService consommation;
	private String mail;
	private String username;
	private List<Applicant> apps;
	
	public List<Applicant> getApps() {
		return apps;
	}
	public void setApps(List<Applicant> apps) {
		this.apps = apps;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@PostConstruct
	public void init(){
		apps=consommation.PreEmployed();
	}
	public void SendMail(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action = params.get("mail");
		mail=action;
		Map<String,String> params2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action2 = params2.get("username");
		username=action2;
		consommation.envoyerEmail(action, action2);
	}
}
