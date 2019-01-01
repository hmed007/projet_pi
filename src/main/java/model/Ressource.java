package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Ressource database table.
 * 
 */
@Entity
@NamedQuery(name="Ressource.findAll", query="SELECT r FROM Ressource r")
public class Ressource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Avaibility")
	private int avaibility;

	@Column(name="Contrat_type")
	private String contrat_type;



	@Column(name="First_name")
	private String first_name;

	@Column(name="Last_name")
	private String last_name;

	@Column(name="Note")
	private String note;

	@Column(name="Ressource_type")
	private int ressource_type;

	@Column(name="Salary")
	private float salary;

	@Column(name="Sector")
	private String sector;

	@Column(name="Seniorty")
	private String seniorty;

	@Column(name="Work_profil")
	private String work_profil;

	//bi-directional many-to-one association to ApplicantRessource
	@OneToMany(mappedBy="ressource")
	private List<ApplicantRessource> applicantRessources;

	//bi-directional many-to-one association to Discussion
	@OneToMany(mappedBy="ressource")
	private List<Discussion> discussions;

	//bi-directional many-to-one association to Leave
	@OneToMany(mappedBy="ressource")
	private List<Leave> leaves;

	//bi-directional many-to-one association to Mandate
	@OneToMany(mappedBy="ressource")
	private List<Mandate> mandates;

	//bi-directional many-to-one association to OrganizationChart
	@OneToMany(mappedBy="ressource")
	private List<OrganizationChart> organizationCharts;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="Id")
	private User user;

	//bi-directional many-to-one association to RessourceSkill
	@OneToMany(mappedBy="ressource")
	private List<RessourceSkill> ressourceSkills;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="ressource")
	private List<Skill> skills;

	public Ressource() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvaibility() {
		return this.avaibility;
	}

	public void setAvaibility(int avaibility) {
		this.avaibility = avaibility;
	}

	public String getContrat_type() {
		return this.contrat_type;
	}

	public void setContrat_type(String contrat_type) {
		this.contrat_type = contrat_type;
	}


	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getRessource_type() {
		return this.ressource_type;
	}

	public void setRessource_type(int ressource_type) {
		this.ressource_type = ressource_type;
	}

	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getSeniorty() {
		return this.seniorty;
	}

	public void setSeniorty(String seniorty) {
		this.seniorty = seniorty;
	}

	public String getWork_profil() {
		return this.work_profil;
	}

	public void setWork_profil(String work_profil) {
		this.work_profil = work_profil;
	}

	public List<ApplicantRessource> getApplicantRessources() {
		return this.applicantRessources;
	}

	public void setApplicantRessources(List<ApplicantRessource> applicantRessources) {
		this.applicantRessources = applicantRessources;
	}

	public ApplicantRessource addApplicantRessource(ApplicantRessource applicantRessource) {
		getApplicantRessources().add(applicantRessource);
		applicantRessource.setRessource(this);

		return applicantRessource;
	}

	public ApplicantRessource removeApplicantRessource(ApplicantRessource applicantRessource) {
		getApplicantRessources().remove(applicantRessource);
		applicantRessource.setRessource(null);

		return applicantRessource;
	}

	public List<Discussion> getDiscussions() {
		return this.discussions;
	}

	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}

	public Discussion addDiscussion(Discussion discussion) {
		getDiscussions().add(discussion);
		discussion.setRessource(this);

		return discussion;
	}

	public Discussion removeDiscussion(Discussion discussion) {
		getDiscussions().remove(discussion);
		discussion.setRessource(null);

		return discussion;
	}

	public List<Leave> getLeaves() {
		return this.leaves;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}

	public Leave addLeave(Leave leave) {
		getLeaves().add(leave);
		leave.setRessource(this);

		return leave;
	}

	public Leave removeLeave(Leave leave) {
		getLeaves().remove(leave);
		leave.setRessource(null);

		return leave;
	}

	public List<Mandate> getMandates() {
		return this.mandates;
	}

	public void setMandates(List<Mandate> mandates) {
		this.mandates = mandates;
	}

	public Mandate addMandate(Mandate mandate) {
		getMandates().add(mandate);
		mandate.setRessource(this);

		return mandate;
	}

	public Mandate removeMandate(Mandate mandate) {
		getMandates().remove(mandate);
		mandate.setRessource(null);

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
		organizationChart.setRessource(this);

		return organizationChart;
	}

	public OrganizationChart removeOrganizationChart(OrganizationChart organizationChart) {
		getOrganizationCharts().remove(organizationChart);
		organizationChart.setRessource(null);

		return organizationChart;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<RessourceSkill> getRessourceSkills() {
		return this.ressourceSkills;
	}

	public void setRessourceSkills(List<RessourceSkill> ressourceSkills) {
		this.ressourceSkills = ressourceSkills;
	}

	public RessourceSkill addRessourceSkill(RessourceSkill ressourceSkill) {
		getRessourceSkills().add(ressourceSkill);
		ressourceSkill.setRessource(this);

		return ressourceSkill;
	}

	public RessourceSkill removeRessourceSkill(RessourceSkill ressourceSkill) {
		getRessourceSkills().remove(ressourceSkill);
		ressourceSkill.setRessource(null);

		return ressourceSkill;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setRessource(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setRessource(null);

		return skill;
	}

}