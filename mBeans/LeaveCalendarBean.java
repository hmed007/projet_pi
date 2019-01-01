package tn.esprit.com.ProjetPi.mBeans;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import tn.esprit.com.ProjetPi.Utiles.Utiles;
import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.services.LeaveServiceLocal;
import tn.esprit.com.ProjetPi.services.RessourceServiceLocal;

@ManagedBean(name="CalendarBean")
@SessionScoped
public class LeaveCalendarBean {

	@EJB
	LeaveServiceLocal leaveLocal;
	@EJB
	RessourceServiceLocal ressourceLocal;

	private List<Leave> listLeave;
	
	private Date date;

	public List<Leave> getListLeave() {
		return leaveLocal.findAll().stream().filter(e->(Utiles.date.before(e.getD_date())&&Utiles.date.after(e.getStart_date()))).collect(Collectors.toList());
	}

	public void setListLeave(List<Leave> listLeave) {
		this.listLeave = listLeave;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		Utiles.date = date;
		this.date = date;
	}

	public String Update(){
		this.setListLeave(leaveLocal.findAll().stream().filter(e->(Utiles.date.before(e.getD_date())&&Utiles.date.after(e.getStart_date()))).collect(Collectors.toList()));
		return "";
	}
}
