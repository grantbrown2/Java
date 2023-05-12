package com.grantbrown.bookclub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginUser {
	@NotBlank(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String loginEmail;
	
	@NotBlank(message="Password is required!")
	private String loginPassword;
	
	public LoginUser() {}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}
