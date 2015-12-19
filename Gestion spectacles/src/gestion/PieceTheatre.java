package gestion;

import java.util.List;

public class PieceTheatre extends Spectacle {
	
	private String metteurEnScene;
	private int nbEntractes;
	public PieceTheatre(String titre, List<String> interepretes, String metteurEnScene, int nbEntractes) {
		super(titre, interepretes);
		this.metteurEnScene = metteurEnScene;
		this.nbEntractes = nbEntractes;
	}
	
	public String toString() {
		return super.toString() + "Mis en scene par: "+metteurEnScene+". Sur "+nbEntractes+" entractes.";
	}
	
	public String getMetteurEnScene() {
		return metteurEnScene;
	}
	
	public int getNbEntractes() {
		return nbEntractes;
	}

}
