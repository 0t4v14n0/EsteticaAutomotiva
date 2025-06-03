package com.esteticaAutomotiva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esteticaAutomotiva.domain.pessoa.cliente.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
    @Transactional
    @PostMapping("/agendar")
    public ResponseEntity<?> agendar(Authentication authentication) {
        return ResponseEntity.ok(clienteService.dadosCliene(authentication.getName()));        
    }
	


}
