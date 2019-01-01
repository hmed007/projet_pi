package tn.esprit.com.ProjetPi.mBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.com.ProjetPi.Utiles.LeaveStat;
import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.entities.Ressource;
import tn.esprit.com.ProjetPi.services.LeaveServiceLocal;
import tn.esprit.com.ProjetPi.services.RessourceServiceLocal;

@ManagedBean(name="StatBean")
@SessionScoped
public class LeaveStatBean {

	@EJB
	LeaveServiceLocal leaveLocal;
	@EJB
	RessourceServiceLocal ressourceLocal;

	private List<LeaveStat> listStat;

	public List<LeaveStat> getListStat() {
			List<LeaveStat> ls = new ArrayList<>();
		List<Leave> listLeave = leaveLocal.findAll();
		List<Ressource> listRessource=listLeave.stream().map(e->e.getRessource()).distinct().collect(Collectors.toList());
		for (Ressource ressource : listRessource) {
			Long sumDays=listLeave.stream().filter(e->e.getRessource().getId() == ressource.getId()).mapToLong(e->e.getD_date().getTime()-e.getStart_date().getTime()).sum();
			Long nombreJour = TimeUnit.DAYS.convert(sumDays, TimeUnit.MILLISECONDS);
			LeaveStat stat = new LeaveStat();
			stat.setRessource(ressource);
			stat.setDayNumber(nombreJour);
			ls.add(stat);
		}
		
		return ls;
	}

	public void setListStat(List<LeaveStat> listStat) {
		this.listStat = listStat;
	}
	
	
}
