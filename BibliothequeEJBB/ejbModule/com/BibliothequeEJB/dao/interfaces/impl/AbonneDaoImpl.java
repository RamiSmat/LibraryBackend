//package com.BibliothequeEJB.dao.interfaces.impl;
//import com.BibliothequeEJB.dao.interfaces.OuvrageDao;
//
//import javax.ejb.Stateless;
//
//import com.BibliothequeEJB.dao.interfaces.AbonneDao;
//import com.BibliothequeEJB.entities.Abonne;
//import com.BibliothequeEJB.entities.Ouvrage;
//import com.BibliothequeEJB.util.JpaUtil;
//
//@Stateless
//public class AbonneDaoImpl implements AbonneDao {
//
//	@Override
//	public void ajoutAbonne(Abonne abonne) {
//		JpaUtil jpautli = new JpaUtil();
//		try {
//			jpautli.getEntityTransaction().begin();
//			jpautli.getEntitymanager().persist(abonne);
//			jpautli.getEntityTransaction().commit();
//			jpautli.closeEntityManager();
//		}
//		catch(Exception ex) {
//			jpautli.getEntityTransaction().rollback();
//		}
//		
//
//	}
//
//	@Override
//	public void suppAbonne(Abonne abonne) {
//		JpaUtil jpautli = new JpaUtil();
//		jpautli.getEntityTransaction().begin();
//		Abonne abon = jpautli.getEntitymanager().find(Abonne.class,abonne.getCin());
//		if (abon != null) {
//			jpautli.getEntitymanager().remove(abon);
//		}
//		else {
//			System.out.println("Abonné Introuvable");
//		}
//		jpautli.getEntityTransaction().commit();
//		jpautli.closeEntityManager();		
//	}
//
//	@Override
//	public Abonne rechercheAbonne(int identite) {
//		JpaUtil jpautli = new JpaUtil();
//		jpautli.getEntityTransaction().begin();
//		Abonne abonne=  jpautli.getEntitymanager().find(Abonne.class, identite);
//		jpautli.getEntityTransaction().commit();
//		jpautli.closeEntityManager();
//		return abonne;
//	}
//
//	@Override
//	public void updateAbonne(Abonne abonne) {
//		JpaUtil jpautli = new JpaUtil();
//		jpautli.getEntityTransaction().begin();
//		jpautli.getEntitymanager().merge(abonne);
//		jpautli.getEntityTransaction().commit();
//		jpautli.closeEntityManager();
//	}
//
//
//	@Override
//	public void emprunter(String titre, int identite) {
//		
//		OuvrageDao ouvrageDaoImp = new OuvrageDaoImpl();
//		Ouvrage ouvrage = new Ouvrage();
//		ouvrage = ouvrageDaoImp.rechercheOuvrage(titre);
//		if(ouvrage != null) {
//			if (ouvrage.isExist()) {
//				AbonneDao abonneDaoImp = new AbonneDaoImpl();
//				Abonne abonne = new Abonne();
//				abonne = abonneDaoImp.rechercheAbonne(identite);
//				if (abonne.getOuvrage()==null) {
//					ouvrage.setExist(false);
//					System.out.println(ouvrage);
//					System.out.println(abonne);
//					abonne.setOuvrage(ouvrage);
//					ouvrageDaoImp.updateOuvrage(ouvrage);
//					abonneDaoImp.updateAbonne(abonne);
//				}
//				
//			}
//			else {
//				System.out.println("L'ouvrage n'est pas disponible");
//			}
//		}
//		
//	}
//	@Override
//	public void rendre(int identite) {
//		AbonneDao abonneDaoImp = new AbonneDaoImpl();
//		Abonne abonne = abonneDaoImp.rechercheAbonne(identite);
//		Ouvrage ouvrage = abonne.getOuvrage();
//		OuvrageDao ouvrageDaoImp = new OuvrageDaoImpl();
//		ouvrage.setExist(true);
//		abonne.setOuvrage(null);
//		ouvrageDaoImp.updateOuvrage(ouvrage);
//		abonneDaoImp.updateAbonne(abonne);
//		
//	}
//
//}
