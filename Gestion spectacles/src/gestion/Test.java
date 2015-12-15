package gestion;

public class Test {
	
	public static void main(String[] args) {
		Salle s = new Salle("Salle", 10, 50);
		Salle b = new Salle("Cine", 10, 50);
		/*SalleTheatre sT = new SalleTheatre("Salle", 10, 50, 30, 15);
		System.out.println(s.toString());
		System.out.println(sT.toString());*/
		
		ProgrammationFilm p = new ProgrammationFilm();
		SeanceCinema sC = new SeanceCinema(3, new Heure(12, 15), s);
		SeanceCinema sD = new SeanceCinema(1, new Heure(14, 15), b);
		SeanceCinema sR = new SeanceCinema(1, new Heure(13, 15), b);
		p.ajouterSeance(sC);
		p.ajouterSeance(sD);
		p.ajouterSeance(sR);
		System.out.println(p.toString());
	}

}
