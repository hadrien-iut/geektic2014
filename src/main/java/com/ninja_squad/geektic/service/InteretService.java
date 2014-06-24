package com.ninja_squad.geektic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.InteretDao;
import com.ninja_squad.geektic.entity.Interet;

@RestController
@Transactional
@RequestMapping("/api/interet")
public class InteretService {

	private InteretDao dao;

	@Autowired
	public InteretService(InteretDao dao) {
		super();
		this.dao = dao;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Interet getInteret(@PathVariable("id") Long id){
		return dao.findById(id);
	}
}
