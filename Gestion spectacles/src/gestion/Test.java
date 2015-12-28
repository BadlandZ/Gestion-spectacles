package gestion;

public class Test {
	
	public static void main(String[] args) {
		//Salle s = new Salle("Salle", 10, 50);
		Salle b = new Salle("Cine", 10, 50);
		
		String nomSalle = "Salle";
		int tarif = 10;
		int capacite = 50;
		
		EnsembleSalles eS = new EnsembleSalles();
		
		System.out.println(eS.ajouterSalle(new Salle(nomSalle, tarif, capacite)));
		System.out.println(eS.ajouterSalle(new Salle(nomSalle, tarif, capacite)));
		
		System.out.println(eS.toString());
		
	}

}
