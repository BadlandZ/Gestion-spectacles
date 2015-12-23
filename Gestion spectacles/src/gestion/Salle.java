package gestion;

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
		return this.nomSalle.equals(s.nomSalle);
	}

	public String toString() {
		return "Salle: " + nomSalle + ". Capacite: " + capacite
				+ ". Tarif d'une place au balcon (place standard): " + tarif+ "€. ";
	}

}