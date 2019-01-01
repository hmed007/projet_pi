package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Discussions database table.
 * 
 */
@Entity
@Table(name="Discussions")
@NamedQuery(name="Discussion.findAll", query="SELECT d FROM Discussion d")
public class Discussion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DiscId")
	private int discId;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="clientId")
	private Client client;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="ressourceId")
	private Ressource ressource;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="discussion")
	private List<Message> messages;

	public Discussion() {
	}

	public int getDiscId() {
		return this.discId;
	}

	public void setDiscId(int discId) {
		this.discId = discId;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setDiscussion(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setDiscussion(null);

		return message;
	}

}