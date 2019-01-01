package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the Messages database table.
 * 
 */
@Entity
@Table(name="Messages")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MessageId")
	private int messageId;

	@Column(name="Object")
	private String object;

	@Column(name="SenderId")
	private int senderId;

	@Column(name="SentDate")
	private Date sentDate;

	@Column(name="Body")
	private String Body;


	@Column(name="EmailReciever")
	private String EmailReciever;
	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public String getEmailReciever() {
		return EmailReciever;
	}

	public void setEmailReciever(String emailReciever) {
		EmailReciever = emailReciever;
	}

	//bi-directional many-to-one association to Discussion
	@ManyToOne
	@JoinColumn(name="Discussion_DiscId")
	private Discussion discussion;

	public Message() {
	}

	public int getMessageId() {
		return this.messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getObject() {
		return this.object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public int getSenderId() {
		return this.senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public Date getSentDate() {
		return this.sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public Discussion getDiscussion() {
		return this.discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

}