package gestion;

import java.util.List;

public class Film extends Spectacle{
	
	private String realisateur;
	private Heure duree;
	public Film(String titre, List<String> interpretes, String realisateur, Heure duree) {
		super(titre, interpretes);
		this.realisateur = realisateur;
		this.duree = duree;
	}
	
	public String toString() {
		return super.toString() + "Realise par: "+realisateur+". Dur: "+duree.toString()+".";
	}
	
	public String getRealisateur() {
		return realisateur;
	}

	public Heure getDuree() {
		return duree;
	}
}
