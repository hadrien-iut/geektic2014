package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.GeekDao;
import com.ninja_squad.geektic.entity.Geek;

@RestController
@Transactional
@RequestMapping("/api/geek")
public class GeekService {
	
	@Autowired
	private GeekDao dao;
	
	public GeekService() {
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Geek getGeek(@PathVariable("id") Long id){
		return dao.findById(id);
	}
	
	@RequestMapping(value="/{sexe}/{id}", method = RequestMethod.GET)
	public List<Geek> getGeekBySexeAndInteret(@PathVariable("sexe") String sexe, @PathVariable("id") Long idInteret){
		return dao.findBySexeAndInteret(sexe, idInteret);
	}

}
