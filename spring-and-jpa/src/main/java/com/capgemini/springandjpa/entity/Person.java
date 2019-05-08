package com.capgemini.springandjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")

public class Person {

	@Id
	private int personId;

	private String personName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Profile profile;

	public Person() {
		super();
	}

	public Person(int personId, String personName, Profile profile) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.profile = profile;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", profile=" + profile + "]";
	}

}
