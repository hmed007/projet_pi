package interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Ressource;

@Remote
public interface RessourceRemote {
	public List<Ressource> RessourceList();
}
