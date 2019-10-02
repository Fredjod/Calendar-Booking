package com.fredjod.cbooking.customer.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Customer {
	
	@Id
    String id;	
	
    String lastname;
    String firstname;
    String doi; // Date of Inscription
    Integer dob; // Date of Birth
    
    
	public Customer(String email, String lastname, String firstname, String doi, Integer dob) {
		this.lastname = lastname;
		this.firstname = firstname;
		this.doi = doi;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, lastname=%s, firstname=%s, doi=%s, dob=%s]", id,
				lastname, firstname, doi, dob);
	}
	
}
