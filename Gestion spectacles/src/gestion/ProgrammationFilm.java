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
			SeanceCinema sC = it.next();
			if ((sC.getJour() == jour) && (sC.getHoraire().equals(h))) {
				return sC;
			}
		}
		System.out.println("Aucune seance correspondant aux informations saisies");
		return null;
	}
	
	
	public int nbSeances() {
		return this.listeSeances.size();
	}
	
	
	public double tauxRemplissage(int jour, Heure h) {
		return rechercherSeance(jour, h).tauxRemplissage();
	}

	public double chiffreAffaire() {
		Iterator<SeanceCinema> it = getIterator();
		double chiffreAffaire = 0;
		while (it.hasNext()) {
			SeanceCinema sC = it.next();
			chiffreAffaire += sC.totalVendu() * sC.getSalle().getTarif();
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
