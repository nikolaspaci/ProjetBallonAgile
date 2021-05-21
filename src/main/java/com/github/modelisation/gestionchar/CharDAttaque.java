package com.github.modelisation.gestionchar;

import java.util.ArrayDeque;
import java.util.Deque;

import com.github.modelisation.munitions.AbstractMunition;

import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CharDAttaque extends Char {
    public static final int MAX_MUNITION = 10;

    @Getter
    private Deque<AbstractMunition> munitions;

    public CharDAttaque(String fabriquant, int calibre) {
	super(fabriquant, calibre);
	munitions = new ArrayDeque<>();
    }

    public int getMunitionCount() {
	return munitions.size();
    }

    public void ajouterMunition(AbstractMunition munition) {
	if (munition.getCalibre() > getCalibre()) {
	    log.error("munition de mauvais calibre," + munition.getCalibre() + "incompatible avec le calibre"
		    + this.getCalibre());
	    throw new UncompatibleCalibreException("munition de mauvais calibre");
	}

	if (munitions.size() < MAX_MUNITION) {
	    munitions.add(munition);
	}
    }

    public void tirer() {
	if (!munitions.isEmpty()) {
	    munitions.removeLast();
	}
    }

}
