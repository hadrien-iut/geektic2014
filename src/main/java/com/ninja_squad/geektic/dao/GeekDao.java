package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.entity.Geek;
import com.ninja_squad.geektic.enumerator.Sexe;


@Repository
public class GeekDao {

	@PersistenceContext
	private EntityManager entityManager;

	public GeekDao() {
	}
	
	public Geek findById(Long id){
		String jpql = "select distinct g from Geek g left join fetch g.interets where g.id = :id";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Geek> findBySexeAndInteret(Sexe sexe, Long idInteret){
		String jpql = "select distinct g from Geek g left join fetch g.interets i inner join g.interets ir where g.sexe = :sexe and ir.id = :idInteret";
		TypedQuery<Geek> query = entityManager.createQuery(jpql, Geek.class);
		query.setParameter("sexe", sexe);
		query.setParameter("idInteret", idInteret);
		List<Geek> list = query.getResultList();
		return list;
	}
	
	public void persist(Long id, Long view){
		Geek geek = findById(id);
		geek.setView(view);
		entityManager.merge(geek);
	}
}
