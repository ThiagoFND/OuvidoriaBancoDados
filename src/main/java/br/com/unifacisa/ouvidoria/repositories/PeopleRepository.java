package br.com.unifacisa.ouvidoria.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.unifacisa.ouvidoria.entities.People;

public interface PeopleRepository extends CrudRepository<People, Long> {
}
