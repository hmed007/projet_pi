package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Ressource;
import services.RessourceService;

@ManagedBean
@SessionScoped
public class RessourceBean {
	@EJB
	RessourceService consommation;
	

	private List<Ressource> ressources;
	private int selectedid;
	
	public int getSelectedid() {
		return selectedid;
	}
	public void setSelectedid(int selectedid) {
		this.selectedid = selectedid;
	}
	public List<Ressource> getRessources() {
		return ressources;
	}
	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}
	@PostConstruct
	public void init(){
		ressources=consommation.RessourceList();
	}
	
}
