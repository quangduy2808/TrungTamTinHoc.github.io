package vn.molu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "fullname")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "department_id")
	private long iddepartment;

	public Employee() {
	}

	public Employee(long id, String name, String email, String phone, long iddepartment) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.iddepartment = iddepartment;
	}

	public long getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(long iddepartment) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
