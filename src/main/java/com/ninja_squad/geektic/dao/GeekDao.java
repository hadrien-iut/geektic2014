package com.ninja_squad.geektic.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;

@Repository
public class GeekDao {

	private EntityManager entityManager;

	public GeekDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public Geek findById(Long id){
		return entityManager.find(Geek.class, id);
	}
	
	public void persist(Geek geek){
		entityManager.persist(geek);
	}
}
