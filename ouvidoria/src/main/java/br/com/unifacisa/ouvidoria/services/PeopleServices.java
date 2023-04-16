package br.com.unifacisa.ouvidoria.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.ouvidoria.entities.Manifestation;
import br.com.unifacisa.ouvidoria.entities.People;
import br.com.unifacisa.ouvidoria.repositories.PeopleRepository;

@Service
public class PeopleServices {

	@Autowired
	PeopleRepository peopleRepositories;

	public void peopleADD(String nome, String email, Long numero, String usuario, String senha) {
		People userObj = new People(nome, email, numero, usuario, senha, false);
		peopleRepositories.save(userObj);
	}

	public void employeeADD(String nome, String email, Long numero, String usuario, String senha, boolean isAdmin) {
		People employeeObj = new People(nome, email, numero, usuario, senha, isAdmin);
		peopleRepositories.save(employeeObj);
	}

	public boolean loginUser(String usuario, String senha) {
		for (People p : peopleRepositories.findAll()) {
			if (p.getUsuario().equals(usuario) && p.getSenha().equals(senha)) {
				// Login bem sucedido, retorne true
				return true;
			}
		}
		// Se o loop terminou sem encontrar um usuário/senha válido, o login falhou,
		// retorne false
		return false;
	}

	public boolean loginEmployee(String usuario, String senha) {
		for (People p : peopleRepositories.findAll()) {
			if (p.getUsuario().equals(usuario) && p.getSenha().equals(senha) && p.getAdmin()) {
				// Login bem sucedido, retorne true
				return true;
			}
		}
		// Se o loop terminou sem encontrar um usuário/senha válido, o login falhou,
		// retorne false
		return false;
	}
}
