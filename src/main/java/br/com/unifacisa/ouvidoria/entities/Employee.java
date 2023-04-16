package br.com.unifacisa.ouvidoria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Employee extends People {

	public Employee() {

	}

	public Employee(String name, String email, Long number, String user, String password, boolean isAdmin) {
		super(name, email, number, user, password, true);
		this.setAdmin(true);
	}

}
