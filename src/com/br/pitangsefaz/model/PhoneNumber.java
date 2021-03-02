package com.br.pitangsefaz.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int ddd;

	private String number;

	private String type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(int ddd, String number, String type, User user) {
		super();
		this.ddd = ddd;
		this.number = number;
		this.type = type;
		this.user = user;
	}

	public PhoneNumber(int id, int ddd, String number, String type, User user) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.type = type;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PhoneNumber:" + "(" + ddd + ")" + number + " " + type;
	}

}
