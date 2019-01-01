package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import interfaces.LoginIdentityLocal;
import interfaces.LoginIdentityRemote;
import model.Applicant;
import model.User;

@Stateful
@LocalBean
public class IdentityLogin implements LoginIdentityLocal,LoginIdentityRemote{
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;
	
	
	@Override
	public String LoginIdentity(String email, String pass) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Account/LoginJ");
		final Form form = new Form()
	            .param("email", email)
	            .param("pass", pass);
		Response response=target.request().post(Entity.form(form));
		String res=response.readEntity(String.class);
		response.close();
		return res;
	}
	@Override
	public int LoggedUser(String email) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Account/GetUserJ");
		final Form form = new Form()
	            .param("email", email);
		Response response=target.request().post(Entity.form(form));
		int res=response.readEntity(int.class);
		//res.setId(response.readEntity(int.class));
		return res;
	}
	@Override
	public int LoggedUser() {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Account/GetLoggedUser");
		Response response=target.request().get();
		int res=response.readEntity(int.class);
			  return res;
	}
	

}
