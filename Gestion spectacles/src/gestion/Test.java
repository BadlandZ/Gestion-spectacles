package gestion;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



public class Test {
	
	static Scanner sc;
	
	public static void main(String[] args) {
		List<String> interpretes = new ArrayList<String>();
		interpretes.add("Paul");
		interpretes.add("Jack");
		Salle s = new Salle("Victor", 10, 10);
		Film f1 = new Film("Paul", interpretes, "bay", new Heure(12, 30));
		Film f2 = new Film("Jack", interpretes, "Jean", new Heure(14, 20));
		SeanceCinema sC = new SeanceCinema(12, new Heure(13, 30), s);
		
		ProgrammationSemaine pF = new ProgrammationSemaine(0);
		
		pF.ajouterFilm(f1);
		pF.ajouterFilm(f2);
		//pF.ajouterSeanceCinema(pF.trouverFilm("Paul"), sC);
		//System.out.println(pF.consulterSeanceCinema(pF.trouverFilm("Paul")).toString());
		
		System.out.println(pF.trouverFilm("Paul").toString());
		
		
		
	}

}
