package gestion;

/**
 *  EnsembleSalleTheatre est la classe regroupant l'ensemble des Salles.
 *  
 *  Cette classe est caractérisé par l'information suivante: 
 *  
 *  	- Une Map contenant un couple <String, SalleTheatre> où le String represente le nom de la SalleTheatre
 *  
 *  @author damien
 *  @version 1.0
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EnsembleSallesTheatre {
	/**
	 * La map associant la valeur SalleTheatre à son nom String.
	 */
	private Map<String, SalleTheatre> parc;
	
	/**
	 * Constructeur sans parametre initialise la Map en HashMap.
	 */
	public EnsembleSallesTheatre() {
		this.parc = new HashMap<String, SalleTheatre>();
	}
	
	/**
	 * sallesTheatre permet de recuperer un iterateur sur les noms des Salles de notre parc
	 * @return un Iterator<String> afin de parcourir les noms des SallesTheatre
	 */
	public Iterator<String> sallesTheatre() {
		Set<String> salles = this.parc.keySet();
		return salles.iterator();
	}
	
	/**
	 * Permet l'association d'une s SalleTheatre et son String nom et de l'ajouter au parc
	 * @param s SalleTheatre que l'on souhaite ajouter au parc
	 * @return true si l'ajout a bien ete effectue, false sinon
	 */
	public boolean ajouterSalle(SalleTheatre sT) {
		if(!parc.containsKey(sT.getNomSalle())) {
			this.parc.put(sT.getNomSalle(), sT);
			return true;
		}
		return false;
	}
	
	/**
	 * Permet de trouver une SalleTheatre en fonction du nom fourni sous forme de String
	 * @param nom correspond au nom de la salleTheatre sous forme de chaine de caractere
	 * @return la salleTheatre associee au nom passe en parametre
	 */
	public SalleTheatre trouverSalle(String nom) {
		return this.parc.get(nom);
	}
	
	/**
	 * Permet de savoir si une salleTheatre associee au nom passe en parametre se trouve dans le parc
	 * @param nom nom de la salle sous forme de String
	 * @return true si la salle est bien dans le parc, false sinon.
	 */
	public boolean contientSalle(String nom) {
		Set<String> salles = parc.keySet();
		return salles.contains(nom);
	}
	
	/**
	 * Retourne les informations de l'ensemble de SalleTheatre sous forme de chaine de caracteres.
	 * @return une chaine de caractere contenant les informations de l'ensemble des sallesTheatre
	 */
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
