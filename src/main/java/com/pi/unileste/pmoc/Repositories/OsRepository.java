package com.pi.unileste.pmoc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pi.unileste.pmoc.Models.Os;

@Repository
public interface OsRepository extends JpaRepository<Os, Integer> {

}
