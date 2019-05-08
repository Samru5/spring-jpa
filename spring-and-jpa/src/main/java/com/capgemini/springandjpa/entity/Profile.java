package com.capgemini.springandjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROFILE")

public class Profile {

	@Id
	private int profileId;
	
	private String description;
	
	@OneToOne(mappedBy = "profile")
	private Person person;

	public Profile() {
		super();
	}

	public Profile(int profileId, String description) {
		super();
		this.profileId = profileId;
		this.description = description;

	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", description=" + description + ", person=" + person + "]";
	}

}
