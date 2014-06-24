package com.ninja_squad.geektic.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.entity.Interet;

@Repository
public class InteretDao {
	
	private EntityManager entityManager;

	public InteretDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	public Set<Geek> findGeekByInteretId(Long id){
		return entityManager.find(Interet.class, id).getGeeks();
	}
	
	public List<Interet> findAll(){
		String jpql = "select i from Interet as i order by i.libelle"; 
		TypedQuery<Interet> query = entityManager.createQuery(jpql, Interet.class); 
		List<Interet> interets = query.getResultList();
		return interets;
	}
	
	public Interet findById(Long id){
		return entityManager.find(Interet.class, id);
	}
}
