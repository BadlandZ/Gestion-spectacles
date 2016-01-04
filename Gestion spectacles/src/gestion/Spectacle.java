package gestion;

/**
 * Cette classe permet de cree un spectacle. Elle est caractérisé par les informations suivantes:
 * 	- Son titre, qui caractérise le titre du spectacle
 * 	- Une liste d'interpretes sous forme de chaines de caracteres.
 * 
 * @author cedric
 * @version 1.0
 */

import java.util.List;

public abstract class Spectacle {
	
	/**
	 * L'attribut titre décrit le titre donne au spectacle
	 */
	private String titre;
	/**
	 * L'attribut interpretes est une liste contenant le nom des interpretes du film
	 */
	private List<String> interpretes;
	
	/**
	 * Le constructeur initialise les attributs titre et interpretes en fonction de leurs parametres respectifs
	 * @param titre decrit le titre  donne au spectacle
	 * @param interpretes decrit la liste des interpretes du spectacle
	 */
	public Spectacle(String titre, List<String> interpretes) {
		this.titre = titre;
		this.interpretes = interpretes;
	}
	
	/**
	 * Retourne les informations du spectacle sous forme de chaine de caracteres
	 */
	public String toString() {
		return "Titre: "+titre+"\n Liste des interpretes: "+interpretes.toString();
	}
	
	/**
	 * Retourne le titre du spectacle
	 * @return le titre du spectacle
	 */
	public String getTitre() {
		return titre;
	}
	
	/**
	 * Retourne la liste des interpretes du film
	 * @return la liste des interpretes du film sous forme de liste de chaine de caractes
	 */
	public List<String> getInterpretes() {
		return interpretes;
	}
 
}