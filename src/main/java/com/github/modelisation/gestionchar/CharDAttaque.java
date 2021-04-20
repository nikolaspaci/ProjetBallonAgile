package com.github.modelisation.gestionchar;

import java.util.ArrayDeque;
import java.util.Deque;

import com.github.modelisation.munitions.AbstractMunition;

public class CharDAttaque extends Char {
    private Deque<AbstractMunition> munitions;
    private static int MAX_MUNITION = 10;

    public CharDAttaque(String fabriquant, int calibre) {
	super(fabriquant, calibre);
	munitions = new ArrayDeque();
    }

    public void ajouterMunition(AbstractMunition munition) {
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
