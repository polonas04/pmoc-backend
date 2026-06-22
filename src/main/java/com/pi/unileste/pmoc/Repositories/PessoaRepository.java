package com.pi.unileste.pmoc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.unileste.pmoc.Models.Pessoa;

/*
 * save()

findAll()

findById()

deleteById()

existsById()
 *
 */

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String>{
	
}
