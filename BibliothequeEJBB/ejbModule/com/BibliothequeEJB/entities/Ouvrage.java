package com.BibliothequeEJB.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
public class Ouvrage implements Serializable {
	/**
	 * 
	 */
	
	@Id
	@Column(name="titre")
	private String titre;
	
	@Column(name="dateCreation")
	private String dateCreation;
	
	@Column(name="exist")
	private boolean exist=true;
	private static final long serialVersionUID = 1L;
	
	public Ouvrage() {
		super();
	}

	
	@Override
	public String toString() {
		return "Ouvrage [titre=" + titre + ", dateCreation=" + dateCreation + ", exist="
				+ exist + "]";
	}


	public Ouvrage(String titre, String dateCreation) {
		super();
		this.titre = titre;
		this.dateCreation = dateCreation;
		
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}
	
	
}