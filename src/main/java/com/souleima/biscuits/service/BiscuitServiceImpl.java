package com.souleima.biscuits.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souleima.biscuits.entities.Marque;
import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.repos.ImageRepository;
import com.souleima.biscuits.repos.BiscuitRepository;

@Service
public class BiscuitServiceImpl implements BiscuitService {

	@Autowired
	BiscuitRepository biscuitRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	
	
	@Override
	public Biscuit saveBiscuit(Biscuit b) {
		return biscuitRepository.save(b);
		
	}

	/*@Override
	public Biscuit updateBiscuit(Biscuit b) {
		return biscuitRepository.save(b);
		
	}*/
	
	@Override
	public Biscuit updateBiscuit(Biscuit b) {
		//Long oldProdImageId = this.getBiscuit(b.getIdBiscuit()).getImage().getIdImage();
	//	Long newProdImageId = b.getImage().getIdImage();
		Biscuit biscUpdated = biscuitRepository.save(b);
		
	//	if (oldProdImageId != newProdImageId) // si l'image a été modifiée
		//	imageRepository.deleteById(oldProdImageId);
		return biscUpdated;
	}

	@Override
	public void deleteBiscuit(Biscuit b) {
		biscuitRepository.delete(b);

	}

   @Override
	public void deleteBiscuitById(Long id) {
	   
	   //supprimer l'image avant de supprimer le produit
	    Biscuit b = getBiscuit(id);
	   try {
		Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+b.getImagePath()));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		biscuitRepository.deleteById(id);
		
	}

	@Override
	public Biscuit getBiscuit(Long id) {
		return  biscuitRepository.findById(id).get();
	
	}

	@Override
	public List<Biscuit> getAllBiscuits() {
		return biscuitRepository.findAll();
	}
	
    @Override
	public List<Biscuit> findByNomBiscuit(String nom) {
		return biscuitRepository.findByNomBiscuit(nom);
	}

	@Override
	public List<Biscuit> findByNomBiscuitContains(String nom) {
		return biscuitRepository.findByNomBiscuitContains(nom);
	}

	@Override
	public List<Biscuit> findByNomPrix(String nom, Double prix) {
		return biscuitRepository.findByNomPrix(nom, prix);
	}
	
	@Override
	public List<Biscuit> findByMarque(Marque marque) {
		return biscuitRepository.findByMarque(marque);
	}

	@Override
	public List<Biscuit> findByMarqueIdMarque(Long id) {
		return biscuitRepository.findByMarqueIdMarque(id);
	}

	@Override
	public List<Biscuit> findByOrderByNomBiscuitAsc() {
		return biscuitRepository.findByOrderByNomBiscuitAsc();
	}

	@Override
	public List<Biscuit> trierBiscuitsNomsPrix() {
		return biscuitRepository.trierBiscuitsNomsPrix();
	}


}
