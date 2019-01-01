package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Mandate;
import model.Project;


@Remote
public interface ConsommationRemote {
	public void consommation(String q,String r1,String r2,String r3);
	public List dash();
	public List chart();
	
	public int nbUsers();
	public int nbClients();
	public int nbRessources();
	public int nbApplicants();
	
	public int inprogressprojects();
	public int Newprojects();
	public int finishedprojects();
	
	public int NbDays();
	public float ReturnFeee();
	public float Cout();
	public float SUMBenefice();
	
	public long NbToatalRs();
	public long NbLevioRs();
	public long NumberFreelancers();
	public long NumberEmployees();
	public long NumberEmployeesInMandates();
	
	public List<Project> getAllProject();
	public List<Mandate> getAllMandate();
	
	public float projectEfficiency(int projectId);
	public float mandateEfficiency(int mandateId);
	public long reclamationsCount() ;
	public long satisfactionsCount() ;
	public float SatisfactionRate();


	
}
