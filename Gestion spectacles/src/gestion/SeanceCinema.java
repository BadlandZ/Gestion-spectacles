package gestion;

public class SeanceCinema extends Seance {

	private Salle salle;
	private int nbPlacesVenduesTR;

	public SeanceCinema(int jour, Heure horaire, Salle salle) {
		super(jour, horaire);
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

	public String toString() {
		return super.toString() + nbPlacesVenduesTR
				+ " places vendues à TR. Salle: " + salle.toString();
	}

}