package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Interet;

@Repository
public class InteretDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public InteretDao() {
	}
	
	public List<Interet> findAll(){
		String jpql = "select i from Interet as i order by i.libelle"; 
		TypedQuery<Interet> query = entityManager.createQuery(jpql, Interet.class); 
		List<Interet> interets = query.getResultList();
		return interets;
	}
}
