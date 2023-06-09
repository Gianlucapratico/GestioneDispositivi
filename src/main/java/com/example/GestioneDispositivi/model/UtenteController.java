package com.example.GestioneDispositivi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
	@Autowired
	private UtenteService utenteService;

	@PostMapping("/registrati")
	public ResponseEntity<?> registraUtente(@RequestBody Utente utente) {
		// Validazione e salvataggio dell'utente nel database
		Utente nuovoUtente = utenteService.saveUtente(utente);
		return ResponseEntity.ok(nuovoUtente);
	}

}
