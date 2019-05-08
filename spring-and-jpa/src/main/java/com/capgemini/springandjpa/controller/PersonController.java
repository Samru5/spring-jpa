package com.capgemini.springandjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springandjpa.dao.PersonDao;
import com.capgemini.springandjpa.entity.Person;
import com.capgemini.springandjpa.entity.Profile;
import com.capgemini.springandjpa.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;

	@Autowired
	PersonDao dao;

	@RequestMapping("/")
	public void addNew() {
		Person person = new Person(101, "John", new Profile(15, "COMPUTER"));

		service.add(person);

	}

	@RequestMapping("/new")
	public Person findAll() {
		Person person = dao.findById(101).get();
		return person;
	}
}
