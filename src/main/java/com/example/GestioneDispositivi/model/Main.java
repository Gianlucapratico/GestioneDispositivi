package com.example.GestioneDispositivi.model;

public class Main {
	public static void main(String[] args) {
		MyApp myApp = new MyApp();

		try {
			myApp.validateData("Some data");
			myApp.findItem(123);
			myApp.performAction(new Utente()); // Replace 'User' with 'Utente'
			myApp.connectToDatabase();
		} catch (ValidationException e) {
			// Handle validation exception
			System.out.println("Validation exception: " + e.getMessage());
		} catch (NotFoundException e) {
			// Handle not found exception
			System.out.println("Not found exception: " + e.getMessage());
		} catch (PermissionException e) {
			// Handle permission exception
			System.out.println("Permission exception: " + e.getMessage());
		} catch (DatabaseException e) {
			// Handle database exception
			System.out.println("Database exception: " + e.getMessage());
		}
	}
}
