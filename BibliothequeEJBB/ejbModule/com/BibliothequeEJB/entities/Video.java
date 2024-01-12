//package com.BibliothequeEJB.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="Video")
//public class Video extends Ouvrage {
//	@Column(name="editor")
//	private String editor;
//	@Column(name="duree")
//	private float duree;
//	
//	public Video() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Video(String titre, String dateCreation, boolean exist) {
//		super(titre, dateCreation);
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Video [editor=" + editor + ", duree=" + duree + ", toString()=" + super.toString() + ", getClass()="
//				+ getClass() + ", hashCode()=" + hashCode() + "]";
//	}
//
//	public Video(String titre, String dateCreation,String editor,float duree) {
//		super(titre, dateCreation);
//		this.editor=editor;
//		this.duree=duree;
//	}
//
//	/**
//	 * @return the editor
//	 */
//	public String getEditor() {
//		return editor;
//	}
//
//	/**
//	 * @param editor the editor to set
//	 */
//	public void setEditor(String editor) {
//		this.editor = editor;
//	}
//
//	/**
//	 * @return the duree
//	 */
//	public float getDuree() {
//		return duree;
//	}
//
//	/**
//	 * @param duree the duree to set
//	 */
//	public void setDuree(float duree) {
//		this.duree = duree;
//	}
//	
//	
//}
