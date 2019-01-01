package tn.esprit.com.ProjetPi.mBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.com.ProjetPi.Utiles.Utiles;
import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.entities.TypeLeave;
import tn.esprit.com.ProjetPi.services.LeaveServiceLocal;
import tn.esprit.com.ProjetPi.services.RessourceServiceLocal;

@ManagedBean(name="LeaveBean1")
@SessionScoped
public class ModifyLeaveBean {
	@EJB
	LeaveServiceLocal leaveLocal;
	@EJB
	RessourceServiceLocal ressourceLocal;
	
	private Leave leave;
	private List<TypeLeave> listType;
	private int typeLeave;

	private Date dayte_deb;
	private Date dateFin;
	

public List<TypeLeave> getListType() {
	listType.add(TypeLeave.Disease);
	listType.add(TypeLeave.Maternity);
	listType.add(TypeLeave.Vacation);
	return listType;
}
public void setListType(List<TypeLeave> listType) {
	this.listType = listType;
}
	public Leave getLeave() {
		return leaveLocal.find(Utiles.id);
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}
	public int getTypeLeave() {
		return typeLeave;
	}
	public void setTypeLeave(int typeLeave) {
		this.typeLeave = typeLeave;
	}
	
	public String modify(){
		Leave leave = leaveLocal.find(Utiles.id);
		TypeLeave typel= TypeLeave.Autre;
		if (typeLeave == 0){
			typel = TypeLeave.Maternity;	
		}
		if (typeLeave == 1){
			typel = TypeLeave.Vacation;	
		}
		if (typeLeave == 2){
			typel = TypeLeave.Disease;	
		}
		if (typeLeave == 3){
			typel = TypeLeave.Autre;	
		}
		leave.setType_leave(typel);
		leave.setStart_date(dayte_deb);
		leave.setD_date(dateFin);
		leaveLocal.update(leave);
		return "";
	}
	public Date getDayte_deb() {
		return leaveLocal.find(Utiles.id).getStart_date();
	}
	public void setDayte_deb(Date dayte_deb) {
		this.dayte_deb = dayte_deb;
	}
	public Date getDateFin() {
		return leaveLocal.find(Utiles.id).getD_date();
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
}
