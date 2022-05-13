package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Customer {

	private Long id;
	private String firstName;
	private String surname;
	private String address;

	public Customer(String firstName, String surname, String address) {
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setAddress(address);
	}

	public Customer(Long id, String firstName, String surname, String address) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setAddress(address);
	}
	public Customer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, firstName, id, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(surname, other.surname);
	}

	
	
	
	//I ADDED AN ADDRESS SO REGENERATED A HASHCODE AND EQUALS TOO BUT WAS A BIG VISUAL CHANGE SO HAVE KEPT.
	
	
	
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer other = (Customer) obj;
//		if (getFirstName() == null) {
//			if (other.getFirstName() != null)
//				return false;
//		} else if (!getFirstName().equals(other.getFirstName()))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (surname == null) {
//			if (other.surname != null)
//				return false;
//		} else if (!surname.equals(other.surname))
//			return false;
//		return true;
//	}

}
