package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OrganizationCharts database table.
 * 
 */
@Entity
@Table(name="OrganizationCharts")
@NamedQuery(name="OrganizationChart.findAll", query="SELECT o FROM OrganizationChart o")
public class OrganizationChart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="directional_level")
	private String directionalLevel;

	@Column(name="account_manager")
	private String accountManager;

	@Column(name="client_name")
	private String clientName;

	@Column(name="name_assignement_manager_client")
	private String nameAssignementManagerClient;

	@Column(name="program_name")
	private String programName;

	@Column(name="project_responsable")
	private String projectResponsable;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="Client_Id")
	private Client client;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="Project_ProjectId")
	private Project project;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="Ressource_Id")
	private Ressource ressource;

	public OrganizationChart() {
	}

	public String getDirectionalLevel() {
		return this.directionalLevel;
	}

	public void setDirectionalLevel(String directionalLevel) {
		this.directionalLevel = directionalLevel;
	}

	public String getAccountManager() {
		return this.accountManager;
	}

	public void setAccountManager(String accountManager) {
		this.accountManager = accountManager;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getNameAssignementManagerClient() {
		return this.nameAssignementManagerClient;
	}

	public void setNameAssignementManagerClient(String nameAssignementManagerClient) {
		this.nameAssignementManagerClient = nameAssignementManagerClient;
	}

	public String getProgramName() {
		return this.programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProjectResponsable() {
		return this.projectResponsable;
	}

	public void setProjectResponsable(String projectResponsable) {
		this.projectResponsable = projectResponsable;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

}