package metier.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tableabonne")
public class Abonne {
	@Id
	@Column(name="cin")
	private int cin;
	@Column(name="nom")
	private String nom;
	@Column(name="numAbonnement")
	private int numAbonnement;
	@JoinColumn(name="titre")
	private Ouvrage ouvrage=null;
	private static int i=0;
	public Abonne() {
		super();
	}
	public Abonne(String nom, int cin) {
		super();
		this.numAbonnement=i;
		this.nom = nom;
		this.cin = cin;
		i++;
		
	}
	public Abonne(String nom, int numAbonnement , int cin, Ouvrage ouvrage) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.numAbonnement = numAbonnement;
		this.ouvrage = ouvrage;
	}
	@Override
	public String toString() {
		return "Abonne [cin=" + cin + ", nom=" + nom + ", numAbonnement=" + numAbonnement + ", ouvrage=" + ouvrage
				+ "]";
	}
	/**
	 * @return the cin
	 */
	public int getCin() {
		return cin;
	}
	/**
	 * @param cin the cin to set
	 */
	public void setCin(int cin) {
		this.cin = cin;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the numAbonnement
	 */
	public int getNumAbonnement() {
		return numAbonnement;
	}
	/**
	 * @param numAbonnement the numAbonnement to set
	 */
	public void setNumAbonnement(int numAbonnement) {
		this.numAbonnement = numAbonnement;
	}
	/**
	 * @return the ouvrage
	 */
	public Ouvrage getOuvrage() {
		return ouvrage;
	}
	/**
	 * @param ouvrage the ouvrage to set
	 */
	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}
	
	
}
