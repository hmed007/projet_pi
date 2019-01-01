package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Applicant;
import model.User;
import services.ApplicantService;

@ManagedBean
@SessionScoped
public class ApplicantBean {
	@EJB
	ApplicantService consommation;
	@ManagedProperty(value="#{ressourceBean}")
    private RessourceBean ressourcebean;
	
	public RessourceBean getRessourcebean() {
		return ressourcebean;
	}
	public void setRessourcebean(RessourceBean ressourcebean) {
		this.ressourcebean = ressourcebean;
	}

	private List<Applicant> applicantsPre;
	private String selectedPreApplicant;
	private String selectedUserName;
	private String rdvDate;
	
	public String getSelectedUserName() {
		return selectedUserName;
	}
	public void setSelectedUserName(String selectedUserName) {
		this.selectedUserName = selectedUserName;
	}
	public String getRdvDate() {
		return rdvDate;
	}
	public void setRdvDate(String rdvDate) {
		this.rdvDate = rdvDate;
	}
	public String getSelectedPreApplicant() {
		return selectedPreApplicant;
	}
	public void setSelectedPreApplicant(String selectedPreApplicant) {
		this.selectedPreApplicant = selectedPreApplicant;
	}
	public List<Applicant> getApplicantsPre() {
		return applicantsPre;
	}
	public void setApplicantsPre(List<Applicant> applicantsPre) {
		this.applicantsPre = applicantsPre;
	}
	
	@PostConstruct
	public void init(){
		applicantsPre=consommation.PreEmployed();
	}
	
	
	public String RDV(){
		Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action = params.get("id");
		selectedPreApplicant=action;
		Map<String,String> params2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String action2 = params2.get("username");
		selectedUserName=action2;
		return "FixRDV.xhtml";
	}
	
	public String submitRDV() throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(rdvDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		
		consommation.FixRDV(Integer.parseInt(selectedPreApplicant), sqlStartDate,ressourcebean.getSelectedid());
		applicantsPre=consommation.PreEmployed();
		return "PreEmployed.xhtml";
	}
}
