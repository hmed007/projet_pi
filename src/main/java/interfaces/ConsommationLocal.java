package interfaces;

import java.util.List;

import javax.ejb.Local;

import model.Mandate;
import model.Message;
import model.Project;

@Local
public interface ConsommationLocal {
	public void consommation(String q,String r1,String r2,String r3);
	public List dash();
	public List chart();
	
	
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
