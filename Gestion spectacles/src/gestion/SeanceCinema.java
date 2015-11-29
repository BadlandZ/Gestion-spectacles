package gestion;

public class SeanceCinema extends Seance{
	
	private Salle salle;
	private int nbPlacesVenduesTR;
	public SeanceCinema(int jour, Heure horaire,  Salle salle) {
		super(jour, horaire);
	}
	
	
	public double tauxRemplissage() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int nbPlacesDispo() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int totalVendu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
