package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import metier.entities.Abonne;
import metier.entities.Ouvrage;

@Stateless
public class AbonneEJBImp implements AbonneLocal {

	@Override
	public void ajoutAbonne(Abonne abonne) {
		JpaUtil jpautli = new JpaUtil();
		try {
			jpautli.getEntityTransaction().begin();
			jpautli.getEntitymanager().persist(abonne);
			jpautli.getEntityTransaction().commit();
			jpautli.closeEntityManager();
		}
		catch(Exception ex) {
			jpautli.getEntityTransaction().rollback();
		}
		

	}

	@Override
	public void suppAbonne(Abonne abonne) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		Abonne abon = jpautli.getEntitymanager().find(Abonne.class,abonne.getCin());
		if (abon != null) {
			jpautli.getEntitymanager().remove(abon);
		}
		else {
			System.out.println("Abonné Introuvable");
		}
		jpautli.getEntityTransaction().commit();
		jpautli.closeEntityManager();		
	}

	@Override
	public Abonne rechercheAbonne(int identite) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		Abonne abonne=  jpautli.getEntitymanager().find(Abonne.class, identite);
		jpautli.getEntityTransaction().commit();
		jpautli.closeEntityManager();
		return abonne;
	}

	@Override
	public void updateAbonne(Abonne abonne) {
		JpaUtil jpautli = new JpaUtil();
		jpautli.getEntityTransaction().begin();
		jpautli.getEntitymanager().merge(abonne);
		jpautli.getEntityTransaction().commit();
		jpautli.closeEntityManager();
	}


	@Override
	public void emprunter(String titre, int identite) {
	    OuvrageLocal ouvrageDaoImp = new OuvrageEJBImp();
	    Ouvrage ouvrage = ouvrageDaoImp.rechercheOuvrage(titre);

	    if (ouvrage != null && ouvrage.isExist()) {
	        AbonneLocal abonneDaoImp = new AbonneEJBImp();
	        Abonne abonne = abonneDaoImp.rechercheAbonne(identite);

	        if (abonne != null && abonne.getOuvrage() == null) {
	            ouvrage.setExist(false);
	            abonne.setOuvrage(ouvrage);

	            // Update the existing Abonne entity
	            abonneDaoImp.updateAbonne(abonne);
	            // No need to update the Ouvrage entity separately, as it should be cascaded with Abonne

	        } else {
	            System.out.println("Abonne not found or Abonne already has an ouvrage.");
	        }
	    } else {
	        System.out.println("L'ouvrage n'est pas disponible");
	    }
	}
	@Override
	public void rendre(int identite) {
		AbonneLocal abonneDaoImp = new AbonneEJBImp();
		Abonne abonne = abonneDaoImp.rechercheAbonne(identite);
		Ouvrage ouvrage = abonne.getOuvrage();
		OuvrageLocal ouvrageDaoImp = new OuvrageEJBImp();
		ouvrage.setExist(true);
		abonne.setOuvrage(null);
		ouvrageDaoImp.updateOuvrage(ouvrage);
		abonneDaoImp.updateAbonne(abonne);
		
	}

	@Override
	public List<Abonne> getAllAbonnes() {
	    JpaUtil jpautli = new JpaUtil();
	    jpautli.getEntityTransaction().begin();
	    
	    TypedQuery<Abonne> query = jpautli.getEntitymanager().createQuery("SELECT a FROM Abonne a", Abonne.class);
	    List<Abonne> abonnes = query.getResultList();
	    
	    jpautli.getEntityTransaction().commit();
	    jpautli.closeEntityManager();

	    return abonnes;
	}


}
