package metier;


import java.util.List;

import javax.ejb.Local;

import metier.entities.Abonne;
@Local
public interface AbonneLocal {
	public void ajoutAbonne(Abonne abonne);
	public void suppAbonne(Abonne abonne);
	public Abonne rechercheAbonne(int identite);
	public void updateAbonne(Abonne abonne);
	public void emprunter(String titre, int identite);
	public void rendre(int identite);
	public List<Abonne> getAllAbonnes();

	}
