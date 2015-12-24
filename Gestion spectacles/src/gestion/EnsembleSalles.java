package gestion;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class EnsembleSalles {
	
	private List<Salle> parc;
	
	public EnsembleSalles() {
		this.parc = new ArrayList<Salle>();
	}
	
	public Iterator<Salle> salles() {
		return this.parc.iterator();
	}
	
	public boolean ajouterSalle(Salle s) {
		return this.parc.add(s);
	}
	
	public Salle trouverSalle(String nom) {
		Iterator<Salle> it = salles();
		while(it.hasNext()) {
			Salle suivant = it.next();
			if(suivant.getNomSalle().equalsIgnoreCase(nom)) {
				return suivant;
			}
		}
		System.out.println("La salle n'existe pas.");
		return null;
	}
}
