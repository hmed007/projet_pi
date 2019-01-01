package services;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import interfaces.ConsommationLocal;
import interfaces.ConsommationRemote;
import model.Leave;
import model.Mandate;
import model.Message;
import model.Project;

@Stateful
@LocalBean
public class Consommation implements ConsommationLocal,ConsommationRemote{
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;

	@Override
	public void consommation(String q,String r1,String r2,String r3) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/AddFrenshQuestionJ");
		final Form form = new Form()
	            .param("ques", q)
	            .param("rep1", r1)
	            .param("rep2", r2)
	            .param("rep3", r3);
		Response response=target.request().post(Entity.form(form));
		String res=response.readEntity(String.class);
		System.out.println(res);
		response.close();
	}
	@Override
	public List dash() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/DashJ");
		Response response=target.request().get();
		List res=response.readEntity(List.class);
			  return res;
		// TODO Auto-generated method stub
	
	}

	@Override
	public List chart() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Home/chartJ");
		Response response=target.request().get();
		List res=response.readEntity(List.class);
			  return res;
		// TODO Auto-generated method stub
	}
	
	@Override
	public int nbUsers() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/nbUsers");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}

	@Override
	public int nbClients() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/nbClients");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}
	@Override
	public int nbRessources() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/nbRessources");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}
	@Override
	public int nbApplicants() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/nbApplicants");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}

	@Override
	public int inprogressprojects() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/inprogressprojects");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}
	
	@Override
	public int Newprojects() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/newprojects");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}
	@Override
	public int finishedprojects() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/finishedprojects");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}
	
	@Override
	public int NbDays() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/NbDays");
		Response response=target.request().get();
		Integer res=response.readEntity(Integer.class);
			  return res;
		// TODO Auto-generated method stub
	}
	
	@Override
	public float ReturnFeee() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/ReturnFeee");
		Response response=target.request().get();
		float res=response.readEntity(float.class);
			  return res;
		// TODO Auto-generated method stub
	}
	@Override
	public float Cout() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/Cout");
		Response response=target.request().get();
		float res=response.readEntity(float.class);
			  return res;
		// TODO Auto-generated method stub
	}
	
	@Override
	public float SUMBenefice() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Api/stat/SUMBenefice");
		Response response=target.request().get();
		float res=response.readEntity(float.class);
			  return res;
		// TODO Auto-generated method stub
	}
	
	
	
	@Override
	public long NbToatalRs() {//ok
		String sql = "SELECT SUM(p.total_number_ressource) FROM Project p";
		Query q = em.createQuery(sql);
		long ss=(long) q.getSingleResult();
		return ss;
	}
	
	@Override
	public long NbLevioRs() {//ok
		String sql = "SELECT SUM(p.levio_number_ressource) FROM Project p";
		Query q = em.createQuery(sql);
		long ss=(long) q.getSingleResult();
		return ss;
	}
	
	@Override
	public long reclamationsCount() {
		String sql = "Select COUNT(m.id) from Message m where m.object='Reclamation' ";
		Query q = em.createQuery(sql);
		long count =(long) q.getSingleResult();
		return count;
	}
	
	
	@Override
	public long satisfactionsCount() {
			String sql = "Select count(m.id) from Message m where m.object='Satisfaction'";
			Query q = em.createQuery(sql);
			long count =(long) q.getSingleResult();
		return count;
	}
	
	
	
	@Override
	public float SatisfactionRate() {
		Long reclamation = reclamationsCount();
		Long satisfaction = satisfactionsCount();
		return (satisfaction/(satisfaction+reclamation))*100;
	}
	
	
	@Override
	public long NumberFreelancers() {//ok
		String sql = "SELECT COUNT(r.id) FROM Ressource r WHERE r.ressource_type= 1";
		Query q = em.createQuery(sql);
		Long count =(Long) q.getSingleResult();
		return count;
	}
	
	@Override
	public long NumberEmployees() {//ok
		String sql = "SELECT COUNT(r.id) FROM Ressource r WHERE r.ressource_type= 0";
		Query q = em.createQuery(sql);
		Long count =(Long) q.getSingleResult();
		return count;
	}
	
	
	/* *************************************************** */
	
	@Override
	public long NumberEmployeesInMandates() {//ok
		Long leavescounter=new Long(0);
		Date d=new Date();
		String sql = "SELECT COUNT(r.id) FROM Ressource r WHERE r.avaibility=0 or r.avaibility=1";
		Query q = em.createQuery(sql);
		Long count =(Long) q.getSingleResult();
		String sql2 ="Select r.leaves from Ressource r WHERE r.avaibility=1";
		Query q2 = em.createQuery(sql2);
		List<Leave> leaves  =(List<Leave>) q2.getResultList();
		for (Leave l : leaves){
			if (d.after(l.getStart_date()) && d.before(l.getD_date())){
				leavescounter++;
			}
		}
		return count-leavescounter;
	}
	
	/* *********************************************************** */
	

	/*
	@Override
	public Long NumberEmployeesAdministration() {
		String sql = "SELECT COUNT(r.id) FROM Ressource r WHERE r.role='ROLE_ADMIN_AGENT'";
		Query q = em.createQuery(sql);
		Long count =(Long) q.getSingleResult();
		return count;
	}
	*/
	

	
	
	
	public List<Project> getAllProject() {
		Query query = em.createQuery("select p from Project p ");
		return query.getResultList();
	}
	
	
	public List<Mandate> getAllMandate() {
		Query query = em.createQuery("select m from Mandate m ");
		return query.getResultList();
	}
	
	
	
	public float projectEfficiency(int projectId) {
		float sum=0;
		int i=0;
		Project p = em.find(Project.class,projectId);
		for (Mandate m : p.getMandates()) {
			long optimumDuration=(m.getEndDate().getTime()-m.getStart_date	().getTime());
			long nombreJour1 = TimeUnit.DAYS.convert(optimumDuration, TimeUnit.MILLISECONDS);
			//System.out.println("*****************************"+nombreJour1);
			long actualDuration=(m.getActualEndDate().getTime()-m.getStart_date().getTime());
			long nombreJour2 = TimeUnit.DAYS.convert(actualDuration, TimeUnit.MILLISECONDS);
			//System.out.println("*****************************"+nombreJour2);
			sum+=(nombreJour2-nombreJour1);
			//System.out.println("//////////////////"+sum);
			i++;
		}
		return sum/i;
	}
	
	@Override
	public float mandateEfficiency(int mandateId) {
		Mandate m=em.find(Mandate.class, mandateId);
		float optimumDuration=(m.getEndDate().getTime()-m.getStart_date().getTime())/ (24 * 60 * 60 * 1000);
		float actualDuration=(m.getActualEndDate().getTime()-m.getStart_date().getTime())/ (24 * 60 * 60 * 1000);
		return (optimumDuration/actualDuration)*100;
		
	}
	
	
}
