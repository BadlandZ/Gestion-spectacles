package gestion;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class ProgrammationTheatre {

	private Set<SeanceTheatre> listeSeances;

	public ProgrammationTheatre() {
		this.listeSeances = new TreeSet<SeanceTheatre>();
	}

	public boolean ajouterSeance(SeanceTheatre sT) {
		return this.listeSeances.add(sT);
	}

	public void supprimerSeance(SeanceTheatre sT) {
		this.listeSeances.remove(sT);
	}

	public Iterator<SeanceTheatre> getIterator() {
		return this.listeSeances.iterator();
	}

	public SeanceTheatre rechercherSeance(int jour) {
		Iterator<SeanceTheatre> it = listeSeances.iterator();
		while (it.hasNext()) {
			if ((it.next().getJour() == jour)) {
				return it.next();
			}
		}
		System.out.println("Aucune seance ne correspond aux informations saisies");
		return null;
	}

	public double tauxRemplissage(int jour) {
		return rechercherSeance(jour).tauxRemplissage();
	}

	public double chiffreAffaire() {
		Iterator<SeanceTheatre> it = getIterator();
		double chiffreAffaire = 0;
		while (it.hasNext()) {
			chiffreAffaire += it.next().totalVendu()
					* it.next().getSalle().getTarif();
		}
		return chiffreAffaire;
	}

	public String toString() {
		String str = "";
		for (SeanceTheatre element : listeSeances) {
			str += element.toString() + "\n";
		}
		return str;
	}

}
