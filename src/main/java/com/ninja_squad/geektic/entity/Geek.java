package com.ninja_squad.geektic.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(sequenceName = "geek_seq", name = "gen_geek")
@Inheritance(strategy = InheritanceType.JOINED)
public class Geek {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="geek_seq")
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private String mail;
	
	@OneToMany(mappedBy = "interet")
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

	public Set<Interet> getInterets() {
		return interets;
	}

	public void setInterets(Set<Interet> interets) {
		this.interets = interets;
	}
}