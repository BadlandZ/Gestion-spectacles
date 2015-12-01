package gestion;

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
	
	public int getNbFauteuils() { return this.nbFauteuils; }

	public String toString() {
		return super.toString() + "Nombre de fauteuils: " + nbFauteuils
				+ ". Prix du fauteuil: " + prixFauteuils + "€. ";
	}

}