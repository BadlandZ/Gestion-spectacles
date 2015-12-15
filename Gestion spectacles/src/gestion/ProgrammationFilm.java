package gestion;

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
	
	public String toString() {
		String str = "";
		for(SeanceCinema element: listeSeances) {
			str +=  element.toString() + "\n";
		}
		return str;
	}

}
