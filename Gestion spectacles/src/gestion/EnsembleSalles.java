package gestion;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Objects;
import java.util.Set;

public class EnsembleSalles {
	
	private Map<String, Salle> parc;
	
	public EnsembleSalles() {
		this.parc = new HashMap<String, Salle>();
	}
	
	public Iterator<String> salles() {
		Set<String> salles = this.parc.keySet();
		return salles.iterator();
	}
	
	public boolean ajouterSalle(Salle s) {
		if(!parc.containsKey(s.getNomSalle())) {
			this.parc.put(s.getNomSalle(), s);
			return true;
		}
		return false;
	}
	
	public Salle trouverSalle(String nom) {
		return this.parc.get(nom);
	}
	
	public String toString() {
		String s = "---- Ensemble des salles ----";
		Set<Map.Entry<String, Salle>> lesEntrees= parc.entrySet();
        Iterator<Map.Entry<String, Salle>> it = lesEntrees.iterator();
        while (it.hasNext()){
            Map.Entry<String, Salle> uneEntree = it.next();
            s += "\n" + uneEntree.getValue().toString()+ "\n";
            //Personne p = uneEntree.getKey();
            //IListeNumTel liste =  uneEntree.getValue();
            //s = s + p + " " + liste + "\n";
        }
        //return annuaire.toString();
        return s;
    }	
}