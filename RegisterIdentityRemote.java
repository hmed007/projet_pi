package interfaces;

import javax.ejb.Remote;

@Remote
public interface RegisterIdentityRemote {
	public String Register(String email,String pass,String role);

}
