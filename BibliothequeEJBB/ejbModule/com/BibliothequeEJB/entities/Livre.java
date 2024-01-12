//package com.BibliothequeEJB.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="Livre")
//public class Livre extends Ouvrage {
//	@Column(name="auteur")
//	private String auteur;
//	public Livre(String titre, String dateCreation, boolean exist,String auteur) {
//		super(titre, dateCreation);
//		this.auteur=auteur;
//	}
//	
//	public Livre() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Livre(String titre, String dateCreation,String auteur) {
//		super(titre, dateCreation);
//		this.auteur=auteur;
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Livre [auteur=" + auteur + ", toString()=" + super.toString() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + "]";
//	}
//	/**
//	 * @return the auteur
//	 */
//	public String getAuteur() {
//		return auteur;
//	}
//	/**
//	 * @param auteur the auteur to set
//	 */
//	public void setAuteur(String auteur) {
//		this.auteur = auteur;
//	}
//	
//	
//
//}
