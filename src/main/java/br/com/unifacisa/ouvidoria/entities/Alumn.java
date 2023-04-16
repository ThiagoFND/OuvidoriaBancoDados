package br.com.unifacisa.ouvidoria.entities;

import jakarta.persistence.Entity;

@Entity
public class Alumn extends People{

	public Alumn() {
		
	}
	
	public Alumn(String name, String email, Long number, String user, String password) {
		super(name, email, number, user, password, false);
	}
}
