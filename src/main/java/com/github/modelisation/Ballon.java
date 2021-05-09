package com.github.modelisation;

/**
 * Décrivez votre classe Ballon ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Ballon {
	private double pressionBallon;
	private int tailleBallon;
	private Sport sport;

	/**
	 * Constructeur d'objets de classe Ballon
	 */
	public Ballon() {
		this.pressionBallon = 0;
		this.tailleBallon = 0;
	}

	public void reglerBallon(double pression, int taille) {
		this.changerPressionBallon(pression);
		this.setTailleBallon(taille);
	}

	public double getPressionBallon() {
		return this.pressionBallon;
	}

	public int getTailleBallon() {
		return this.tailleBallon;
	}

	public void setPressionBallon(double pression) {
		this.pressionBallon = pression;
	}

	public void setTailleBallon(int taille) {
		this.tailleBallon = taille;
	}

	public void changerPressionBallon(double nouvellePression) {
		this.setPressionBallon(nouvellePression);
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport nouveauSport) {

		if (this.sport != null && this.sport.getSetBallons().contains(this)) {
			this.sport.retirerBallon(this);
		}
		this.sport = nouveauSport;
		if (!nouveauSport.getSetBallons().contains(this)) {
			nouveauSport.ajouterBallon(this);
		}
	}
}