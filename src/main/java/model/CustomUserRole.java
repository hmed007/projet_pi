package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CustomUserRoles database table.
 * 
 */
@Entity
@Table(name="CustomUserRoles")
@NamedQuery(name="CustomUserRole.findAll", query="SELECT c FROM CustomUserRole c")
public class CustomUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="RoleId")
	private int roleId;

	@Column(name="UserId")
	private int userId;

	//bi-directional many-to-one association to CustomRole
	@ManyToOne
	@JoinColumn(name="CustomRole_Id")
	private CustomRole customRole;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="customUserRoles")
	private List<User> users;

	public CustomUserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public CustomRole getCustomRole() {
		return this.customRole;
	}

	public void setCustomRole(CustomRole customRole) {
		this.customRole = customRole;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}