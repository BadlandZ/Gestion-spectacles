package gestion;
/**
 * La classe PieceTheatre est un spectacle. Ainsi elle herite de la classe spectacle.
 * Elle est caractérisé par :
 * 	- Un metteur en scene
 * 	- Un nombre d'entract
 * 
 * @cedric
 * @version 1.0
 */
import java.util.List;

public class PieceTheatre extends Spectacle {
	/**
	 * Le nom du metteur en scene
	 */
	private String metteurEnScene;
	/**
	 * Le nombre d'entract 
	 */
	private int nbEntractes;
	
	/**
	 * Le constructeur initialise les attributs herites a l'aide de la methode super
	 * @param titre le titre du film sous forme de String
	 * @param interpretes la liste des interpretes sous forme de liste de String
	 * @param metteurEnScene le nom du realisateur sous forme de String
	 * @param nbEntractes le nombre d'entracts sous forme d'entier
	 */
	public PieceTheatre(String titre, List<String> interepretes, String metteurEnScene, int nbEntractes) {
		super(titre, interepretes);
		this.metteurEnScene = metteurEnScene;
		this.nbEntractes = nbEntractes;
	}
	
	/**
	 * Retourne la description de la piece de theatre sous forme de String
	 */
	public String toString() {
		return super.toString() + "Mis en scene par: "+metteurEnScene+". Sur "+nbEntractes+" entractes.";
	}
	
	/**
	 * Retourne le metteur en scene
	 * @return le nom du metteur en scene sous forme de String
	 */
	public String getMetteurEnScene() {
		return metteurEnScene;
	}
	
	/**
	 * Retourne le nombre d'entract de la piece de theatre
	 * @return le nombre d'entracts de la piece de theatre sous forme d'entier
	 */
	public int getNbEntractes() {
		return nbEntractes;
	}

}
