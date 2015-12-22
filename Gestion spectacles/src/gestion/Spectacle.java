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
		String str = "Titre: "+titre+"\n Liste des interpretes: \n";
		for(int i=0; i<interpretes.size(); i++) {
			str += interpretes.get(i) + "\n";
		}
		return str;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public List<String> getInterpretes() {
		return interpretes;
	}
 
}