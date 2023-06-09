package com.example.GestioneDispositivi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String nome;
	private String cognome;
	private String email;

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasPermission(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
