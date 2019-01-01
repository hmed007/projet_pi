package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import interfaces.RegisterIdentityLocal;
import interfaces.RegisterIdentityRemote;

@Stateful
@LocalBean
public class RegisterService implements RegisterIdentityLocal,RegisterIdentityRemote{

	@Override
	public String Register(String email, String pass, String role) {
		Client client=ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:22033/Account/RegisterJ");
		final Form form = new Form()
	            .param("email", email)
	            .param("pass", pass)
	            .param("role", role);
		Response response=target.request().post(Entity.form(form));
		String res=response.readEntity(String.class);
		response.close();
		return res;
		
	}

}
