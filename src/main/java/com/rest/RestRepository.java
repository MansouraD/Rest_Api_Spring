package com.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RestRepository extends JpaRepository<Pharmacie, Integer> {

	@Query("SELECT p FROM Pharmacie p WHERE p.nom like:*")
	public List<Pharmacie> getPharmacieByNom(@Param("*")String nom);
}
