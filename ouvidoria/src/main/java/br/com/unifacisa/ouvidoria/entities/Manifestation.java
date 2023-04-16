package br.com.unifacisa.ouvidoria.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Manifestation {
	
	private String usuario;
	private String type;
	private String text;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(mappedBy = "usuario")
	private List<Manifestation> manifestacoes;

	public Manifestation () {
		
	}
	public Manifestation(String type, String text) {
		super();
		this.type = type;
		this.text = text;
		this.usuario = usuario;
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Manifestation> getManifestacoes() {
		return manifestacoes;
	}

	public void setManifestacoes(List<Manifestation> manifestacoes) {
		this.manifestacoes = manifestacoes;
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

}
