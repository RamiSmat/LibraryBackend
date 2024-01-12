package metier;


import java.util.List;

import javax.ejb.Local;

import metier.entities.Ouvrage;

@Local
public interface OuvrageLocal {
	public void ajoutOuvrage(Ouvrage ouvrage);
	public void suppOuvrage(Ouvrage ouvrage);
	public Ouvrage rechercheOuvrage(String titre);
	public void updateOuvrage(Ouvrage ouvrage);
	List<Ouvrage> getAllOuvrages();
}
