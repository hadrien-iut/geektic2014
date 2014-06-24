package com.ninja_squad.geektic.dao;

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
}
