package com.saphal.blogservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data{

	@JsonProperty("password")
	private String password;

	@JsonProperty("phoneNumber")
	private String phoneNumber;

	@JsonProperty("address")
	private String address;

	@JsonProperty("role")
	private Role role;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("id")
	private int id;

	@JsonProperty("email")
	private String email;

}