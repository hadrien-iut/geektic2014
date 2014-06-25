package com.ninja_squad.geektic.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.ninja_squad.geektic.enumerator.Sexe;
import com.ninja_squad.geektic.util.MD5Util;




@Entity
@SequenceGenerator(sequenceName = "geek_seq", name = "gen_geek")
@Inheritance(strategy = InheritanceType.JOINED)
public class Geek {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_geek")
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "sexe")
	private Sexe sexe;
	
	private String mail;
	
	@Column(name= "view_prof")
	private Long view;
	
	@ManyToMany
	@JoinTable(name = "GEEK_INTERET", joinColumns = @JoinColumn(name = "ID_GEEK"), inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
	private Set<Interet> interets;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Set<Interet> getInterets() {
		return interets;
	}

	public void setInterets(Set<Interet> interets) {
		this.interets = interets;
	}
	
	public String getGravatar(){
		return MD5Util.md5Hex(mail);
	}

	public Long getView() {
		return view;
	}

	public void setView(Long view) {
		this.view = view;
	}
	
	
}
