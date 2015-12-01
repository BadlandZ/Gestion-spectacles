package gestion;

public abstract class Seance {

	private int jour;
	private Heure horaire;
	private int nbPlacesVenduesTN;

	public Seance(int jour, Heure horaire) {
		this.jour = jour;
		this.horaire = horaire;
		this.nbPlacesVenduesTN = 0;
	}

	public abstract int nbPlacesDispo();

	public abstract int totalVendu();

	public abstract double tauxRemplissage();

	public void vendrePlacesTN(int nbre) {
		this.nbPlacesVenduesTN += nbre;
	}

	public String toString() {
		return "Le: " + jour + ". A: " + horaire.toString() + ". "
				+ nbPlacesVenduesTN + " places vendues à TN. ";
	}

}
