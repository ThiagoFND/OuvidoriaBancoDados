package br.com.unifacisa.ouvidoria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*
 * this manifestation class contains two main attributes for the manifestations, 
 * the text and the type, as well as the id of the manifestation and the id of the user it belongs to
 */
@Entity
public class Manifestation {

	@ManyToOne
	@JoinColumn(nullable = false)
	private People user;
	private String type;
	private String text;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Manifestation() {

	}

	public Manifestation(String type, String text, People user) {
		super();
		this.type = type;
		this.text = text;
		this.user = user;
	}
	
	

	public People getUser() {
		return user;
	}

	public void setUser(People user) {
		this.user = user;
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
