package com.codegnan.app.javawebapp18.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "credentials")
public class Credential {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "credential_id")
	private int credentialId;
	@Column(name = "username")
	private String username;
	@Column(name = "login_password")
	private String loginPassword;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	public Credential() {
	}

	public Credential(int credentialId, String username, String loginPassword, User user) {
		this.credentialId = credentialId;
		this.username = username;
		this.loginPassword = loginPassword;
		this.user = user;
	}

	public int getCredentialId() {
		return credentialId;
	}

	public String getUsername() {
		return username;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public User getUser() {
		return user;
	}

	public void setCredentialId(int credentialId) {
		this.credentialId = credentialId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public void setUser(User user) {
		this.user = user;
	}
}