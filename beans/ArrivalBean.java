package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import services.ArrivalService;

@ManagedBean
@SessionScoped
public class ArrivalBean {
	@EJB
	ArrivalService consommation;
	@ManagedProperty(value="#{loginIdentity}")
    private LoginIdentity loginbean;
	private String d;
	public LoginIdentity getLoginbean() {
		return loginbean;
	}
	public void setLoginbean(LoginIdentity loginbean) {
		this.loginbean = loginbean;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public void addArrival() throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf1.parse(d);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
		consommation.AddArrival(sqlStartDate, loginbean.getLoggeduser());
	}
}
