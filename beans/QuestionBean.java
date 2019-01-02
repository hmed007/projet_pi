package beans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import services.Consommation;

@ManagedBean
@SessionScoped
public class QuestionBean {
	private String q;
	private String r1;
	private String r2;
	private String r3;
	@EJB
	Consommation consommation;
	
	@PostConstruct
	public void init(){
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public String getR3() {
		return r3;
	}

	public void setR3(String r3) {
		this.r3 = r3;
	}

	public void ajoutQuestion(){
		consommation.consommation(q, r1, r2, r3);
	}
	public void ajoutQuestionTechnique(){
		consommation.consommationTechnique(q, r1, r2, r3);
	}
}
