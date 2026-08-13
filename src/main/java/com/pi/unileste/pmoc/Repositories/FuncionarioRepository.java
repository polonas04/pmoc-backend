package com.pi.unileste.pmoc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.unileste.pmoc.Models.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,String> {

}
