package gestion;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EnsembleSallesTheatre {
	
	private Map<String, SalleTheatre> parc;
	
	public EnsembleSallesTheatre() {
		this.parc = new HashMap<String, SalleTheatre>();
	}
	
	public Iterator<String> sallesTheatre() {
		Set<String> salles = this.parc.keySet();
		return salles.iterator();
	}
	
	public boolean ajouterSalle(SalleTheatre sT) {
		if(!parc.containsKey(sT.getNomSalle())) {
			this.parc.put(sT.getNomSalle(), sT);
			return true;
		}
		return false;
	}
	
	public Salle trouverSalle(String nom) {
		return this.parc.get(nom);
	}
	
	public String toString() {
		String s = "---- Ensemble des salles de theatre ----";
		Set<Map.Entry<String, SalleTheatre>> lesEntrees= parc.entrySet();
        Iterator<Map.Entry<String, SalleTheatre>> it = lesEntrees.iterator();
        while (it.hasNext()){
            Map.Entry<String, SalleTheatre> uneEntree = it.next();
            s += "\n" + uneEntree.getValue().toString();
        }        
        return s;
	}
	
}
