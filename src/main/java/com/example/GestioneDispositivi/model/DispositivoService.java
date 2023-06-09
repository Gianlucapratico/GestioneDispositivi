package com.example.GestioneDispositivi.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {
	@Autowired
	private DispositivoRepository dispositivoRepository;

	public Dispositivo saveDispositivo(Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	public List<Dispositivo> getAllDispositivi() {
		return dispositivoRepository.findAll();
	}

	public Optional<Dispositivo> getDispositivoById(Long id) {
		return dispositivoRepository.findById(id);
	}

}