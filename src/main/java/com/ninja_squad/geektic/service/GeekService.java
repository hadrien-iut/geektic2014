package com.ninja_squad.geektic.service;

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
	
	private GeekDao dao;

	@Autowired
	public GeekService(GeekDao dao) {
		super();
		this.dao = dao;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Geek getGeek(@PathVariable("id") Long id){
		return dao.findById(id);
	}

}
