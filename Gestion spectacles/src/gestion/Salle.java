package gestion;

public class Salle {
	
	protected String nomSalle;
	protected int capacite;
	protected double tarif;
	protected int nbPlacesStandard;
	
	public String toString() {
		return "Salle: "+nomSalle+". Capacite: "+capacite+". Tarif d'une place au balcon (place standard): "+tarif;
	}
	
}