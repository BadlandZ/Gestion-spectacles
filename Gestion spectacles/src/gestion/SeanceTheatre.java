package gestion;

/**
 * La classe SeanceTheatre permet la creation de Seance de Theatre. Elle hérite de la classe Seance et est caracterise par une SalleTheatre 
 * et un nombre de fauteuils vendus.
 * 
 * @author younes
 * @verion 1.0
 */

public class SeanceTheatre extends Seance {

	private SalleTheatre salleTheatre;
	private int nbFauteuilsVendus;

	public SeanceTheatre(int jour, Heure horaire, SalleTheatre salleTheatre) {
		super(jour, horaire);
		this.salleTheatre = salleTheatre;
		this.nbFauteuilsVendus = 0;
	}
	
	public SalleTheatre getSalle() { return this.salleTheatre; }

	public int nbFauteuilsDispo() {
		return this.salleTheatre.getNbFauteuils() - this.nbFauteuilsVendus;
	}

	public void vendrePlacesFauteuil(int nbre) {
		if (this.salleTheatre.getNbFauteuils() == this.nbFauteuilsVendus)
			throw new IllegalArgumentException("Capacite atteinte");
		this.nbFauteuilsVendus += nbre;
		
	}

	public int nbPlacesDispo() {
		return salleTheatre.getCapacite() - this.nbFauteuilsVendus;
	}

	public int totalVendu() {
		return nbFauteuilsVendus;
	}

	public double tauxRemplissage() {
		return ((nbFauteuilsVendus * salleTheatre.getCapacite()) / 100);
	}
	

}