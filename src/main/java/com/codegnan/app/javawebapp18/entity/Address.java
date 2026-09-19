 package com.codegnan.app.javawebapp18.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;
	@Column(name = "label")
	private String label;
	@Column(name = "line_1")
	private String line1;
	@Column(name = "line_2")
	private String line2;
	@Column(name = "line_3")
	private String line3;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String pincode;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Address() {
	}

	public Address(int addressId, String label, String line1, String line2, String line3, String city, String state, String pincode, User user) {
		this.addressId = addressId;
		this.label = label;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.user = user;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getLabel() {
		return label;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getLine3() {
		return line3;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public User getUser() {
		return user;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", label=" + label + ", line1=" + line1 + ", line2=" + line2
				+ ", line3=" + line3 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", user=" + user
				+ "]";
	}
}