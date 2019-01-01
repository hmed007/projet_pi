package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ProjectSkills database table.
 * 
 */
@Entity
@Table(name="ProjectSkills")
@NamedQuery(name="ProjectSkill.findAll", query="SELECT p FROM ProjectSkill p")
public class ProjectSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProjectSkillId")
	private int projectSkillId;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="Project_ProjectId")
	private Project project;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="Skill_SkillId")
	private Skill skill;

	public ProjectSkill() {
	}

	public int getProjectSkillId() {
		return this.projectSkillId;
	}

	public void setProjectSkillId(int projectSkillId) {
		this.projectSkillId = projectSkillId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}