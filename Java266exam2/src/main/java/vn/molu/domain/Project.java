package vn.molu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "department_id")
	private long iddepartment;

	public Project() {
	}

	public Project(long id, String name, long iddepartment) {
		super();
		this.id = id;
		this.name = name;
		this.iddepartment = iddepartment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(long iddepartment) {
		this.iddepartment = iddepartment;
	}

}
