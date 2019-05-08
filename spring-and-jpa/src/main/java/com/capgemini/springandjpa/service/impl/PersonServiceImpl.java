package com.capgemini.springandjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springandjpa.dao.PersonDao;
import com.capgemini.springandjpa.entity.Person;
import com.capgemini.springandjpa.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao dao;

	@Override
	public void add(Person person) {
		dao.save(person);

	}

}
