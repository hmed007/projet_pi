package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String adresse;

	@Column(name="categorie_c")
	private short categorieC;

	private String nameClient;

	@Column(name="NbrRessource")
	private int nbrRessource;

	@Column(name="type_c")
	private int typeC;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="Id")
	private User user;

	//bi-directional many-to-one association to Discussion
	@OneToMany(mappedBy="client")
	private List<Discussion> discussions;

	//bi-directional many-to-one association to OrganizationChart
	@OneToMany(mappedBy="client")
	private List<OrganizationChart> organizationCharts;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="client")
	private List<Project> projects;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="client")
	private List<Request> requests;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public short getCategorieC() {
		return this.categorieC;
	}

	public void setCategorieC(short categorieC) {
		this.categorieC = categorieC;
	}

	public String getNameClient() {
		return this.nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public int getNbrRessource() {
		return this.nbrRessource;
	}

	public void setNbrRessource(int nbrRessource) {
		this.nbrRessource = nbrRessource;
	}

	public int getTypeC() {
		return this.typeC;
	}

	public void setTypeC(int typeC) {
		this.typeC = typeC;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Discussion> getDiscussions() {
		return this.discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public Discussion addDiscussion(Discussion discussion) {
		getDiscussions().add(discussion);
		discussion.setClient(this);

		return discussion;
	}

	public Discussion removeDiscussion(Discussion discussion) {
		getDiscussions().remove(discussion);
		discussion.setClient(null);

		return discussion;
	}

	public List<OrganizationChart> getOrganizationCharts() {
		return this.organizationCharts;
	}

	public void setOrganizationCharts(List<OrganizationChart> organizationCharts) {
		this.organizationCharts = organizationCharts;
	}

	public OrganizationChart addOrganizationChart(OrganizationChart organizationChart) {
		getOrganizationCharts().add(organizationChart);
		organizationChart.setClient(this);

		return organizationChart;
	}

	public OrganizationChart removeOrganizationChart(OrganizationChart organizationChart) {
		getOrganizationCharts().remove(organizationChart);
		organizationChart.setClient(null);

		return organizationChart;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setClient(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setClient(null);

		return project;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setClient(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setClient(null);

		return request;
	}

}