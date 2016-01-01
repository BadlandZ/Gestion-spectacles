package gestion;

import java.util.List;

public abstract class Spectacle {
	
	private String titre;
	private List<String> interpretes;

	public Spectacle(String titre, List<String> interpretes) {
		this.titre = titre;
		this.interpretes = interpretes;
	}
	
	public String toString() {
		return "Titre: "+titre+"\n Liste des interpretes: "+interpretes.toString();
	}
	
	public String getTitre() {
		return titre;
	}
	
	public List<String> getInterpretes() {
		return interpretes;
	}
 
}