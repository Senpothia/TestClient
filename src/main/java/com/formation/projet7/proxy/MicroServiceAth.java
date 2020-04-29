package com.formation.projet7.proxy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.formation.projet7.model.Login;


@FeignClient(name="restjwt", url="localhost:8046")
public interface MicroServiceAth {
		
	@PostMapping("/token")
	public ResponseEntity<String> generate(@RequestBody final Login login);
	
	@GetMapping("api/acceso_solo_con_jwt")
	public ResponseEntity<?> getInformacionBancaria(@RequestHeader("authorization") String token);
		
	
}
