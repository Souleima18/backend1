package com.souleima.biscuits.service;

import java.util.List;

import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.entities.Biscuit;

public interface BiscuitService {
	
	 Biscuit saveBiscuit(Biscuit b);
	 Biscuit updateBiscuit(Biscuit b);
	 void deleteBiscuit(Biscuit b);
     void deleteBiscuitById(Long id);
	 Biscuit getBiscuit(Long id);
	 List<Biscuit> getAllBiscuits();
	 
	 List<Biscuit> findByNomBiscuit(String nom);
	 List<Biscuit> findByNomBiscuitContains(String nom);
	 List<Biscuit> findByNomPrix (String nom, Double prix);
	 List<Biscuit> findByMarque (Marque marque);
	 List<Biscuit> findByMarqueIdMarque(Long id);
	 List<Biscuit> findByOrderByNomBiscuitAsc();
	 List<Biscuit> trierBiscuitsNomsPrix();

}
