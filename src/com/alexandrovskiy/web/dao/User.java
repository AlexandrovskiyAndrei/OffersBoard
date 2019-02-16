package com.alexandrovskiy.web.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	@NotBlank(message="Username should not be blank.")
	@Size(min=8, max=15, message="Username must be between 8 and 15 characters long.")
	@Pattern(regexp="^\\w{8,}$", message="Username can only consist of numbers, letters and the underscore symbol.")
	private String username;
	
	private String password;
	private String email;
	private boolean enabled = false;
	private String authority;

	public User() {
	}

	public User(String username, String password, String email, boolean enabled,
			String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
