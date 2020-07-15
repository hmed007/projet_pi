package interfaces;

import java.util.List;

import javax.ejb.Local;

import model.Ressource;


@Local
public interface RessourceLocal {
	public List<Ressource> RessourceList();
}
