package br.com.unifacisa.ouvidoria.entities;

public class User extends People{

	public User(String nome, String email, Long numero, String usuario, String senha) {
		super(nome, email, numero, usuario, senha, false);
	}
}
