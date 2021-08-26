package com.hb.co;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
*
* @author SUHEL KHAN
*/
@Entity
@Table(name = "users")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private BigInteger id;

	@Column(name = "name")
	private String name;

	
	@Column(name = "address")
	private String address;


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

}
