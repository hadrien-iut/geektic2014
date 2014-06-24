package com.ninja_squad.geektic.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(sequenceName = "interet_seq", name = "gen_interet")
public class Interet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="interet_seq")
	private Long id;
	
	private String libelle;
	
	@ManyToMany
	@JoinTable(name = "GEEK_INTERET", joinColumns = @JoinColumn(name = "ID_INTERET"), inverseJoinColumns = @JoinColumn(name = "ID_GEEK"))
	private Set<Geek> geeks;
	
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

	public Set<Geek> getGeeks() {
		return geeks;
	}

	public void setGeeks(Set<Geek> geeks) {
		this.geeks = geeks;
	}

}
