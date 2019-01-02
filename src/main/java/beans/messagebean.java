package beans;


import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;

import model.Message;
import services.messageservice;

@ManagedBean
@SessionScoped
public class messagebean {

	private String object;
	private int senderId;
	private Date sentDate;
	private String body;
	private String emailReciever;
	private String bestResource;
	
	
public String getBestResource() {
		return bestResource;
	}
	public void setBestResource(String bestResource) {
		this.bestResource = bestResource;
	}
private Message message ;
private List<Message> listmessage ;
private List<Message> allmessage ;

public List<Message> getListmessage() {
	return listmessage;
}
public List<Message> getalltmessage() {
	return allmessage;
}
public void setListmessage(List<Message> listmessage) {
	this.listmessage = listmessage;
}
@EJB
   messageservice msgservice;
public String getObject() {
	return object;
}
public void setObject(String object) {
	this.object = object;
}
public int getSenderId() {
	return senderId;
}
public void setSenderId(int senderId) {
	this.senderId = senderId;
}
public Date getSentDate() {
	return sentDate;
}
public void setSentDate(Date sentDate) {
	this.sentDate = sentDate;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public String getEmailReciever() {
	return emailReciever;
}
public void setEmailReciever(String emailReciever) {
	this.emailReciever = emailReciever;
}
public Message getMessage() {
	return message;
}
public void setMessage(Message message) {
	this.message = message;
}
public void EnvoyerMessage(){
	Message message= new Message();
	message.setBody(body);
message.setEmailReciever(emailReciever);
	message.setObject(object);
	message.setSenderId(senderId);
	message.setSentDate(sentDate);
	msgservice.EnvoyerMessage(message);
}
@PostConstruct
public void Init(){
	listmessage=msgservice.ListMessage();
	allmessage=msgservice.allMessage();
}
public List<Message> getAllmessage() {
	return allmessage;
}
public void setAllmessage(List<Message> allmessage) {
	this.allmessage = allmessage;
}
public List<Message> filter(){
	
	return this.allmessage=msgservice.filterbyobject(object);
	
}
public void topResrouce(){
	
	this.bestResource=msgservice.topresource();
	System.out.println("BEST RESOURCE "+bestResource);
	
}
}

