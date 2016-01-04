package gestion;

/**
 *  EnsembleSalle est la classe regroupant l'ensemble des Salles.
 *  
 *  Cette classe est caractérisé par l'information suivante: 
 *  
 *  	- Une Map contenant un couple <String, Salle> où le String represente le nom de la Salle
 *  
 *  @author damien
 *  @version 1.0
 */


import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EnsembleSalles {
	/**
	 * La map associant la valeur Salle à son nom String.
	 */
	private Map<String, Salle> parc;
	
	
	/**
	 * Constructeur sans parametre initialise la Map en HashMap.
	 */
	public EnsembleSalles() {
		this.parc = new HashMap<String, Salle>();
	}
	
	/**
	 * salles permet de recuperer un iterateur sur les noms des Salles de notre parc
	 * @return un Iterator<String> afin de parcourir les noms des Salles
	 */
	public Iterator<String> salles() {
		Set<String> salles = this.parc.keySet();
		return salles.iterator();
	}
	
	/**
	 * Permet l'association d'une s Salle et son String nom et de l'ajouter au parc
	 * @param s Salle que l'on souhaite ajouter au parc
	 * @return true si l'ajout a bien ete effectue, false sinon
	 */
	public boolean ajouterSalle(Salle s) {
		if(!parc.containsKey(s.getNomSalle())) {
			this.parc.put(s.getNomSalle(), s);
			return true;
		}
		return false;
	}
	
	/**
	 * Permet de trouver une Salle en fonction du fourni sous forme de String
	 * @param nom correspond au nom de la salle sous forme de chaine de caractere
	 * @return la salle associee au nom passe en parametre
	 */
	public Salle trouverSalle(String nom) {
		return this.parc.get(nom);
	}
	
	/**
	 * Permet de savoir si une salle associee au nom passe en parametre se trouve dans le parc
	 * @param nom nom de la salle sous forme de String
	 * @return true si la salle est bien dans le parc, false sinon.
	 */
	public boolean contientSalle(String nom) {
		Set<String> salles = parc.keySet();
		return salles.contains(nom);
	}
	
	/**
	 * Retourne les informations de l'ensemble de Salles sous forme de chaine de caracteres.
	 * @return une chaine de caractere contenant les informations de l'ensemble des salles
	 */
	public String toString() {
		String s = "---- Ensemble des salles ----";
		Set<Map.Entry<String, Salle>> lesEntrees= parc.entrySet();
        Iterator<Map.Entry<String, Salle>> it = lesEntrees.iterator();
        while (it.hasNext()){
            Map.Entry<String, Salle> uneEntree = it.next();
            s += "\n" + uneEntree.getValue().toString();
        }        
        return s;
    }	
}