package gestion;
/**
 * La classe SalleTheatre herite de la classe Salle et permet de creer des salles de theatre.
 * Elle est caracterisee par un nombre de fauteuils et un prix du fauteuil
 * 
 * @author younes
 * @version 1.0
 */

public class SalleTheatre extends Salle {

	private int nbFauteuils;
	private double prixFauteuils;

	public SalleTheatre(String nomSalle, double tarif, int nbPlacesStandard, int nbFauteuils, double prixFauteuils) {
		super(nomSalle, tarif, nbPlacesStandard);
		this.nbFauteuils = nbFauteuils;
		this.prixFauteuils = prixFauteuils;
		int capacite = this.getNbPlacesStandard() + nbFauteuils;
		this.setCapacite(capacite);
	}
	
	public int getNbFauteuils() { 
		return this.nbFauteuils; 
	}
	
	public boolean equals(SalleTheatre sT) {
		return (this.equals(sT) && (this.nbFauteuils == sT.nbFauteuils) && (this.prixFauteuils == sT.prixFauteuils));
	}

	public String toString() {
		return super.toString() + "Nombre de fauteuils: " + nbFauteuils + ". Prix du fauteuil: " + prixFauteuils + "€. ";
	}

}