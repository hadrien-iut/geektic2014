package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.dao.InteretDao;
import com.ninja_squad.geektic.entity.Interet;

@RestController
@Transactional
@RequestMapping("/api/interet")
public class InteretService {

	@Autowired
	private InteretDao dao;

	public InteretService() {
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Interet> getAllInteret(){
		return dao.findAll();
	}
}
