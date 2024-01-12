//package com.BibliothequeEJB.dao.interfaces.impl;
//
//import javax.ejb.Stateless;
//
//import com.BibliothequeEJB.dao.interfaces.LivreDao;
//import com.BibliothequeEJB.entities.Livre;
//import com.BibliothequeEJB.util.JpaUtil;
//
//@Stateless
//public class LivreDaoImpl implements LivreDao {
//	public void ajouterLivre(Livre livre) {
//		JpaUtil jpautli = new JpaUtil();
//		jpautli.getEntityTransaction().begin();
//		jpautli.getEntitymanager().persist(livre);
//		jpautli.getEntityTransaction().commit();
//		jpautli.closeEntityManager();
//	}
//}
