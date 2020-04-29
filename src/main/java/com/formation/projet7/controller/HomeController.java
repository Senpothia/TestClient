package com.formation.projet7.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.formation.projet7.model.Login;
import com.formation.projet7.proxy.MicroServiceAth;

@Controller
public class HomeController {

	@Autowired
	MicroServiceAth service;

	@GetMapping("/")
	public String accueil() {

		Login login = new Login("alberto", "1234");
		ResponseEntity<String> tokenBody = service.generate(login);
		String token = tokenBody.getBody();
		System.out.println("Identifiants transmis au service");
		System.out.println("token: " + token);
		return "ok";
	}

	@GetMapping("/access")
	public ResponseEntity<?> access() {
		
		String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGJlcnRvIiwidXNlcklkIjoiMSIsInJvbGUiOiJBZG1pbiJ9.Frk8xv9LycYxvX36w9-dMs1q-v1HJ3JQecKWtRtQnvo";
		
		return service.getInformacionBancaria(token);
		
	}
	

}
