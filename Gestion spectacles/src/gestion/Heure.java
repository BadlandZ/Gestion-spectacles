package gestion;

public class Heure implements Comparable<Heure>{
	
	private int heures;
	private int minutes;
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
	
	public boolean equals(Heure h) {
		return ((this.heures == h.heures) && (this.minutes == h.minutes));
	}
	
	public String toString() {
		return heures+"h"+minutes;
	}

}