package gestion;
/**
 * La classe heure creer un objet permettant de manipuler une heure formee d'heure et de minutes.
 * Cette classe est caracterise par une heure et des minutes. Elle est inspiree de la classe Heure cree en td/tp.
 * De plus cette classe implemente l'interface Comparable<Heure> afin d'implementer la methode compareTo(Heure h)
 * @author cedric
 * @version 1.0
 */

public class Heure implements Comparable<Heure>{
	
	private int heures;
	private int minutes;
	/**
	 * Le constructeur permet d'initialiser les attributs en fonction des parametres.
	 * @param heures correspond a l'heure
	 * @param minutes correspond aux minutes
	 * @throws IllegalArgumentException si l'heure et les minutes ne sont pas dans un interval valable.
	 */
	public Heure(int heures, int minutes) throws IllegalArgumentException{
		if(((heures < 0) || (heures > 23)) || ((minutes < 0) || (minutes > 59))) { 
			throw new IllegalArgumentException();
		}
		else {
			this.heures = heures;
			this.minutes = minutes;
		}
	}
	
	public int getHeures() { return this.heures; }
	public int getMinutes() { return this.minutes; }

	/**
	 * La methode compareTo va dabort comparer les heures et ensuites celles des minutes afin de savoir si l'heure appelee est plus petite ou plus grande que celle passee en parametre
	 */
	public int compareTo(Heure h) {
		if(this.heures < h.heures) return -1;
		else if (this.heures == h.heures) {
			if(this.minutes < h.minutes) {
				return -1;
			}
			else if (this.minutes > h.minutes) {
				return 1;
			}
			else return 0;
		}
		return 1;
	}
	
	/**
	 * Test si l'heure passee en parametre est egal a l'heure appelee
	 * @param h l'heure dont l'on souhaite tester l'egalite
	 * @return vrai si les deux heures sont egal, retourne faux sinon.
	 */
	public boolean equals(Heure h) {
		return ((this.heures == h.heures) && (this.minutes == h.minutes));
	}
	
	/**
	 * Decrit l'heure sous forme de chaine de caracteres
	 */
	public String toString() {
		return heures+"h"+minutes;
	}

}