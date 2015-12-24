package gestion;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class EnsembleSallesTheatre {
	
	private List<SalleTheatre> parc;
	
	public EnsembleSallesTheatre() {
		this.parc = new ArrayList<SalleTheatre>();
	}
	
	public Iterator<SalleTheatre> sallesTheatres() {
		return this.parc.iterator();
	}
	
	public boolean ajouterSalle(SalleTheatre sT) {
		return this.parc.add(sT);
	}
	
	public SalleTheatre trouverSalleTheatre(String nom) {
		Iterator<SalleTheatre> it = sallesTheatres();
		while(it.hasNext()) {
			SalleTheatre suivant = it.next();
			if(suivant.getNomSalle().equalsIgnoreCase(nom)) {
				return suivant;
			}
		}
		System.out.println("La salle n'existe pas.");
		return null;
	}

}
