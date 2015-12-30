package gestion;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GestionSpectacle {

	static Scanner sc = new Scanner(System.in);
	static Scanner sc1 = new Scanner(System.in);

	public static void main(String[] args) {
		int cpt = 1;

		List<ProgrammationSemaine> lesProgrammations = new ArrayList<ProgrammationSemaine>();

		EnsembleSalles eS = new EnsembleSalles();
		EnsembleSallesTheatre esT = new EnsembleSallesTheatre();

		System.out.println("Bienvenu dans le logiciel de gestion de la de la maison des Arts et de la Culture de la ville de Tarascon.");
		System.out.println("Nous allons dans un premier temps creer les salles.");
		System.out.print("Saisir le nombre de salles souhaitees: ");
		int nbSalles = sc.nextInt();
		System.out.println();

		while (cpt != (nbSalles + 1)) {
			System.out.println("--- Creation de la salle " + cpt + " ---");
			System.out.print("Saisir un nom de salle: ");
			String nomSalle = sc1.nextLine();

			System.out.print("Saisir un tarif de place: ");
			if (sc.hasNextInt()) {
				int tarifSalle = sc.nextInt();

				System.out.print("Saisir un nombre de places: ");
				if (sc.hasNextInt()) {
					int nbPlacesSalle = sc.nextInt();
					System.out.println();
					if (eS.ajouterSalle(new Salle(nomSalle, tarifSalle, nbPlacesSalle)))
						cpt++;
					else
						System.out.println("La salle "+ nomSalle+ " existe deja. Merci de saisir d'autres caracteristiques.");
				} else {
					System.out.println("Saisir un nombre correct.");
					sc.next();
				}
			} else {
				System.out.println("Saisir un nombre correct.");
				sc.next();
			}
		}

		cpt = 1;
		System.out.println("La creation des salles est maintenant terminee.");

		System.out.println("Nous allons maintenant creer les salles de theatre.");
		System.out.print("Saisir le nombre de salles de theatre souhaitees: ");
		int nbSallesTheatre = sc.nextInt();
		System.out.println();

		while (cpt != (nbSallesTheatre + 1)) {
			System.out.println("--- Creation de la salle de theatre " + cpt + " ---");
			System.out.print("Saisir un nom de salle: ");
			String nomSalleTheatre = sc1.nextLine();

			System.out.print("Saisir un tarif de place: ");
			if (sc.hasNextInt()) {
				int tarifSalleTheatre = sc.nextInt();

				System.out.print("Saisir un nombre de places standard: ");
				if (sc.hasNextInt()) {
					int nbPlacesSalleTheatre = sc.nextInt();

					System.out.print("Saisir un nombre de fauteuils: ");
					int nbFauteuils = sc.nextInt();

					System.out.print("Saisir un prix du fauteuil: ");
					if (sc.hasNextInt()) {
						int nbPrixFauteuils = sc.nextInt();
						System.out.println();
						if (esT.ajouterSalle(new SalleTheatre(nomSalleTheatre, tarifSalleTheatre, nbPlacesSalleTheatre, nbFauteuils, nbPrixFauteuils)))
							cpt++;
						else
							System.out.println("La salle "+ nomSalleTheatre+ " existe deja. Merci de saisir d'autres caracteristiques.");
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
		cpt = 1;
		System.out.println("La création des salles et salles de theatre est maintenant terminee.");
		System.out.println("Recapitulatif.");
		System.out.println(eS.toString());
		System.out.println(esT.toString());

		cpt = 1;
		System.out.println();
		String choix = "";
		System.out.println("------------------------ Menu principal ------------------------");
		System.out.println("\n \t(1) Creer la programmation de la semaine "+ lesProgrammations.size() + ".");
		System.out.println("\t(2) Modifier une programmation existente.");
		System.out.println("\t(3) Vendre des places pour une programmation.");
		System.out.println("\t(4) Consulter les informations relatives aux ventes.");
		System.out.println("\t(q) Quitter.");
		System.out.print("\n \n Choisir une option en saisissant le chiffre correspondant, ou \"q\" pour quitter: ");
		choix = sc1.nextLine();

		boolean continuer = true;
		List<String> interpretes = new ArrayList<String>();

		while (continuer) {
			if (choix.equalsIgnoreCase("1")) {
				System.out.println("--- Creation de la programmation de la semaine "+ lesProgrammations.size() + " ---");
				System.out.print("Souhaitez vous creer la programmation d'un film ou d'une piece de theatre ? (Film/Piece): ");
				String choix1 = sc1.nextLine();
				if (choix1.equalsIgnoreCase("Film")) {
					System.out.println("--- Creation d'un film ---");
					System.out.print("Titre: ");
					String titreFilm = sc1.nextLine();
					System.out.print("Saisir un nombre d'interpretes: ");
					if (sc.hasNextInt()) {
						int nbInterprete = sc.nextInt();
						while (cpt != (nbInterprete + 1)) {
							System.out.print("Interprete " + cpt + ": ");
							interpretes.add(sc1.nextLine());
							cpt++;
						}
						System.out.print("Realisateur: ");
						String realisateur = sc1.nextLine();
						System.out.print("Duree. Heure: ");
						if (sc.hasNextInt()) {
							int heureFilm = sc.nextInt();
							System.out.println("Duree. Minute: ");
							if (sc.hasNextInt()) {
								int minuteFilm = sc.nextInt();
								ProgrammationSemaine pF = new ProgrammationSemaine(lesProgrammations.size());
								pF.ajouterFilm(new Film(titreFilm, interpretes, realisateur, new Heure(heureFilm, minuteFilm)));
								lesProgrammations.add(pF);
								interpretes.clear();
								cpt = 1;
							} else {
								System.out.println("Saisir un nombre de minutes correct.");
							}
						} else {
							System.out.println("Saisir une heure correct.");
							sc.next();
						}
					} else {
						System.out.println("Saisir un nombre correct.");
						sc.next();
					}
				} else if (choix1.equalsIgnoreCase("Piece")) {
					System.out.println("--- Creation d'une piece de theatre ---");
					System.out.print("Titre: ");
					String titrePiece = sc1.nextLine();
					System.out.print("Saisir un nombre d'interpretes: ");
					if (sc.hasNextInt()) {
						int nbInterprete = sc.nextInt();
						while (cpt != (nbInterprete + 1)) {
							System.out.print("Interprete " + cpt + ": ");
							interpretes.add(sc1.nextLine());
							cpt++;
						}
						System.out.print("Metteur en scene: ");
						String metteurEnScene = sc1.nextLine();
						System.out.print("Nombre d'entracts: ");
						if (sc.hasNextInt()) {
							int nbEntractes = sc.nextInt();
							ProgrammationSemaine pF = new ProgrammationSemaine(lesProgrammations.size());
							pF.ajouterPieceTheatre(new PieceTheatre(titrePiece, interpretes, metteurEnScene, nbEntractes));
							lesProgrammations.add(pF);
							interpretes.clear();
							cpt = 1;
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
		}

	}
}
