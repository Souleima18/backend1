package com.souleima.biscuits.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.entities.Biscuit;

public interface BiscuitRepository extends JpaRepository<Biscuit, Long> {
	List<Biscuit> findByNomBiscuit(String nom);
	List<Biscuit> findByNomBiscuitContains(String nom);   
	
	@Query("select b from Biscuit b where b.nomBiscuit like %:nom and b.prixBiscuit > :prix")
	List<Biscuit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
    
	@Query("select b from Biscuit b where b.marque = ?1")
	List<Biscuit> findByMarque (Marque marque);
	
	List<Biscuit> findByMarqueIdMarque(Long id);
	
	List<Biscuit> findByOrderByNomBiscuitAsc();
	
	@Query("select b from Biscuit b order by b.nomBiscuit ASC, b.prixBiscuit DESC")
	List<Biscuit> trierBiscuitsNomsPrix ();
	              

}
