package br.com.unifacisa.ouvidoria.entities;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public class People {

	private String name;
	private String email;
	private Long number;
	private String user;
	private String password;
	private boolean isAdmin;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public People() {

	}

	public People(String name, String email, Long number, String user, String password, boolean isAdmin) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.user = user;
		this.password = password;
		this.isAdmin = isAdmin;
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
