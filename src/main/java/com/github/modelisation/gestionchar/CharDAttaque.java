package com.github.modelisation.gestionchar;

import java.util.ArrayDeque;
import java.util.Deque;

import com.github.modelisation.munitions.AbstractMunition;

public class CharDAttaque extends Char {
	public static final int MAX_MUNITION = 10;

	private Deque<AbstractMunition> munitions;

	public CharDAttaque(String fabriquant, int calibre) {
		super(fabriquant, calibre);
		munitions = new ArrayDeque<>();
	}

	public int getMunitionCount() {
		return munitions.size();
	}

	public void ajouterMunition(AbstractMunition munition) {
		if (munition.getCalibre() != getCalibre()) {
			throw new IllegalArgumentException("munition de mauvais calibre");
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
