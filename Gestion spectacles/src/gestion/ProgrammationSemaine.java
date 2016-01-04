package gestion;

/**
 * La classe ProgrammationSemaine permet d'associer des Films ainsi que des PieceTheatre respectivement a des ProgrammationFilm ProgrammationTheatre
 * Elle est caracterise par une semaine, ainsi que deux HashMap, une pour les film et l'autre pour les theatres.
 * 
 * @author younes
 * @version 1.0
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
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
	
	public Map<Film, ProgrammationFilm> getListeProgFilm() {
		return listeProgFilm;
	}
	
	public Map<PieceTheatre, ProgrammationTheatre> getListeProgTheatre() {
		return listeProgTheatre;
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
	
	/**
	 * Permet de trouver un film en fonction de son nom, ce dernier est sous forme de String
	 * On parcourt la liste des programmations des films et l'on compare le nom avec chaque titre de film afin de trouver le bon
	 * @param titre le nom du film sous forme de String
	 * @return le film qui correspond au nom, et null si le film n'existe pas.
	 */
	public Film trouverFilm(String titre) {
		Iterator<Film> it = this.listeProgFilm.keySet().iterator();
		while (it.hasNext()) {
			Film f = it.next();
			if (f.getTitre().equalsIgnoreCase(titre)) {
				return f;
			}
		}
		System.out.println("Le film n'existe pas.");
		return null;
	}

	public String consulterFilms() {
		String str = "";
		for(Entry<Film, ProgrammationFilm> entry: listeProgFilm.entrySet()) {
			str += entry.getKey().getTitre();
		}
		return str;
	}
	
	/**
	 * Permet de retourner l'ensemble de SeanceCinema qui correspondent aux informations passees en parametre
	 * On parcout la liste de programmation des films a l'aide d'un iterateur
	 * 
	 * @param f le film dont on souhaite chercher les seances
	 * @param jour le jour des seances que l'on souhaite trouver
	 * @return l'ensemble des seance caracterisees par les informations
	 */
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
	
	/**
	 * Retourne la SeanceCinema qui correspond aux informations saisies
	 * @param f le film associe a la seance recherchee
	 * @param jour le jour de la seance recherchee
	 * @param horaire l'horaire de la seance recherchee
	 * @return la Seance trouvee ou null si la seance n'existe pas
	 */
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
	
	/**
	 * Permet de retourner l'ensemble de SeanceTheatre qui correspondend a une PieceTheatre
	 * On parcout la liste de programmation des pieces a l'aide d'un iterateur
	 * 
	 * @param pT la piece dont on souhaite chercher les seances
	 * @return l'ensemble des seance caracterisees par les informations
	 */
	public Set<SeanceTheatre> consulterSeanceTheatre(PieceTheatre pT) {
		Set<SeanceTheatre> lesSeances = new HashSet<SeanceTheatre>();
		Iterator<SeanceTheatre> itSeanceTheatre = this.listeProgTheatre.get(pT).getIterator();
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
	
	/**
	 * Permet de trouver la piece en fonction de son nom, ce dernier est sous forme de String
	 * On parcourt la liste des programmations des pieces et l'on compare le nom avec chaque titre de piece afin de trouver la bonne
	 * @param titre le nom de la piece sous forme de String
	 * @return la piece qui correspond au nom, et null si la piece n'existe pas.
	 */
	public PieceTheatre trouverPieceTheatre(String titre) {
		Iterator<PieceTheatre> it = piecesTheatres();
		while (it.hasNext()) {
			PieceTheatre p = it.next();
			if(p.getTitre().equalsIgnoreCase(titre)) {
				return p;
			}
		}
		System.out.println("La piece de theatre n'existe pas.");
		return null;
	}
	
	/**
	 * Retourne la SeanceTheatre qui correspond aux informations saisies
	 * @param pT la piece associee a la seance recherchee
	 * @param jour le jour de la seance recherchee
	 * @param horaire l'horaire de la seance recherchee
	 * @return la Seance trouvee ou null si la seance n'existe pas
	 */
	public SeanceTheatre consulterSeanceParInfos(PieceTheatre pT, int jour, Heure horaire) {
		Iterator<SeanceTheatre> itSeanceTheatre = listeProgTheatre.get(pT).getIterator();
		while(itSeanceTheatre.hasNext()) {
			SeanceTheatre suivant = itSeanceTheatre.next();
			if(suivant.getJour() == jour && suivant.getHoraire().equals(horaire))
				return suivant;
		}
		System.out.println("Cette seance n'existe pas.");
		return null;
	}
	
	public String consulterPieces() {
		String str = "";
		for(Entry<PieceTheatre, ProgrammationTheatre> entry : listeProgTheatre.entrySet()) {
			str += entry.getKey().getTitre();
		}
		return str;
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
	
	public double tauxRemplissageTheatre(PieceTheatre pT, int jour, Heure horaire) {
		return this.listeProgTheatre.get(pT).tauxRemplissage(jour, horaire);
	}
	
	public double chiffreAffairePiecesTheatres(PieceTheatre pT) {
		Iterator<PieceTheatre> it = piecesTheatres();
		double cA = 0;
		while(it.hasNext()) {
			cA += this.listeProgTheatre.get(it.next()).chiffreAffaire();
		}
		return cA;
	}
	
	public String toStringFilms() {
		String str = "";
		int cpt = 0;
		for(Entry<Film, ProgrammationFilm> entry : listeProgFilm.entrySet()) {
			str += cpt+" - "+entry.getKey() + "\n";
			cpt++;
		}
		return str;
	}
	
	public String toStringPieces() {
		String str = "";
		for(Entry<PieceTheatre, ProgrammationTheatre> entry: listeProgTheatre.entrySet()) {
			str += " - "+entry.getKey() + "\n";
		}
		return str;
	}
}
