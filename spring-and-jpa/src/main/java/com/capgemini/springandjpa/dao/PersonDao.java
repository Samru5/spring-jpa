package com.capgemini.springandjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springandjpa.entity.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

}
