package gestion;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;

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

	public ProgrammationFilm consulterSeanceCinema(Film f) {
		return listeProgFilm.get(f);
	}

	public void supprimerSeanceCinema(Film f, SeanceCinema sC) {
		listeProgFilm.get(f).supprimerSeance(sC);
	}

	public Iterator<Film> films() {
		Set<Film> film = listeProgFilm.keySet();
		return film.iterator();
	}

	// C'est moche et ça fait peur. A ignorer ... Pour l'instant.
	/*
	 * public Film trouverFilm(String titre) { Iterator<Entry<Film,
	 * ProgrammationFilm>> it = listeProgFilm.entrySet().iterator();
	 * while(it.hasNext()) { Map.Entry<Film, ProgrammationFilm> pair =
	 * (Map.Entry<Film, ProgrammationFilm>)it.next();
	 * if(pair.getKey().getTitre().equalsIgnoreCase(titre)) { return
	 * pair.getKey(); } } System.out.println("Le film n'existe pas."); return
	 * null; }
	 */

	public Film trouveFilm(String titre) {
		Iterator<Film> it = films();
		while (it.hasNext()) {
			if (it.next().getTitre().equalsIgnoreCase(titre)) {
				return it.next();
			}
		}
		System.out.println("Le film n'existe pas.");
		return null;
	}

	public Set<Film> consulterFilms() {
		return listeProgFilm.keySet();
	}

	public Set<SeanceCinema> consulterSeance(Film f, int jour) {
		Set<SeanceCinema> lesSeances = new HashSet<SeanceCinema>();
		Iterator<SeanceCinema> itSeanceCinema = listeProgFilm.get(f).getIterator();
		while (itSeanceCinema.hasNext()) {
			SeanceCinema suivant = itSeanceCinema.next();
			if (suivant.getJour() == jour)
				lesSeances.add(suivant);
		}
		return lesSeances;
	}
}
