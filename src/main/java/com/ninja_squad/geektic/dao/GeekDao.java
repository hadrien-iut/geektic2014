package com.ninja_squad.geektic.dao;

import java.util.List;

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
		String jpql = "select g from Geek as g join g.interets as i left outer join fetch g.interets where g.sexe like :sexe and i.id = :idInteret";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		query.setParameter("idInteret", idInteret);
		List<Geek> geeks = query.getResultList();
		return geeks;
	}
}
