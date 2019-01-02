package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.messageservice;

@ManagedBean
@SessionScoped
public class statmsgbean {
	@EJB
	messageservice ms;
	
	private long nbr1;
	private long nbs1;
	private long nbr2;
	private long nbs2;
	private long nbr3;
	private long nbs3;
	private long nbr4;
	private long nbs4;
	
	public long getNbr1() {
		return nbr1;
	}
	public void setNbr1(long nbr1) {
		this.nbr1 = nbr1;
	}
	public long getNbs1() {
		return nbs1;
	}
	public void setNbs1(long nbs1) {
		this.nbs1 = nbs1;
	}
	public long getNbr2() {
		return nbr2;
	}
	public void setNbr2(long nbr2) {
		this.nbr2 = nbr2;
	}
	public long getNbs2() {
		return nbs2;
	}
	public void setNbs2(long nbs2) {
		this.nbs2 = nbs2;
	}
	public long getNbr3() {
		return nbr3;
	}
	public void setNbr3(long nbr3) {
		this.nbr3 = nbr3;
	}
	public long getNbs3() {
		return nbs3;
	}
	public void setNbs3(long nbs3) {
		this.nbs3 = nbs3;
	}
	public long getNbr4() {
		return nbr4;
	}
	public void setNbr4(long nbr4) {
		this.nbr4 = nbr4;
	}
	public long getNbs4() {
		return nbs4;
	}
	public void setNbs4(long nbs4) {
		this.nbs4 = nbs4;
	}
	
	public statmsgbean() {
		super();
	}
	@PostConstruct
	public void init(){
		nbr1=ms.Countreclamation1();
		nbs1=ms.Countsatisfaction1();
		
		nbr2=ms.Countreclamation2();
		nbs2=ms.Countsatisfaction2();
		
		nbr3=ms.Countreclamation3();
		nbs3=ms.Countsatisfaction3();
		
		nbr4=ms.Countreclamation4();
		nbs4=ms.Countsatisfaction4();
	}
	
	
}
