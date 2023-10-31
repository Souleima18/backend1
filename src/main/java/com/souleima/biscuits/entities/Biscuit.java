package com.souleima.biscuits.entities;

import java.util.Date;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Biscuit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBiscuit;
	private String nomBiscuit;
	private Double prixBiscuit;
	private Date dateSortir;
	
	@ManyToOne
	private Marque marque;

	
	/*@OneToOne
	private Image image;*/
	
	
	 @OneToMany (mappedBy = "biscuit")
	 private List<Image> images;
	 
	 private String imagePath;


	

	public Biscuit() {
		super();
	}

	public Biscuit(String nomBiscuit, Double prixBiscuit, Date dateSortir) {
		super();
		this.nomBiscuit = nomBiscuit;
		this.prixBiscuit = prixBiscuit;
		this.dateSortir = dateSortir;
	}



	public Long getIdBiscuit() {
		return idBiscuit;
	}

	public void setIdBiscuit(Long idBiscuit) {
		this.idBiscuit = idBiscuit;
	}

	public String getNomBiscuit() {
		return nomBiscuit;
	}

	public void setNomBiscuit(String nomBiscuit) {
		this.nomBiscuit = nomBiscuit;
	}

	public Double getPrixBiscuit() {
		return prixBiscuit;
	}

	public void setPrixBiscuit(Double prixBiscuit) {
		this.prixBiscuit = prixBiscuit;
	}

	public Date getDateSortir() {
		return dateSortir;
	}

	public void setDateSortir(Date dateSortir) {
		this.dateSortir = dateSortir;
	}
	
	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Biscuit [idBiscuit=" + idBiscuit + ", nomBiscuit=" + nomBiscuit + ", prixBiscuit=" + prixBiscuit
				+ ", dateSortir=" + dateSortir + ", marque=" + marque  + "]";
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	

	
	
}
