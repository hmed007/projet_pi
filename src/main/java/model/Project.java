package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the Projects database table.
 * 
 */
@Entity
@Table(name="Projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProjectId")
	private int projectId;

	@Column(name="Adress")
	private String adress;

	@Column(name="end_date")
	private Date endDate;

	@Column(name="Levio_number_ressource")
	private int levio_number_ressource;

	@Column(name="Project_name")
	private String project_name;

	@Column(name="project_state")
	private int projectState;

	@Column(name="Start_date")
	private Date start_date;
	
	@Column(name="ActualEndDate")
	private Date actualEndDate;

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	@Column(name="Total_number_ressource")
	private int total_number_ressource;

	//bi-directional many-to-one association to Mandate
	@OneToMany(mappedBy="project")
	private List<Mandate> mandates;

	//bi-directional many-to-one association to OrganizationChart
	@OneToMany(mappedBy="project")
	private List<OrganizationChart> organizationCharts;

	//bi-directional many-to-one association to ProjectSkill
	@OneToMany(mappedBy="project")
	private List<ProjectSkill> projectSkills;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ClientId")
	private Client client;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getLevio_number_ressource() {
		return this.levio_number_ressource;
	}

	public void setLevio_number_ressource(int levio_number_ressource) {
		this.levio_number_ressource = levio_number_ressource;
	}

	public String getProject_name() {
		return this.project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public int getProjectState() {
		return this.projectState;
	}

	public void setProjectState(int projectState) {
		this.projectState = projectState;
	}

	public Date getStart_date() {
		return this.start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public int getTotal_number_ressource() {
		return this.total_number_ressource;
	}

	public void setTotal_number_ressource(int total_number_ressource) {
		this.total_number_ressource = total_number_ressource;
	}

	public List<Mandate> getMandates() {
		return this.mandates;
	}

	public void setMandates(List<Mandate> mandates) {
		this.mandates = mandates;
	}

	public Mandate addMandate(Mandate mandate) {
		getMandates().add(mandate);
		mandate.setProject(this);

		return mandate;
	}

	public Mandate removeMandate(Mandate mandate) {
		getMandates().remove(mandate);
		mandate.setProject(null);

		return mandate;
	}

	public List<OrganizationChart> getOrganizationCharts() {
		return this.organizationCharts;
	}

	public void setOrganizationCharts(List<OrganizationChart> organizationCharts) {
		this.organizationCharts = organizationCharts;
	}

	public OrganizationChart addOrganizationChart(OrganizationChart organizationChart) {
		getOrganizationCharts().add(organizationChart);
		organizationChart.setProject(this);

		return organizationChart;
	}

	public OrganizationChart removeOrganizationChart(OrganizationChart organizationChart) {
		getOrganizationCharts().remove(organizationChart);
		organizationChart.setProject(null);

		return organizationChart;
	}

	public List<ProjectSkill> getProjectSkills() {
		return this.projectSkills;
	}

	public void setProjectSkills(List<ProjectSkill> projectSkills) {
		this.projectSkills = projectSkills;
	}

	public ProjectSkill addProjectSkill(ProjectSkill projectSkill) {
		getProjectSkills().add(projectSkill);
		projectSkill.setProject(this);

		return projectSkill;
	}

	public ProjectSkill removeProjectSkill(ProjectSkill projectSkill) {
		getProjectSkills().remove(projectSkill);
		projectSkill.setProject(null);

		return projectSkill;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}