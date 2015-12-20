package gestion;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class ProgrammationSemaine {

	private int semaine;
	private Map<Film, ProgrammationFilm> listeProgFilm;
	private Map<PieceTheatre, ProgrammationTheatre> listeProgTheatre;

	public ProgrammationSemaine(int semaine) {
		this.semaine = semaine;
		this.listeProgFilm = new HashMap<Film, ProgrammationFilm>();
		this.listeProgTheatre = new HashMap<PieceTheatre, ProgrammationTheatre>();
	}
	
	public void ajouterFilm(Film f) {
		ProgrammationFilm pF = new ProgrammationFilm();
		this.listeProgFilm.put(f, pF);
	}
	
	public boolean ajouterSeanceCinema(Film f, SeanceCinema s) {
		return this.listeProgFilm.get(f).ajouterSeance(s);
	}
	
	public String consulterSeanceCinema(Film f) {
		return listeProgFilm.get(f).toString();
	}
	
	public void supprimerSeanceCinema(Film f, SeanceCinema sC) {
		listeProgFilm.get(f).supprimerSeance(sC);
	}
	
}
