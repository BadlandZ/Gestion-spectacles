package gestion;

import java.util.Scanner;

public class GestionSpectacle {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int cptSalles = 0;
		int cptSallesTheatre = 0;

		EnsembleSalles eS = new EnsembleSalles();
		EnsembleSallesTheatre esT = new EnsembleSallesTheatre();

		System.out.println("Bienvenu dans le logiciel de gestion de la de la maison des Arts et de la Culture de la ville de Tarascon.");
		System.out.println("Nous allons dans un premier temps creer les salles.");
		System.out.print("Saisir le nombre de salle souhaitees: ");
		int nbSalles = sc.nextInt();
		System.out.println();

		while (cptSalles != nbSalles) {
			System.out.println("--- Creation de la salle " + cptSalles + " ---");
			System.out.print("Saisir un nom de salle: ");
			if (sc.hasNextLine()) {
				String nomSalle = sc.nextLine();
				System.out.println();
				System.out.println("Saisir un tarif de place: ");
				if (sc.hasNextInt()) {
					int tarifSalle = sc.nextInt();
					System.out.println();
					System.out.println("Saisir un nombre de places: ");
					if (sc.hasNextLine()) {
						int nbPlacesSalle = sc.nextInt();
						System.out.println();
						eS.ajouterSalle(new Salle(nomSalle, tarifSalle,
								nbPlacesSalle));
						cptSalles++;
					} else {
						System.out.println("Saisir un nombre correct.");
						sc.next();
					}
				} else {
					System.out.println("Saisir un nombre correct.");
					sc.next();
				}
			}
		}
		System.out.println("La creation des salles est maintenant terminee.");

		System.out.println("Nous allons maintenant creer les salles de theatres.");
		System.out.print("Saisir le nombre de salle de theatres souhaitees: ");
		int nbSallesTheatre = sc.nextInt();
		System.out.println();

		while (cptSallesTheatre != nbSallesTheatre) {
			System.out.print("Saisir un nom de salle: ");
			String nomSalleTheatre = sc.nextLine();
			System.out.println();
			System.out.print("Saisir un tarif de place: ");
			if (sc.hasNextInt()) {
				int tarifSalleTheatre = sc.nextInt();
				System.out.println();
				System.out.print("Saisir un nombre de places standard: ");
				if (sc.hasNextInt()) {
					int nbPlacesSalleTheatre = sc.nextInt();
					System.out.println();
					System.out.print("Saisir un nombre de fauteuils");
					int nbFauteuils = sc.nextInt();
					System.out.println();
					System.out.print("Saisir un prix du fauteuil: ");
					if (sc.hasNextInt()) {
						int nbPrixFauteuils = sc.nextInt();
						System.out.println();
						esT.ajouterSalle(new SalleTheatre(nomSalleTheatre,
								tarifSalleTheatre, nbPlacesSalleTheatre,
								nbFauteuils, nbPrixFauteuils));
						cptSallesTheatre++;
					} else {
						System.out.println("Saisir un nombre correct.");
						sc.next();
					}
				} else {
					System.out.println("Saisir un nombre correct.");
					sc.next();
				}
			} else {
				System.out.println("Saisir un nombre correct.");
				sc.next();
			}
		}
		System.out.println("La création des salles de theatre est maintenant terminee.");
	}

}
