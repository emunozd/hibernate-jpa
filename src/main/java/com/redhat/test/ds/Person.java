package com.redhat.test.ds;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.math.BigDecimal;


/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
@Table(name="PERSON")
@NamedQuery(name="personAll", query="SELECT p FROM Person p")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	private String document;
	
	@Id
	private BigDecimal id;

	private String name;

	public Person() {
	}


	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}