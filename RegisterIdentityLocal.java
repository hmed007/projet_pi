package interfaces;

import javax.ejb.Local;

@Local
public interface RegisterIdentityLocal {
	public String Register(String email,String pass,String role);
}
