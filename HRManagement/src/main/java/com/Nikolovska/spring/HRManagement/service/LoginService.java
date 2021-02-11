package com.Nikolovska.spring.HRManagement.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String usernameid, String password) {
		return usernameid.equalsIgnoreCase("admin")
				&& password.equalsIgnoreCase("admin");
	}

}