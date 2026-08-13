package com.pi.unileste.pmoc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.unileste.pmoc.Models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
