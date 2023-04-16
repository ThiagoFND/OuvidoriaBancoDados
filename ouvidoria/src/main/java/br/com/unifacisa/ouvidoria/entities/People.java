package br.com.unifacisa.ouvidoria.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class People {
	
	private String nome;
	private String email;
	private Long numero;
	private String usuario;
	private String senha;
	private boolean admin;
	private String type;
	private String text;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public People() {

	}

	public People(String nome, String email, Long numero, String usuario, String senha, boolean isAdmin) {
	    super();
	    this.nome = nome;
	    this.email = email;
	    this.numero = numero;
	    this.usuario = usuario;
	    this.senha = senha;
	    this.admin = isAdmin;
	    this.type = "";
        this.text = "";
	    this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = true;
	}
	
	public boolean getAdmin() {
		return admin;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
