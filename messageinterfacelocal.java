package interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import model.Message;
@Remote
public interface messageinterfacelocal {

	public void EnvoyerMessage(Message msg);
	public List<Message> ListMessage();
	public List<Message> allMessage();
	public List<Message> filterbyobject(String filter);
	public String topresource();

}
