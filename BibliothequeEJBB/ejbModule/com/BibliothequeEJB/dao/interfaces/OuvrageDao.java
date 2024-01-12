package com.BibliothequeEJB.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.BibliothequeEJB.entities.Ouvrage;
@Local
public interface OuvrageDao {
	public void ajoutOuvrage(Ouvrage ouvrage);
	public void suppOuvrage(Ouvrage ouvrage);
	public Ouvrage rechercheOuvrage(String titre);
	public void updateOuvrage(Ouvrage ouvrage);
	List<Ouvrage> getAllOuvrages();
}
