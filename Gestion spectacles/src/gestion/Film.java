package gestion;

/**
 * La classe film est un spectacle. Ainsi elle herite de la classe spectacle.
 * Elle est caractérisé par :
 * 	- Un realisateur
 * 	- Une duree
 * 
 * @cedric
 * @version 1.0
 */

import java.util.List;

public class Film extends Spectacle{
	/**
	 * Le nom du realisateur
	 */
	private String realisateur;
	/**
	 * La duree du film 
	 */
	private Heure duree;
	
	/**
	 * Le constructeur initialise les attributs herites a l'aide de la methode super
	 * @param titre le titre du film sous forme de String
	 * @param interpretes la liste des interpretes sous forme de liste de String
	 * @param realisateur le nom du realisateur sous forme de String
	 * @param duree la duree du film sous forme d'Heure
	 */
	public Film(String titre, List<String> interpretes, String realisateur, Heure duree) {
		super(titre, interpretes);
		this.realisateur = realisateur;
		this.duree = duree;
	}
	
	/**
	 * Retourne la description du film sous forme de String
	 */
	public String toString() {
		return super.toString() + "Realise par: "+realisateur+". Dur: "+duree.toString()+".";
	}
	
	/**
	 * Retourne le realisateur
	 * @return le nom du realisateur sous forme de String
	 */
	public String getRealisateur() {
		return realisateur;
	}
	/**
	 * Retourne la duree du spectacle
	 * @return la duree du spectacle sous forme d'Heure
	 */
	public Heure getDuree() {
		return duree;
	}
}
