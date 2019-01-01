package tn.esprit.com.ProjetPi.mBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONObject;

import tn.esprit.com.ProjetPi.Utiles.Utiles;
import tn.esprit.com.ProjetPi.entities.Leave;
import tn.esprit.com.ProjetPi.entities.Ressource;
import tn.esprit.com.ProjetPi.entities.TypeLeave;
import tn.esprit.com.ProjetPi.services.LeaveServiceLocal;
import tn.esprit.com.ProjetPi.services.RessourceServiceLocal;

@ManagedBean(name="LeaveBean")
@SessionScoped
public class AjoutLeaveBean {
@EJB
LeaveServiceLocal leaveLocal;
@EJB
RessourceServiceLocal ressourceLocal;
private Date  dateDebut;
private Date  dateFin;
private int typeLeave;
private List<Ressource> listAll;
private Ressource ressourceChoisi;
private int ressourceId;
private List<Leave> listLeave;
private List<TypeLeave> listType;

public List<TypeLeave> getListType() {
	listType.add(TypeLeave.Disease);
	listType.add(TypeLeave.Maternity);
	listType.add(TypeLeave.Vacation);
	return listType;
}
public void setListType(List<TypeLeave> listType) {
	this.listType = listType;
}
public List<Ressource> getListAll() {
	Client client=ClientBuilder.newClient();
	WebTarget target= client.target("http://localhost:22033/Home/NewRessourcej");
	Response response=target.request().get();	
	
	List<Ressource>listRessource = new ArrayList<Ressource>();
	String res=response.readEntity(String.class);
	System.out.println("AAAAAAAAAAAAAAAAAAAA show me " + res);
	res = res.replace("[", "");
	res = res.replace("]", "");
	ArrayList<String> listStr = new ArrayList<>();
	
	for (String string : res.split(",")) {
		System.out.println("first string" + string.length());
		string = string.replace("{", "").replace("}", "");
		String[] test = string.split(":");
		for (String str : test){
			if(str.contains("First_name")||str.contains("Id")){
				
			}else{
				listStr.add(str.replace("\"", "").replace(" ",""));
			}
		}
	}
	for(int i=0;i<(listStr.size());i=i+2){
		Ressource ress = new Ressource();
		ress.setId(Integer.parseInt(listStr.get(i)));
		ress.setFirst_name(listStr.get(i+1));
		listRessource.add(ress);
	}


	return listRessource;
}
public void setListAll(List<Ressource> listAll) {
	this.listAll = listAll;
}
public Ressource getRessourceChoisi() {
	return ressourceChoisi;
}
public void setRessourceChoisi(Ressource ressourceChoisi) {
	this.ressourceChoisi = ressourceChoisi;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public java.util.Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public int getTypeLeave() {
	return typeLeave;
}
public void setTypeLeave(int typeLeave) {
	this.typeLeave = typeLeave;
}


public String ajouterLeave() throws ParseException{
	Ressource res = new Ressource();
	res.setId(ressourceId);
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
	
	leaveLocal.save(new Leave(dateDebut, dateFin, typel, res));
	return null;
}

public String supprimer(int id){
	leaveLocal.delete(leaveLocal.find(id));
	return "";
}

public String modify(int id){
	Utiles.id=id;
	return "/ModifyLeave?faces-redirect=true";
}


public int getRessourceId() {
	return ressourceId;
}
public void setRessourceId(int ressourceId) {
	this.ressourceId = ressourceId;
}
public List<Leave> getListLeave() {
	
	return leaveLocal.findAll();
}
public void setListLeave(List<Leave> listLeave) {
	this.listLeave = listLeave;
}
}
