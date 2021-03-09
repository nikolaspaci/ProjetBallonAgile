package com.github.modelisation;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 * @author Nikola,Tom
 * @version
 */
public class Sport {
    private String nom;
    private Set<Ballon> setBallons;

    /**
     * Constructeur d'objets de classe Sport
     */
    public Sport(String nom) {
	this.nom = nom;
	this.setBallons = new HashSet<>();
    }

    public void ajouterBallon(Ballon... ballons) {
	for (Ballon ballon : ballons) {
	    this.setBallons.add(ballon);
	    if (ballon.getSport() != this) {
		ballon.setSport(this);
	    }
	}
    }

    public void retirerBallon(Ballon ballon) {
	this.setBallons.remove(ballon);
	if (ballon.getSport() != null) {
	    ballon.setSport(null);
	}
    }

    public Set<Ballon> getSetBallons() {
	return this.setBallons;
    }

    public String getCategorie(Ballon ballon) {
	if (ballon.getTailleBallon() == 3) {
	    return "U11";
	} else if (ballon.getTailleBallon() == 5) {
	    return "Adulte";
	} else {
	    return "Inconnu";
	}
    }

    public String getSport() {
	return nom;
    }
}