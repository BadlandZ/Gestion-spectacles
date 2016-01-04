package gestion;
/**
 * La classe ProgrammationTheatre gere un ensemble de SeanceTheatre afin d'organiser ces dernieres sous forme de programmations.
 * Elle est caracterise par un attribut listeSeances de la forme TreeSet afin de trier automatiquement les Seances ajoutees.
 * 
 * @author younes
 * @version 1.0
 */

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class ProgrammationTheatre {
	/**
	 * L'attribut listeSeances est une TreeSet contenant l'ensemble des SeanceTheatre d'un film.
	 */
	private Set<SeanceTheatre> listeSeances;
	/**
	 * Le constructeur sans parametres de la classe permet d'initialiser listeSeances en TreeSet
	 */
	public ProgrammationTheatre() {
		this.listeSeances = new TreeSet<SeanceTheatre>();
	}
	/**
	 * Retourne le nombre de SeanceTheatre
	 * @return SeanceCinema sous forme d'entier
	 */
	public int nbSeances() {
		return this.listeSeances.size();
	}

	/**
	 * Permet l'ajout d'une SeanceTheatre dans la listeSeances
	 * @param sT la SeanceCinema que l'on souhaite ajouter
	 * @return true si l'ajout a bien ete effectue et false sinon
	 */
	public boolean ajouterSeance(SeanceTheatre sT) {
		return this.listeSeances.add(sT);
	}

	/**
	 * Supprime la SeanceTheatre passee en parametre
	 * @param sT la SeanceTheatre que l'on souhaite supprimer
	 */
	public void supprimerSeance(SeanceTheatre sT) {
		this.listeSeances.remove(sT);
	}
	/**
	 * Permet d'acceder a un iterateur sur listeSeance
	 * @return Iterator<SeanceTheatre>
	 */
	public Iterator<SeanceTheatre> getIterator() {
		return this.listeSeances.iterator();
	}
	/**
	 * Permet de rechercher une SeanceTheatre en utilisant les informations jour et heure de la seance en parcourant 
	 * la listeSeances a l'aide d'un iterateur
	 * @param jour le jour de la seance
	 * @param h l'heure de la seance
	 * @return la SeanceTheatre qui correspond aux informations saisies
	 */
	public SeanceTheatre rechercherSeance(int jour, Heure horaire) {
		Iterator<SeanceTheatre> it = listeSeances.iterator();
		while (it.hasNext()) {
			SeanceTheatre sT = it.next();
			if ((sT.getJour() == jour) && (sT.getHoraire().equals(horaire))) {
				return it.next();
			}
		}
		System.out.println("Aucune seance ne correspond aux informations saisies");
		return null;
	}
	/**
	 * Retourne le taux de remplissage d'une seance en fonction des informations saisies en parametre
	 * @param jour le jour de la seance
	 * @param h l'heure de la seance
	 * @return le taux de remplissage de la seance
	 */
	public double tauxRemplissage(int jour, Heure horaire) {
		return rechercherSeance(jour, horaire).tauxRemplissage();
	}
	/**
	 * Retourne le chiffre d'affaire total de la listeSeance
	 */
	public double chiffreAffaire() {
		Iterator<SeanceTheatre> it = getIterator();
		double chiffreAffaire = 0;
		while (it.hasNext()) {
			chiffreAffaire += it.next().totalVendu()
					* it.next().getSalle().getTarif();
		}
		return chiffreAffaire;
	}
	/**
	 * Retourne les informations de la listeSeances sous forme de chaine de caracteres
	 */
	public String toString() {
		String str = "";
		for (SeanceTheatre element : listeSeances) {
			str += element.toString() + "\n";
		}
		return str;
	}

}
