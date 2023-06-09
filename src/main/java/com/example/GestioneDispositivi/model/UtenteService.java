package com.example.GestioneDispositivi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;

	public Utente saveUtente(Utente utente) {
		return utenteRepository.save(utente);
	}

	public Utente getUtenteByUsername(String username) {
		return utenteRepository.findByUsername(username);
	}

	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}