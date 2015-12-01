package gestion;

public class Test {
	
	public static void main(String[] args) {
		Salle s = new Salle("Salle", 10, 50);
		SalleTheatre sT = new SalleTheatre("Salle", 10, 50, 30, 15);
		System.out.println(s.toString());
		System.out.println(sT.toString());
	}

}
