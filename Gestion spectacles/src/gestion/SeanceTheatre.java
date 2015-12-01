package gestion;

public class SeanceTheatre extends Seance {

	private SalleTheatre salleTheatre;
	private int nbFauteuilsVendus;

	public SeanceTheatre(int jour, Heure horaire, SalleTheatre salleTheatre) {
		super(jour, horaire);
		this.salleTheatre = salleTheatre;
		this.nbFauteuilsVendus = 0;
	}

	public int nbFauteuilsDispo() {
		return this.salleTheatre.getNbFauteuils() - this.nbFauteuilsVendus;
	}

	public void vendrePlacesFauteuil(int nbre) {
		if (this.salleTheatre.getNbFauteuils() == this.nbFauteuilsVendus)
			throw new IllegalArgumentException("Capacite atteinte");
		this.nbFauteuilsVendus += nbre;
	}

	public int nbPlacesDispo() {
		return salleTheatre.getCapacite() - nbFauteuilsVendus;
	}

	public int totalVendu() {
		return nbFauteuilsVendus;
	}

	public double tauxRemplissage() {
		return ((nbFauteuilsVendus * salleTheatre.getCapacite()) / 100);
	}

}