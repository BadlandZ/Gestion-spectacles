package gestion;

/**
 * La classe SeanceCinema permet la creation de Seance de Cinema et hérite de la classe Seance. Elle est caracterise par
 * une salle et un nombre de places vendues a tarif reduit.
 * 
 * @author younes
 * @version 1.0
 *
 */

public class SeanceCinema extends Seance {

	private Salle salle;
	private int nbPlacesVenduesTR;

	public SeanceCinema(int jour, Heure horaire, Salle salle) {
		super(jour, horaire);
		this.salle = salle;
		this.nbPlacesVenduesTR = 0;
	}

	public void vendrePlacesTR(int nbre) {
		if (this.nbPlacesVenduesTR == this.salle.getCapacite())
			throw new IllegalArgumentException("Capacite atteinte.");
		this.nbPlacesVenduesTR += nbre;
	}

	public double tauxRemplissage() {
		return ((this.nbPlacesVenduesTR * salle.getCapacite()) / 100);
	}

	public int nbPlacesDispo() {
		return this.salle.getCapacite() - this.nbPlacesVenduesTR;
	}

	public int totalVendu() {
		return this.nbPlacesVenduesTR;
	}
	
	public Salle getSalle() { return this.salle; }
	
	public boolean equals(SeanceCinema sC) {
		return (this.equals(sC)) && (this.salle.equals(sC.salle));
	}

	public String toString() {
		return super.toString() + nbPlacesVenduesTR + " places vendues à TR. " + salle.toString();
	}

}