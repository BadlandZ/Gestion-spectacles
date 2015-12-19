package gestion;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ProgrammationFilm {

	private Set<SeanceCinema> listeSeances;

	public ProgrammationFilm() {
		listeSeances = new TreeSet<SeanceCinema>();
	}

	public boolean ajouterSeance(SeanceCinema sC) {
		return listeSeances.add(sC);
	}

	public void supprimerSeance(SeanceCinema sC) {
		listeSeances.remove(sC);
	}

	public Iterator<SeanceCinema> getIterator() {
		return listeSeances.iterator();
	}

	public SeanceCinema rechercherSeance(int jour, Heure h) {
		Iterator<SeanceCinema> it = listeSeances.iterator();
		while (it.hasNext()) {
			if ((it.next().getJour() == jour)
					&& (it.next().getHoraire().equals(h))) {
				return it.next();
			}
		}
		System.out.println("Aucune seance correspondant aux informations saisies");
		return null;
	}

	public double tauxRemplissage(int jour, Heure h) {
		return rechercherSeance(jour, h).tauxRemplissage();
	}

	public double chiffreAffaire() {
		Iterator<SeanceCinema> it = getIterator();
		double chiffreAffaire = 0;
		while (it.hasNext()) {
			chiffreAffaire += it.next().totalVendu() * it.next().getSalle().getTarif();
		}
		return chiffreAffaire;
	}

	public String toString() {
		String str = "";
		for (SeanceCinema element : listeSeances) {
			str += element.toString() + "\n";
		}
		return str;
	}

}