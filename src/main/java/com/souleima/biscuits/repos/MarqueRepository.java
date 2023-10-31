package com.souleima.biscuits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.souleima.biscuits.entities.Marque;

@RepositoryRestResource(path = "ma")
public interface MarqueRepository extends JpaRepository<Marque, Long> {

}
