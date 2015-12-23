package gestion;

public abstract class Seance implements Comparable<Seance> {

	private int jour;
	private Heure horaire;
	private int nbPlacesVenduesTN;

	public Seance(int jour, Heure horaire) {
		this.jour = jour;
		this.horaire = horaire;
		this.nbPlacesVenduesTN = 0;
	}

	public int getJour() {
		return this.jour;
	}

	public Heure getHoraire() {
		return this.horaire;
	}

	public abstract int nbPlacesDispo();

	public abstract int totalVendu();

	public abstract double tauxRemplissage();

	public void vendrePlacesTN(int nbre) {
		this.nbPlacesVenduesTN += nbre;
	}

	public int compareTo(Seance s) {
		if (this.getJour() > s.getJour()) {
			if (this.getHoraire().compareTo(s.getHoraire()) < 0) {
				return -1;
			}
		}
		if (this.getJour() < s.getJour()) {
			return -1;
		}
		if (this.getJour() == s.getJour()) {
			if (this.getHoraire().compareTo(s.getHoraire()) < 0)
				return -1;
			else if (this.getHoraire().compareTo(s.getHoraire()) > 0)
				return 1;
		}
		return 0;
	}

	public boolean equals(Seance s) {
		return ((this.jour == s.jour) && (this.horaire.equals(s.horaire)));
	}

	public String toString() {
		return "Le: " + jour + ". A: " + horaire.toString() + ". "
				+ nbPlacesVenduesTN + " places vendues à TN. ";
	}

	public Object getSalle() {
		// TODO Auto-generated method stub
		return null;
	}
}