package gestion;

/**
 * GestionSpectacle est la classe centralisant l'ensemble des classes. Elle contient notament les methode main. 
 * Elle est est caracterise par une list lesProgrammations contenant l'ensemble des ProgrammationSemaine crees par l'utilisateur.
 * Elle permet notamment la creation des Salles et Salles de theatre par le biai d'un menu qui se veut le plus interactif possible.
 * 
 * @author younes
 * version 1.0
 */

import java.util.Iterator;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class GestionSpectacle {
	/**
	 * Premier scanner permetant la lecture des entiers
	 */
	static Scanner sc = new Scanner(System.in);
	/**
	 * Second scanner permetant la lecture des chaines de caractere
	 */
	static Scanner sc1 = new Scanner(System.in);

	public static void main(String[] args) {
		/**
		 * Compteur permettant l'affichage des differentes Salle/SalleTheatre en cours de preparation pour un affichage plus clair
		 */
		int cpt = 1;
		
		/**
		 * List de type ArrayList<ProgrammationSemaine> contenant l'ensemble des programmations semaines crees par l'utilisateur
		 */
		List<ProgrammationSemaine> lesProgrammations = new ArrayList<ProgrammationSemaine>();
		
		/**
		 * Objet de type EnsembleSalles qui contient l'ensemble des Salle crees par l'utilisateur
		 */
		EnsembleSalles eS = new EnsembleSalles();
		/**
		 * Objet de type EnsembleSallesTheatre qui contient l'ensembe des SalleTheatre crees par l'utilisateur
		 */
		EnsembleSallesTheatre esT = new EnsembleSallesTheatre();
//Creation  des salles
		System.out.println("Bienvenu dans le logiciel de gestion de la billetterie de la maison des Arts et de la Culture de la ville de Tarascon.");
		System.out.println("Nous allons dans un premier temps creer les salles.");
		System.out.print("Saisir le nombre de salles souhaitees: ");
		int nbSalles = 0;
		while(!sc.hasNextInt()) {
			System.out.print("Saisir un nombre correct: ");
			sc.next();
		}
		nbSalles = sc.nextInt();
		System.out.println();

		while (cpt != (nbSalles + 1)) {
			System.out.println("--- Creation de la salle " + cpt + " ---");
			System.out.print("\tSaisir un nom de salle: ");
			String nomSalle = sc1.nextLine();

			System.out.print("\tSaisir un tarif de place: ");
			if (sc.hasNextInt()) {
				int tarifSalle = sc.nextInt();

				System.out.print("\tSaisir un nombre de places: ");
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
		System.out.print("\nSaisir le nombre de salles de theatre souhaitees: ");
		int nbSallesTheatre = 0;
		while(!sc.hasNextInt()) { 
			System.out.print("Saisir un nombre correct: ");
			sc.next();
		}
		nbSallesTheatre = sc.nextInt();
		System.out.println();

		while (cpt != (nbSallesTheatre + 1)) {
			System.out.println("--- Creation de la salle de theatre " + cpt + " ---");
			System.out.print("\tSaisir un nom de salle: ");
			String nomSalleTheatre = sc1.nextLine();

			System.out.print("\tSaisir un tarif de place: ");
			if (sc.hasNextInt()) {
				int tarifSalleTheatre = sc.nextInt();

				System.out.print("\tSaisir un nombre de places standard: ");
				if (sc.hasNextInt()) {
					int nbPlacesSalleTheatre = sc.nextInt();

					System.out.print("\tSaisir un nombre de fauteuils: ");
					int nbFauteuils = sc.nextInt();

					System.out.print("\tSaisir un prix du fauteuil: ");
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
		System.out.println("La creation des salles et salles de theatre est maintenant terminee.");
		System.out.println("\nRecapitulatif.");
		System.out.println(eS.toString());
		System.out.println();
		System.out.println(esT.toString());
//Menu principal
		cpt = 1;
		System.out.println();
		String choix = "";
		boolean continuer = true;
		List<String> interpretes = new ArrayList<String>();
		while (continuer) {
			System.out.println("\n \n------------------------ Menu principal ------------------------");
			System.out.println("\n \t(1) Creer une programmation de semaine.");
			System.out.println("\t(2) Modifier une programmation existente.");
			System.out.println("\t(3) Vendre des places pour une programmation.");
			System.out.println("\t(4) Consulter les informations relatives aux ventes.");
			System.out.println("\t(q) Quitter.");
			System.out.print("\n \n Choisir une option en saisissant le chiffre correspondant, ou \"q\" pour quitter: ");
			choix = sc1.nextLine();
			System.out.println("\n");
// 1 Creation de la programmation de la semaine			
			if (choix.equalsIgnoreCase("1")) {
				System.out.println("-----|Creation de la programmation de la semaine "+ lesProgrammations.size() + "|-----");
				System.out.print("Souhaitez vous creer la programmation d'un film ou d'une piece de theatre ? (Film/Piece): ");
				String choix1 = sc1.nextLine();
				while (choix1.equalsIgnoreCase("Film")) {
					System.out.println("\n--- Creation d'un film ---");
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
							System.out.print("Duree. Minute: ");
							if (sc.hasNextInt()) {
								int minuteFilm = sc.nextInt();
								ProgrammationSemaine pF = new ProgrammationSemaine(lesProgrammations.size());
								pF.ajouterFilm(new Film(titreFilm, interpretes, realisateur, new Heure(heureFilm, minuteFilm)));
								lesProgrammations.add(pF);
								interpretes.clear();
								cpt = 1;
								System.out.print("Souhaitez saisir un autre film ? (o/n): ");
								choix1 = sc1.nextLine();
								if(choix1.equalsIgnoreCase("n"))
									choix = "";
								else if (choix1.equalsIgnoreCase("o")) {
									choix1 = "Film";
								}
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
				} 
				while (choix1.equalsIgnoreCase("Piece")) {
					System.out.println("\n--- Creation d'une piece de theatre ---");
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
							System.out.print("Souhaitez saisir une autre piece ? (o/n): ");
							choix1 = sc1.nextLine();
							if(choix1.equalsIgnoreCase("n"))
								choix = "";
							else if (choix1.equalsIgnoreCase("o")) {
								choix1 = "Piece";
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
			}
			else if (choix.equalsIgnoreCase("2")) {
/*Modification*/System.out.println("-----|Modifier une programmation existente|-----");
				System.out.println("\n- Programmations -\n ");
				Iterator<ProgrammationSemaine> it = lesProgrammations.iterator();
				cpt = 0;
				System.out.println();
				while(it.hasNext()) {
					ProgrammationSemaine pS = it.next();
					if(pS.getListeProgFilm().keySet().size() > 0) {
						System.out.println(cpt+" - "+pS.consulterFilms());
						cpt ++;
					}
					if(pS.getListeProgTheatre().keySet().size() > 0) {
						System.out.println(cpt+" - "+pS.consulterPieces());
						cpt ++;
					}
				}
	
				System.out.println();
				System.out.print("Il y a actuellement "+lesProgrammations.size()+" semaines programmee(s). Saisir le numero de la semaine a modifier: ");
				if(sc.hasNextInt()) {
					int semaineAModifier = sc.nextInt();
					if(semaineAModifier > 0 || semaineAModifier < lesProgrammations.size()) {
						System.out.print("Souhaitez vous ajouter ou supprimer une seance ? (a/s): ");
						String choix2 = sc1.nextLine();
						if(choix2.equalsIgnoreCase("a")) {
							System.out.println("\n--- Ajout d'une seance ---");
							System.out.print("Souhaitez vous ajouter une seance de film ou une seance de theatre ? (Film/Piece): ");
							choix2 = sc1.nextLine();
							if(choix2.equalsIgnoreCase("Film")) {
								System.out.print("Film: ");
								String film = sc1.nextLine();
								System.out.println(lesProgrammations.get(semaineAModifier).trouverFilm(film).toString());
								System.out.print("Jour: ");
								if(sc.hasNextInt()) {
									int jour = sc.nextInt();
									System.out.print("Commence a. Heure: ");
									if(sc.hasNextInt()) {
										int heure = sc.nextInt();
										System.out.print("Commence a. Minute: ");
										if(sc.hasNextInt()) {
											int minute = sc.nextInt();
											System.out.print("Salle: ");
											String salle = sc1.nextLine();
											if(eS.contientSalle(salle)) {
												SeanceCinema sC = new SeanceCinema(jour, new Heure(heure, minute), eS.trouverSalle(salle));
												lesProgrammations.get(semaineAModifier).ajouterSeanceCinema(lesProgrammations.get(semaineAModifier).trouverFilm(film), sC);
												System.out.println("La seance "+ sC.toString() +" a bien ete ajoutee.");
											} else System.out.println("La salle n'existe pas.");
										} else {
											System.out.println("Saisir un chiffre correct.");
											sc.next();
										}
									} else {
										System.out.println("Saisir un nombre correct.");
										sc.next();
									}
								} else { 
									System.out.println("Saisir un chiffre correct.");
									sc.next();
								}
							} 
							else if(choix2.equalsIgnoreCase("Piece")) {
								System.out.print("Piece: ");
								String piece = sc1.nextLine();
								System.out.println(lesProgrammations.get(semaineAModifier).trouverPieceTheatre(piece).toString());
								System.out.print("Jour: ");
								if(sc.hasNextInt()) {
									int jour = sc.nextInt();
									System.out.print("Commence a. Heure: ");
									if(sc.hasNextInt()) {
										int heure = sc.nextInt();
										if(sc.hasNextInt()) {
											System.out.print("Commence a. Minute: ");
											int minute = sc.nextInt();
											System.out.print("Salle: ");
											String salle = sc1.nextLine();
											if(esT.contientSalle(salle)) {
												SeanceTheatre sT = new SeanceTheatre(jour, new Heure(heure, minute), esT.trouverSalle(salle));
												lesProgrammations.get(semaineAModifier).ajouterSeanceTheatre(lesProgrammations.get(semaineAModifier).trouverPieceTheatre(piece), sT);
												System.out.println("La seance "+ sT.toString() +" a bien ete ajoutee.");
											} else System.out.println("La salle n'existe pas.");
										} else {
											System.out.println("Saisir un chiffre correct.");
											sc.next();
										}
									} else {
										System.out.println("Saisir un nombre correct.");
										sc.next();
									}
								} else { 
									System.out.println("Saisir un chiffre correct.");
									sc.next();
								}
							} else System.out.println("Saisir un caractere correct.");
						}
						else if(choix2.equalsIgnoreCase("s")) {
							System.out.println("--- Supression d'une seance ---");
							System.out.print("Souhaitez vous supprimer une seance de film ou une seance de theatre ? (Film/Piece): ");
							choix2 = sc1.nextLine();
							if(choix2.equalsIgnoreCase("Film")) {
								System.out.print("Film: ");
								String film = sc1.nextLine();
								System.out.print("Semaine: ");
								if(sc.hasNextInt()) {
									int nbSemaine = sc.nextInt();
									if(lesProgrammations.get(nbSemaine).consulterSeanceCinema(lesProgrammations.get(nbSemaine).trouverFilm(film)).nbSeances() > 0) {
										System.out.println(lesProgrammations.get(nbSemaine).consulterSeanceCinema(lesProgrammations.get(nbSemaine).trouverFilm(film)));
										System.out.print("Jour: ");
										if(sc.hasNextInt()) {
											int jour = sc.nextInt();
											System.out.print("Horaire. Heure: ");
											if(sc.hasNextInt()) {
												int heure = sc.nextInt();
												System.out.print("Horaire. Minute: ");
												if(sc.hasNextInt()) {
													int minute = sc.nextInt();
													System.out.print("Salle: ");
													String salle = sc1.nextLine();
													lesProgrammations.get(nbSemaine).supprimerSeanceCinema(lesProgrammations.get(nbSemaine).trouverFilm(film), new SeanceCinema(jour, new Heure(heure, minute), eS.trouverSalle(salle)));
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
									} else System.out.println("Il n'y a aucune seance pour ce film.");
								} else {
									System.out.println("Saisir un nombre correct.");
									sc.next();
								}
							}
							else if (choix2.equalsIgnoreCase("Piece")) {
								System.out.print("Piece theatre: ");
								String piece = sc1.nextLine();
								System.out.print("Semaine: ");
								if(sc.hasNextInt()) {
									int nbSemaine = sc.nextInt();
									if(lesProgrammations.get(nbSemaine).consulterSeanceTheatre(lesProgrammations.get(nbSemaine).trouverPieceTheatre(piece)).size() > 0) {
										System.out.println(lesProgrammations.get(nbSemaine).consulterSeanceTheatre(lesProgrammations.get(nbSemaine).trouverPieceTheatre(piece)));
										System.out.print("Jour: ");
										if(sc.hasNextInt()) {
											int jour = sc.nextInt();
											System.out.print("Horaire. Heure: ");
											if(sc.hasNextInt()) {
												int heure = sc.nextInt();
												System.out.print("Horaire. Minute: ");
												if(sc.hasNextInt()) {
													int minute = sc.nextInt();
													System.out.print("Salle: ");
													String salle = sc1.nextLine();
													lesProgrammations.get(nbSemaine).supprimerSeanceTheatre(lesProgrammations.get(nbSemaine).trouverPieceTheatre(piece), new SeanceTheatre(jour, new Heure(heure, minute), esT.trouverSalle(salle)));
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
									} else System.out.println("Il n'y a aucune seance pour cette piece de theatre.");
								} else {
									System.out.println("Saisir un nombre correct.");
									sc.next();
								}	
							}
							else System.out.println("Saisir une reponse correct.");
						}
						else System.out.println("Saisir un caractere correct.");
					} else {
						System.out.println("Saisir un nombre entre 0 et"+lesProgrammations.size());
					}
				} else {
					System.out.println("Saisir un nombre correct.");
					sc.next();
				}
			}
			else if (choix.equalsIgnoreCase("3")) {
				System.out.println("----|Vendre des places pour une programmation|----");
				System.out.println("\n- Programmations -\n");
				Iterator<ProgrammationSemaine> it = lesProgrammations.iterator();
				cpt = 0;
				System.out.println();
				while(it.hasNext()) {
					ProgrammationSemaine pS = it.next();
					if(pS.getListeProgFilm().keySet().size() > 0) {
						System.out.println(cpt+" - "+pS.consulterFilms());
						cpt ++;
					}
					if(pS.getListeProgTheatre().keySet().size() > 0) {
						System.out.println(cpt+" - "+pS.consulterPieces());
						cpt ++;
					}
				}
				System.out.print("Vente de places pour un film ou une piece ? (Film/Piece): ");
				String choix3 = sc1.nextLine();
				if(choix3.equalsIgnoreCase("film")) {
					System.out.print("Semaine (se referer a la liste de programmation ci-dessus): ");
					if(sc.hasNextInt()) {
						int semaine = sc.nextInt();
						System.out.print("Titre du film: ");
						String film = sc1.nextLine();
						System.out.println(lesProgrammations.get(semaine).consulterSeanceCinema(lesProgrammations.get(semaine).trouverFilm(film)).toString());
						System.out.print("Jour: ");
						if(sc.hasNextInt()) {
							int jour = sc.nextInt();
							System.out.print("Horaire. Heure: ");
							if(sc.hasNextInt()) {
								int heure = sc.nextInt();
								System.out.print("Horaire. Minute: ");
								if(sc.hasNextInt()) {
									int minute = sc.nextInt();
									System.out.println("Nombre de place disponibles: "+lesProgrammations.get(semaine).consulterSeanceParInfos(lesProgrammations.get(semaine).trouverFilm(film), jour, new Heure(heure, minute)).nbPlacesDispo());
									System.out.print("Saisir le nombre de places a vendre: ");
									if(sc.hasNextInt()) {
										int nbPlaces = sc.nextInt();
										lesProgrammations.get(semaine).consulterSeanceParInfos(lesProgrammations.get(semaine).trouverFilm(film), jour, new Heure(heure, minute)).vendrePlacesTR(nbPlaces);
										System.out.println("Il reste maintenant: "+lesProgrammations.get(semaine).consulterSeanceParInfos(lesProgrammations.get(semaine).trouverFilm(film), jour, new Heure(heure, minute)).nbPlacesDispo()+" places disponibles.");
									} else {
										System.out.println("Saisir un nombre correct.");
										sc.next();
									}
								} else {
									System.out.println("Saisir une minute correct.");
									sc.next();
								}
							} else {
								System.out.println("Saisir une heure correct.");
								sc.next();
							}
						} else {
							System.out.println("Saisir un jour correct.");
							sc.next();
						}
					} else {
						System.out.println("Saisir un chiffre correct.");
						sc.next();
					}
				}
				else if (choix3.equalsIgnoreCase("piece")) {
					System.out.print("Semaine (se referer a la liste de programmation ci-dessus): ");
					if(sc.hasNextInt()) {
						int semaine = sc.nextInt();
						System.out.print("Titre de la piece: ");
						String piece = sc1.nextLine();
						System.out.println(lesProgrammations.get(semaine).consulterSeanceTheatre(lesProgrammations.get(semaine).trouverPieceTheatre(piece)).toString());
						System.out.print("Jour: ");
						if(sc.hasNextInt()) {
							int jour = sc.nextInt();
							System.out.print("Horaire. Heure: ");
							if(sc.hasNextInt()) {
								int heure = sc.nextInt();
								System.out.print("Horaire. Minute: ");
								if(sc.hasNextInt()) {
									int minute = sc.nextInt();
									System.out.println("Nombre de fauteuils disponibles: "+lesProgrammations
											.get(semaine).consulterSeanceParInfos(lesProgrammations
													.get(semaine).trouverPieceTheatre(piece), jour, new Heure(heure, minute)).nbFauteuilsDispo());
									System.out.print("Saisir le nombre de places de fauteuils a vendre: ");
									if(sc.hasNextInt()) {
										int nbPlacesFauteuils = sc.nextInt();
										lesProgrammations
											.get(semaine)
											.consulterSeanceParInfos(lesProgrammations.get(semaine)
													.trouverPieceTheatre(piece), jour, new Heure(heure, minute)).vendrePlacesFauteuil(nbPlacesFauteuils);
										System.out.println("Il reste maintenant: "+lesProgrammations.get(semaine).consulterSeanceParInfos(lesProgrammations.get(semaine).trouverPieceTheatre(piece), jour, new Heure(heure, minute)).nbFauteuilsDispo()+" fauteuils disponibles.");
										System.out.println("Il reste: "+lesProgrammations.get(semaine).consulterSeanceParInfos(lesProgrammations.get(semaine).trouverPieceTheatre(piece), jour, new Heure(heure, minute)).nbPlacesDispo()+" disponibles.");
										System.out.println("Saisir le nombre de places a vendre: ");
										int nbPlaces = sc.nextInt();
										lesProgrammations
										.get(semaine)
										.consulterSeanceParInfos(lesProgrammations.get(semaine)
												.trouverPieceTheatre(piece), jour, new Heure(heure, minute)).vendrePlacesTN(nbPlaces);
										System.out.println("Il reste maintenant: "+lesProgrammations.get(semaine).consulterSeanceParInfos(lesProgrammations.get(semaine).trouverPieceTheatre(piece), jour, new Heure(heure, minute)).nbPlacesDispo()+" places disponibles.");
									} else {
										System.out.println("Saisir un nombre correct.");
										sc.next();
									}
								} else {
									System.out.println("Saisir une minute correct.");
									sc.next();
								}
							} else {
								System.out.println("Saisir une heure correct.");
								sc.next();
							}
						} else {
							System.out.println("Saisir un jour correct.");
							sc.next();
						}
					} else {
						System.out.println("Saisir un chiffre correct.");
						sc.next();
					}
				}
				else System.out.println("Saisir un choix correct.");
			}
			else if (choix.equalsIgnoreCase("4")) {
				System.out.println("----|Consulter les informations relatives aux ventes|----");
				System.out.println("\n- Programmations -\n");
				Iterator<ProgrammationSemaine> it = lesProgrammations.iterator();
				cpt = 0;
				System.out.println();
				while(it.hasNext()) {
					ProgrammationSemaine pS = it.next();
					if(pS.getListeProgFilm().keySet().size() > 0) {
						System.out.println(cpt+" - "+pS.consulterFilms());
						cpt ++;
					}
					if(pS.getListeProgTheatre().keySet().size() > 0) {
						System.out.println(cpt+" - "+pS.consulterPieces());
						cpt ++;
					}
				}
				System.out.print("\nSemaine (se referer a la liste de programmation ci-dessus): ");
				int semaine = sc.nextInt();
				System.out.print("Souhaitez vous consulter les informations d'un film ou d'une piece de theatre ? (Film/Piece): ");
				String choix3 = sc1.nextLine();
				if(choix3.equalsIgnoreCase("Film")) {
					System.out.print("Film: ");
					String film = sc1.nextLine();
					System.out.println("Seances: ");
					System.out.println(lesProgrammations.get(semaine).consulterSeanceCinema(lesProgrammations.get(semaine).trouverFilm(film)).toString());
					System.out.print("Jour: ");
					int jour = sc.nextInt();
					System.out.print("Horaire. Heure: ");
					int heure = sc.nextInt();
					System.out.print("Horaire. Minute: ");
					int minute = sc.nextInt();
					System.out.print("Consulter le chiffre d'affaire ou le taux de remplissage ? (chiffre/taux): ");
					choix3 = sc1.nextLine();
					if(choix3.equalsIgnoreCase("chiffre")) {
						System.out.println("Chiffre d'affaire: "+lesProgrammations.get(semaine).chiffreAffaireFilms(lesProgrammations.get(semaine).trouverFilm(film))+"€.");
					}
					else if(choix3.equalsIgnoreCase("taux")) {
						System.out.println("Taux de remplissage: "+lesProgrammations.get(semaine).tauxRemplissagesFilm(lesProgrammations.get(semaine).trouverFilm(film), jour, new Heure(heure, minute))+"%.");
					} else System.out.println("Saisir un choix correct. ");
				}
				else if(choix3.equalsIgnoreCase("Piece")) {
					System.out.print("Piece: ");
					String piece = sc1.nextLine();
					System.out.println("Seances: ");
					System.out.println(lesProgrammations.get(semaine).consulterSeanceTheatre(lesProgrammations.get(semaine).trouverPieceTheatre(piece)).toString());
					System.out.print("Jour: ");
					int jour = sc.nextInt();
					System.out.print("Horaire. Heure: ");
					int heure = sc.nextInt();
					System.out.print("Horaire. Minute: ");
					int minute = sc.nextInt();
					System.out.print("Consulter le chiffre d'affaire ou le taux de remplissage ? (chiffre/taux): ");
					choix3 = sc1.nextLine();
					if(choix3.equalsIgnoreCase("chiffre")) {
						System.out.println("Chiffre d'affaire: "+lesProgrammations.get(semaine).chiffreAffairePiecesTheatres(lesProgrammations.get(semaine).trouverPieceTheatre(piece))+"€.");
					}
					else if(choix3.equalsIgnoreCase("taux")) {
						System.out.println("Taux de remplissage: "+lesProgrammations.get(semaine).tauxRemplissageTheatre(lesProgrammations.get(semaine).trouverPieceTheatre(piece), jour, new Heure(heure, minute))+"%.");
					} else System.out.println("Saisir un choix correct. ");
				} else System.out.println("Saisir un choix correct.");
				
			}
			else if(choix.equalsIgnoreCase("q")) {
				System.out.println("Arret du logiciel.");
				return;
			}
			else {
				System.out.println("Saisir une reponse correct.");
			}
		}

	}
}
