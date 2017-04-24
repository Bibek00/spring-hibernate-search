package com.springboot.repositoryCrud.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "tbl_address")
@Indexed
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String country;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String city;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String zip;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
	private Collection<Student> student = new ArrayList<>();

	public Address() {

	}

	public Address(String country, String city, String zip, Collection<Student> student) {
		super();
		this.country = country;
		this.city = city;
		this.zip = zip;
		this.student = student;
	}

	public Collection<Student> getStudent() {
		return student;
	}

	public void setStudent(Collection<Student> student) {
		this.student = student;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
