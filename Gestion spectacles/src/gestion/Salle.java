package gestion;

/**
 * La classe Salle permet de creer les salles de spectacles.
 * Elles sont caracterises par un nom, une capacite un tarif et un nombre de places
 * 
 * @author younes
 * @version 1.0
 */

import java.util.Objects;

public class Salle {

	private String nomSalle;
	private int capacite;
	private double tarif;
	private int nbPlacesStandard;

	public Salle(String nomSalle, double tarif, int nbPlacesStandard) {
		this.nomSalle = nomSalle;
		this.capacite = nbPlacesStandard;
		this.tarif = tarif;
		this.nbPlacesStandard = nbPlacesStandard;
	}
	
	public String getNomSalle() {
		return this.nomSalle;
	}

	public int getNbPlacesStandard() {
		return this.nbPlacesStandard;
	}

	public int getCapacite() {
		return this.capacite;
	}
	
	public double getTarif() {
		return this.tarif;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public boolean equals(Salle s) {
		return (this.nomSalle.equalsIgnoreCase(s.nomSalle) && (this.capacite == s.capacite) && (this.tarif == s.tarif) && (this.nbPlacesStandard == s.nbPlacesStandard));
	}
	
	public int hashCode() {
		return Objects.hash(nomSalle, capacite, tarif, nbPlacesStandard);
	}

	public String toString() {
		return "Salle: " + nomSalle + ". Capacite: " + capacite + ". Tarif d'une place au balcon (place standard): " + tarif+ "€. ";
	}

}