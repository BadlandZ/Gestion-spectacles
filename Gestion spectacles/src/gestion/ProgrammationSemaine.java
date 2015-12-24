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
	
	public int getSemaine() {
		return this.semaine;
	}
	
	public void setSemaine(int semaine) {
		this.semaine = semaine;
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
	 * public Film trouverFilm(String titre) { 
	 * 		Iterator<Entry<Film, ProgrammationFilm>> it = listeProgFilm.entrySet().iterator();
	 * 		while(it.hasNext()) { 
	 * 			Map.Entry<Film, ProgrammationFilm> pair = (Map.Entry<Film, ProgrammationFilm>)it.next();
	 * 			if(pair.getKey().getTitre().equalsIgnoreCase(titre)) { 
	 * 				return pair.getKey(); 
	 * 			} 
	 * 		} 
	 * 		System.out.println("Le film n'existe pas."); return
	 * 		null; 
	 * }
	 */

	public Film trouverFilm(String titre) {
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

	public Set<SeanceCinema> consulterSeanceFilm(Film f, int jour) {
		Set<SeanceCinema> lesSeances = new HashSet<SeanceCinema>();
		Iterator<SeanceCinema> itSeanceCinema = listeProgFilm.get(f).getIterator();
		while (itSeanceCinema.hasNext()) {
			SeanceCinema suivant = itSeanceCinema.next();
			if (suivant.getJour() == jour)
				lesSeances.add(suivant);
		}
		return lesSeances;
	}

	public SeanceCinema consulterSeanceParInfos(Film f, int jour, Heure horaire) {
		Iterator<SeanceCinema> itSeanceCinema = listeProgFilm.get(f).getIterator();
		while (itSeanceCinema.hasNext()) {
			SeanceCinema suivant = itSeanceCinema.next();
			if(suivant.getJour() == jour && suivant.getHoraire().equals(horaire))
				return suivant;
		}
		System.out.println("Cette seance n'existe pas.");
		return null;
	}
	
	public void ajouterPieceTheatre(PieceTheatre pT) {
		ProgrammationTheatre progT = new ProgrammationTheatre();
		this.listeProgTheatre.put(pT, progT);
	}
	
	public boolean ajouterSeanceTheatre(PieceTheatre pT, SeanceTheatre sT) {
		return this.listeProgTheatre.get(pT).ajouterSeance(sT);
	}
	
	public Set<SeanceTheatre> consulterSeanceTheatre(SeanceTheatre sT) {
		Set<SeanceTheatre> lesSeances = new HashSet<SeanceTheatre>();
		Iterator<SeanceTheatre> itSeanceTheatre = this.listeProgTheatre.get(sT).getIterator();
		while (itSeanceTheatre.hasNext()) {
			SeanceTheatre suivant = itSeanceTheatre.next();
			lesSeances.add(suivant);
		}
		return lesSeances;
	}
	
	public void supprimerSeanceTheatre(PieceTheatre pT, SeanceTheatre sT) {
		this.listeProgTheatre.get(pT).supprimerSeance(sT);
	}
	
	
	public Iterator<PieceTheatre> piecesTheatres() {
		Set<PieceTheatre> lesPieces = this.listeProgTheatre.keySet();
		return lesPieces.iterator();
	}
	
	public PieceTheatre trouverPieceTheatre(String titre) {
		Iterator<PieceTheatre> it = piecesTheatres();
		while (it.hasNext()) {
			if(it.next().getTitre().equalsIgnoreCase(titre)) {
				return it.next();
			}
		}
		System.out.println("La piece de theatre n'existe pas.");
		return null;
	}
	
	public SeanceTheatre consulterSeanceParInfos(PieceTheatre pT, int jour) {
		Iterator<SeanceTheatre> itSeanceTheatre = listeProgTheatre.get(pT).getIterator();
		while(itSeanceTheatre.hasNext()) {
			SeanceTheatre suivant = itSeanceTheatre.next();
			if(suivant.getJour() == jour)
				return suivant;
		}
		System.out.println("Cette seance n'existe pas.");
		return null;
	}
	
	public double tauxRemplissagesFilm(Film f, int jour, Heure horaire) {
		return this.listeProgFilm.get(f).tauxRemplissage(jour, horaire);
	}
	
	public double chiffreAffaireFilms(Film f) {
		Iterator<Film> it = films();
		double cA = 0;
		while(it.hasNext()) {
			cA += this.listeProgFilm.get(it.next()).chiffreAffaire();
		}
		return cA;
	}
	
	public double tauxRemplissageTheatre(PieceTheatre pT, int jour) {
		return this.listeProgTheatre.get(pT).tauxRemplissage(jour);
	}
	
	public double chiffreAffairePiecesTheatres(PieceTheatre pT) {
		Iterator<PieceTheatre> it = piecesTheatres();
		double cA = 0;
		while(it.hasNext()) {
			cA += this.listeProgTheatre.get(it.next()).chiffreAffaire();
		}
		return cA;
	}
}
