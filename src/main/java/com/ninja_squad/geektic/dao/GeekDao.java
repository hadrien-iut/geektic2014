package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		String jpql = "select distinct g from Geek g left join fetch g.interets i inner join g.interets ir where g.sexe = :sexe and ir.id = :idInteret";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		query.setParameter("idInteret", idInteret);
		List<Geek> list = query.getResultList();
		Set<Geek> noDuplicates = new HashSet<>(list);
		return new ArrayList<>(noDuplicates);
	}
}
