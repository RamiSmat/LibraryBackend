//package com.BibliothequeEJB.dao.interfaces.impl;
//
//import javax.ejb.Stateless;
//
//import com.BibliothequeEJB.dao.interfaces.VideoDao;
//import com.BibliothequeEJB.entities.Video;
//import com.BibliothequeEJB.util.JpaUtil;
//
//@Stateless
//public class VideoDaoImpl implements VideoDao {
//	public void ajouterVideo(Video video) {
//		JpaUtil jpautli = new JpaUtil();
//		jpautli.getEntityTransaction().begin();
//		jpautli.getEntitymanager().persist(video);
//		jpautli.getEntityTransaction().commit();
//		jpautli.closeEntityManager();
//	}
//}
