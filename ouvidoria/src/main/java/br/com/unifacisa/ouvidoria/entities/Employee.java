package br.com.unifacisa.ouvidoria.entities;

public class Employee extends People {

	public Employee(String nome, String email, Long numero, String usuario, String senha) {
		super(nome, email, numero, usuario, senha, true);
		this.setAdmin(true);
	}
}
