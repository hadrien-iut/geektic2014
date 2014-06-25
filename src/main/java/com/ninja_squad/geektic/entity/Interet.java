package com.ninja_squad.geektic.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(sequenceName = "interet_seq", name = "gen_interet")
public class Interet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_interet")
	private Long id;
	
	private String libelle;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
