package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.ApplicantService;
import services.StatService;

@ManagedBean
@SessionScoped
public class StatBean {

	
	@EJB
	StatService ss;
	
	private long APPType1;

	private long APPType2;


	private long APPType3;


	private long APPType4;



	public long getAPPType2() {
		return APPType2;
	}

	public void setAPPType2(long aPPType2) {
		APPType2 = aPPType2;
	}

	public long getAPPType3() {
		return APPType3;
	}

	public void setAPPType3(long aPPType3) {
		APPType3 = aPPType3;
	}

	public long getAPPType4() {
		return APPType4;
	}

	public void setAPPType4(long aPPType4) {
		APPType4 = aPPType4;
	}

	public long getAPPType1() {
		return APPType1;
	}

	public void setAPPType1(long aPPType1) {
		APPType1 = aPPType1;
	}
	
	
	@PostConstruct
	public void init(){
		APPType1=ss.NumberApplicantState();
		APPType2=ss.NumberApplicantState1();
		APPType3=ss.NumberApplicantState2();
		APPType4=ss.NumberApplicantState3();
		
	}
}
