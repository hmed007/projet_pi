package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Mandate;
import model.Project;
import services.Consommation;

@ManagedBean
@SessionScoped
public class consommationBean {
	private List dash;
	private List chart;
	
	private int nbUsers;
	private int nbClients;
	private int nbRessources;
	private int nbApplicants;
	
	private int inprogressprojects;
	private int Newprojects;
	private int finishedprojects;
	private int fi;
	
	private int NbDays;
	private float ReturnFeee;
	private float Cout;
	private float SUMBenefice;

	private long NbToatalRs;
	private long NbLevioRs;
	
	private long NumberFreelancers;
	private long NumberEmployees;
	
	private long NumberEmployeesInMandates;
	
	private List<Project> getAllProjects;
	private List<Mandate> getAllMandates;
	
	private long NBreclamationsCount ;
	private long NBsatisfactionsCount;
	private float NoteSatisfactionRate;

	
	public float getNoteSatisfactionRate() {
		return NoteSatisfactionRate;
	}

	public void setNoteSatisfactionRate(float noteSatisfactionRate) {
		NoteSatisfactionRate = noteSatisfactionRate;
	}

	public long getNBsatisfactionsCount() {
		return NBsatisfactionsCount;
	}

	public void setNBsatisfactionsCount(long nBsatisfactionsCount) {
		NBsatisfactionsCount = nBsatisfactionsCount;
	}

	public long getNBreclamationsCount() {
		return NBreclamationsCount;
	}

	public void setNBreclamationsCount(long nBreclamationsCount) {
		NBreclamationsCount = nBreclamationsCount;
	}

	/*
	private float projectEfficiencyyy;


	
	
	
	
	public float getProjectEfficiency() {
		return projectEfficiencyyy;
	}

	public void setProjectEfficiency(float projectEfficiency) {
		this.projectEfficiencyyy = projectEfficiency;
	}
*/
	public  float getmethodeeffiproject(int idp){
		return consommation.projectEfficiency(idp);
	}
	
	public float getmethodeeffimandate(int idm){
		return consommation.mandateEfficiency(idm);
	}
	public List<Mandate> getGetAllMandates() {
		return getAllMandates;
	}

	public void setGetAllMandates(List<Mandate> getAllMandates) {
		this.getAllMandates = getAllMandates;
	}

	public List<Project> getGetAllProjects() {
		return getAllProjects ;
	}

	public void setGetAllProjects(List<Project> getAllProjects) {
		this.getAllProjects = getAllProjects;
	}
	
	public long getNumberEmployeesInMandates() {
		return NumberEmployeesInMandates;
	}

	public void setNumberEmployeesInMandates(long numberEmployeesInMandates) {
		NumberEmployeesInMandates = numberEmployeesInMandates;
	}
	
	public long getNumberEmployees() {
		return NumberEmployees;
	}

	public void setNumberEmployees(long numberEmployees) {
		NumberEmployees = numberEmployees;
	}

	public long getNumberFreelancers() {
		return NumberFreelancers;
	}

	public void setNumberFreelancers(long numberFreelancers) {
		NumberFreelancers = numberFreelancers;
	}

	public long getNbLevioRs() {
		return NbLevioRs;
	}

	public void setNbLevioRs(long nbLevioRs) {
		NbLevioRs = nbLevioRs;
	}

	public long getNbToatalRs() {
		return NbToatalRs;
	}

	public void setNbToatalRs(long nbToatalRs) {
		NbToatalRs = nbToatalRs;
	}

	public int getNbDays() {
		return NbDays;
	}

	public void setNbDays(int nbDays) {
		NbDays = nbDays;
	}

	public float getReturnFeee() {
		return ReturnFeee;
	}

	public void setReturnFeee(float returnFeee) {
		ReturnFeee = returnFeee;
	}

	public float getCout() {
		return Cout;
	}

	public void setCout(float cout) {
		Cout = cout;
	}

	public float getSUMBenefice() {
		return SUMBenefice;
	}

	public void setSUMBenefice(float sUMBenefice) {
		SUMBenefice = sUMBenefice;
	}

	public int getFi() {
		return fi;
	}

	public void setFi(int fi) {
		this.fi = fi;
	}

	@EJB
	Consommation consommation;
	
	public int getNbClients() {
		return nbClients;
	}

	public void setNbClients(int nbClients) {
		this.nbClients = nbClients;
	}

	public int getNbRessources() {
		return nbRessources;
	}

	public void setNbRessources(int nbRessources) {
		this.nbRessources = nbRessources;
	}

	public int getNbApplicants() {
		return nbApplicants;
	}

	public void setNbApplicants(int nbApplicants) {
		this.nbApplicants = nbApplicants;
	}

	

	public int getInprogressprojects() {
		return inprogressprojects;
	}

	public void setInprogressprojects(int inprogressprojects) {
		this.inprogressprojects = inprogressprojects;
	}

	public int getNewprojects() {
		return Newprojects;
	}

	public void setNewprojects(int newprojects) {
		Newprojects = newprojects;
	}

	public int getFinishedprojects() {
		return finishedprojects;
	}

	public void setFinishedprojects(int finishedprojects) {
		this.finishedprojects = finishedprojects;
	}

	public int getNbUsers() {
		return nbUsers;
	}

	public void setNbUsers(int nbUsers) {
		this.nbUsers = nbUsers;
	}

	public List getDash() {
		return dash;
	}

	public void setDash(List list) {
		this.dash = list;
	}

	public List getChart() {
		return chart;
	}

	public void setChart(List chart) {
		this.chart = chart;
	}
	
	@PostConstruct
	public void init(){
		dash=consommation.dash();
		chart=consommation.chart();
		
		nbUsers=consommation.nbUsers();
		nbClients=consommation.nbClients();
		nbRessources=consommation.nbRessources();
		nbApplicants=consommation.nbApplicants();
		
		
		inprogressprojects=consommation.inprogressprojects();
		//Newprojects=consommation.Newprojects();
		finishedprojects=consommation.finishedprojects();
		fi=consommation.Newprojects();
		
	

		NbDays=consommation.NbDays();
		ReturnFeee=consommation.ReturnFeee();
		Cout=consommation.Cout();
		SUMBenefice=consommation.SUMBenefice();
		
		NbToatalRs=consommation.NbToatalRs();
		NbLevioRs=consommation.NbLevioRs();
		
		NumberFreelancers = consommation.NumberFreelancers();
		NumberEmployees = consommation.NumberEmployees();
		
		NumberEmployeesInMandates = consommation.NumberEmployeesInMandates();
		
		getAllProjects = consommation.getAllProject();
		getAllMandates = consommation.getAllMandate();
		
		NBreclamationsCount=consommation.reclamationsCount();
		NBsatisfactionsCount=consommation.satisfactionsCount();
		NoteSatisfactionRate=consommation.SatisfactionRate();

	}

	
	
}
