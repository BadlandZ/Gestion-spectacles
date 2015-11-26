package gestion;

public class SalleTheatre extends Salle {
	
	private int nbFauteuils;
	private double prixFauteuils;
	
	public SalleTheatre(String nomSalle, double tarif, int nbPlacesStandard, int nbFauteuils, double prixFauteuils) {
		this.nomSalle = nomSalle;
		this.tarif = tarif;
		this.nbPlacesStandard = nbPlacesStandard;
		this.nbFauteuils = nbFauteuils;
		this.prixFauteuils = prixFauteuils;
		this.capacite = this.nbPlacesStandard + this.nbFauteuils;
	}
	
	public String toString() {
		return super.toString() + "Nombre de fauteuils: "+nbFauteuils+". Pris du fauteuil: "+prixFauteuils;
	}

}