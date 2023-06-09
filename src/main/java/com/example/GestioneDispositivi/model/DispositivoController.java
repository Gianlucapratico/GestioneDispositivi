package com.example.GestioneDispositivi.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {
	@Autowired
	private DispositivoService dispositivoService;

	@GetMapping
	public ResponseEntity<List<Dispositivo>> getAllDispositivi() {
		List<Dispositivo> dispositivi = dispositivoService.getAllDispositivi();
		return ResponseEntity.ok(dispositivi);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable Long id) {
		Optional<Dispositivo> dispositivo = dispositivoService.getDispositivoById(id);
		if (dispositivo.isPresent()) {
			return ResponseEntity.ok(dispositivo.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}