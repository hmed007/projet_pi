package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import interfaces.MailLocal;
import interfaces.MailRemote;
import model.Applicant;
@Stateful
@LocalBean
public class MailService implements MailRemote,MailLocal{
	
	@PersistenceContext(unitName="projetpi1-ejb") 
	EntityManager em;
	public void envoyerEmail(String username,String mail) {
		try {
			
			String from = "levio.lmp@gmail.com";
			String pass = "eudfdldhubmzuscf";
			String to ="oussema_hmaidi@live.fr";
			String subject = "Demande de travail";
			String messageText = "message";
			String host = "smtp.gmail.com";
			boolean sessionDebug = false;
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("message send successfully");
		} catch (Exception ex)
		{
			System.out.println(ex);

		}
	}
	
	public List<Applicant> PreEmployed() {
		int state=1;
		Query query = em.createQuery("SELECT a from Applicant a where a.applicantState=:state");
		query.setParameter("state", state);
		List<Applicant> app=query.getResultList();
		return app;
	}
}
