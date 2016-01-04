package gestion;

/**
 * La classe ProgrammationFilm gere un ensemble de SeanceCinema afin d'organiser ces dernieres sous forme de programmations.
 * Elle est caracterise par un attribut listeSeances de la forme TreeSet afin de trier automatiquement les Seances ajoutees.
 * 
 * @author younes
 * @version 1.0
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProgrammationFilm {
	/**
	 * L'attribut listeSeances est une TreeSet contenant l'ensemble des SeanceCinema d'un film.
	 */
	private Set<SeanceCinema> listeSeances;
	
	/**
	 * Le constructeur sans parametres de la classe permet d'initialiser listeSeances en TreeSet
	 */
	public ProgrammationFilm() {
		listeSeances = new TreeSet<SeanceCinema>();
	}
	
	/**
	 * Permet l'ajout d'une SeanceCinema dans la listeSeances
	 * @param sC la SeanceCinema que l'on souhaite ajouter
	 * @return true si l'ajout a bien ete effectue et false sinon
	 */
	public boolean ajouterSeance(SeanceCinema sC) {
		return listeSeances.add(sC);
	}
	
	/**
	 * Supprime la SeanceCinema passee en parametre
	 * @param sC la SeanceCinema que l'on souhaite supprimer
	 */
	public void supprimerSeance(SeanceCinema sC) {
		listeSeances.remove(sC);
	}
	
	/**
	 * Permet d'acceder a un iterateur sur listeSeance
	 * @return Iterator<SeanceCinema>
	 */
	public Iterator<SeanceCinema> getIterator() {
		return listeSeances.iterator();
	}
	
	/**
	 * Permet de rechercher une SeanceCinema en utilisant les informations jour et heure de la seance en parcourant 
	 * la listeSeances a l'aide d'un iterateur
	 * @param jour le jour de la seance
	 * @param h l'heure de la seance
	 * @return la SeanceCinema qui correspond aux informations saisies
	 */
	public SeanceCinema rechercherSeance(int jour, Heure h) {
		Iterator<SeanceCinema> it = listeSeances.iterator();
		while (it.hasNext()) {
			SeanceCinema sC = it.next();
			if ((sC.getJour() == jour) && (sC.getHoraire().equals(h))) {
				return sC;
			}
		}
		System.out.println("Aucune seance correspondant aux informations saisies");
		return null;
	}
	
	
	/**
	 * Retourne le nombre de SeanceCinema
	 * @return SeanceCinema sous forme d'entier
	 */
	public int nbSeances() {
		return this.listeSeances.size();
	}
	
	/**
	 * Retourne le taux de remplissage d'une seance en fonction des informations saisies en parametre
	 * @param jour le jour de la seance
	 * @param h l'heure de la seance
	 * @return le taux de remplissage de la seance
	 */
	public double tauxRemplissage(int jour, Heure h) {
		return rechercherSeance(jour, h).tauxRemplissage();
	}
	
	/**
	 * Retourne le chiffre d'affaire total de la listeSeance
	 */
	public double chiffreAffaire() {
		Iterator<SeanceCinema> it = getIterator();
		double chiffreAffaire = 0;
		while (it.hasNext()) {
			SeanceCinema sC = it.next();
			chiffreAffaire += sC.totalVendu() * sC.getSalle().getTarif();
		}
		return chiffreAffaire;
	}
	
	/**
	 * Retourne les informations de la listeSeances sous forme de chaine de caracteres
	 */
	public String toString() {
		String str = "";
		for (SeanceCinema element : listeSeances) {
			str += element.toString() + "\n";
		}
		return str;
	}

}
