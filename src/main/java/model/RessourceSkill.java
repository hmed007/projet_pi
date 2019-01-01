package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RessourceSkills database table.
 * 
 */
@Entity
@Table(name="RessourceSkills")
@NamedQuery(name="RessourceSkill.findAll", query="SELECT r FROM RessourceSkill r")
public class RessourceSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int RSId;

	//bi-directional many-to-one association to Ressource
	@ManyToOne
	@JoinColumn(name="Ressource_Id")
	private Ressource ressource;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="Skill_SkillId")
	private Skill skill;

	public RessourceSkill() {
	}

	public int getRSId() {
		return this.RSId;
	}

	public void setRSId(int RSId) {
		this.RSId = RSId;
	}

	public Ressource getRessource() {
		return this.ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}