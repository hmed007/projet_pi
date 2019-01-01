package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Skills database table.
 * 
 */
@Entity
@Table(name="Skills")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SkillId")
	private int skillId;

	@Column(name="Value")
	private String value;

	//bi-directional many-to-one association to ProjectSkill
	@OneToMany(mappedBy="skill")
	private List<ProjectSkill> projectSkills;

	//bi-directional many-to-one association to RessourceSkill
	@OneToMany(mappedBy="skill")
	private List<RessourceSkill> ressourceSkills;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="Id")
	private Ressource ressource;

	public Skill() {
	}

	public int getSkillId() {
		return this.skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<ProjectSkill> getProjectSkills() {
		return this.projectSkills;
	}

	public void setProjectSkills(List<ProjectSkill> projectSkills) {
		this.projectSkills = projectSkills;
	}

	public ProjectSkill addProjectSkill(ProjectSkill projectSkill) {
		getProjectSkills().add(projectSkill);
		projectSkill.setSkill(this);

		return projectSkill;
	}

	public ProjectSkill removeProjectSkill(ProjectSkill projectSkill) {
		getProjectSkills().remove(projectSkill);
		projectSkill.setSkill(null);

		return projectSkill;
	}

	public List<RessourceSkill> getRessourceSkills() {
		return this.ressourceSkills;
	}

	public void setRessourceSkills(List<RessourceSkill> ressourceSkills) {
		this.ressourceSkills = ressourceSkills;
	}

	public RessourceSkill addRessourceSkill(RessourceSkill ressourceSkill) {
		getRessourceSkills().add(ressourceSkill);
		ressourceSkill.setSkill(this);

		return ressourceSkill;
	}

	public RessourceSkill removeRessourceSkill(RessourceSkill ressourceSkill) {
		getRessourceSkills().remove(ressourceSkill);
		ressourceSkill.setSkill(null);

		return ressourceSkill;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

}