package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;


@Repository
public class GeekDao {

	@PersistenceContext
	private EntityManager entityManager;

	public GeekDao() {
	}
	
	public Geek findById(Long id){
		return entityManager.find(Geek.class, id);
	}
	
	public void persist(Geek geek){
		entityManager.persist(geek);
	}
	
	public List<Geek> findBySexeAndInteret(String sexe, Long idInteret){
		String jpql = "select g from Geek as g where g.sexe = :sexe";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Spectacle.class);
		query.setParameter("sexe", sexe);
	}
}
