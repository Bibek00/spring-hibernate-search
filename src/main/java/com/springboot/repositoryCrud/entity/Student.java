package com.springboot.repositoryCrud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "tbl_student")
@Indexed
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String fname;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String lname;

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String contact;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	@IndexedEmbedded
	private Address address;

	public Student() {

	}

	public Student(String fname, String lname, String contact, Address address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.contact = contact;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", fname=" + fname + ", lname=" + lname + ", contact=" + contact
				+ ", city=" + getAddress().getCity() + ", country=" + getAddress().getCountry() + ", zip=" + getAddress().getZip() + "]";
	}

	
	
}
