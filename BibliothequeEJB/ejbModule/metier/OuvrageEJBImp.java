package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import metier.entities.Ouvrage;



@Stateless (name="BibliothequeEJB")
public class OuvrageEJBImp implements OuvrageLocal {

	@Override
	public void ajoutOuvrage(Ouvrage ouvrage) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		jpautli.getEntitymanager().persist(ouvrage);
		jpautli.getEntityTransaction().commit();
	}

	@Override
	public void suppOuvrage(Ouvrage ouvrage) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		Ouvrage ouvr = jpautli.getEntitymanager().find(Ouvrage.class,ouvrage.getTitre());
		if (ouvr != null) {
			jpautli.getEntitymanager().remove(ouvr);
		}
		else {
			System.out.println("Ouvrage Introuvable");
		}
		//Query query = jpautli.getEntitymanager().createQuery("");
		jpautli.getEntityTransaction().commit();
		jpautli.closeEntityManager();
	}

	@Override
	public Ouvrage rechercheOuvrage(String titre) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		Ouvrage ouvrage=  jpautli.getEntitymanager().find(Ouvrage.class, titre);
		jpautli.getEntityTransaction().commit();
		jpautli.closeEntityManager();
		if (ouvrage!=null) {
			return ouvrage;
		}
		else {
			return null;
		}

	}

	@Override
	public void updateOuvrage(Ouvrage ouvrage) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		jpautli.getEntitymanager().merge(ouvrage);
		jpautli.getEntityTransaction().commit();
		jpautli.closeEntityManager();

		
	}
	  @Override
	    public List<Ouvrage> getAllOuvrages() {
	        JpaUtil jpautli = new JpaUtil();
	        jpautli.getEntityTransaction().begin();
	        
	       
	        TypedQuery<Ouvrage> query = jpautli.getEntitymanager().createQuery("SELECT o FROM Ouvrage o", Ouvrage.class);
	        List<Ouvrage> ouvrages = query.getResultList();
	        
	        jpautli.getEntityTransaction().commit();
	        jpautli.closeEntityManager();

	        return ouvrages;
	    }
	
}

