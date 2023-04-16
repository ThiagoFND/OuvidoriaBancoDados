package br.com.unifacisa.ouvidoria.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import br.com.unifacisa.ouvidoria.entities.Alumn;
import br.com.unifacisa.ouvidoria.entities.Employee;
import br.com.unifacisa.ouvidoria.entities.Manifestation;
import br.com.unifacisa.ouvidoria.entities.People;
import br.com.unifacisa.ouvidoria.repositories.ManifestationRepository;
import br.com.unifacisa.ouvidoria.repositories.PeopleRepository;

@Service
public class PeopleServices {

	@Autowired
	PeopleRepository peopleRepositories;

	@Autowired
	ManifestationRepository manifestationRepositories;

	public void peopleADD(String nome, String email, Long numero, String usuario, String password) {
		Alumn userObj = new Alumn(nome, email, numero, usuario, password);
		peopleRepositories.save(userObj);
	}

	public void employeeADD(String nome, String email, Long numero, String usuario, String password, boolean isAdmin) {
		Employee employeeObj = new Employee(nome, email, numero, usuario, password, isAdmin);
		peopleRepositories.save(employeeObj);
	}

	public void addManifestation(String type, String text, People usuario) {
		Manifestation mObj = new Manifestation(type, text, usuario);
		manifestationRepositories.save(mObj);
	}

	public People loginUser(String user, String password) {
		for (People p : peopleRepositories.findAll()) {
			if (p.getUser().equals(user) && p.getPassword().equals(password) && !p.isAdmin()) {
				// Login bem sucedido, retorne true
				return p;
			}
		}
		// If the loop terminated without finding a valid username/password, the login failed,
		// return false
		return null;
	}

	public People loginAdmin(String user, String password) {
		for (People p : peopleRepositories.findAll()) {
			if (p.getUser().equals(user) && p.getPassword().equals(password) && p.isAdmin()) {
				// Login bem sucedido, retorne true
				return p;
			}
		}
		// If the loop terminated without finding a valid username/password, the login failed,
		// return false
		return null;
	}
	
	public void ListManifestation(String type, String text) {
		for (Manifestation list : manifestationRepositories.findAll()) {
			System.out.println("\nID: " + list.getId());
			System.out.println("Type: " + list.getType());
			System.out.println("Text: " + list.getText());
		}
	}
	
	public void removeManifestation(long id) {
		
		for (Manifestation remove : manifestationRepositories.findAll()) {
			manifestationRepositories.deleteById(id);
		}
	}
	

}
