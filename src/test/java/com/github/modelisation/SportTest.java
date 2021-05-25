package com.github.modelisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SportTest {
	private Ballon ballonFootballAdulte;
	private Ballon ballonFootballU11;
	private Ballon ballonFootballU15;
	private Sport football;

	@BeforeEach
	public void setUp() {
		ballonFootballAdulte = new Ballon();
		ballonFootballU11 = new Ballon();
		ballonFootballU15 = new Ballon();
		football = new Sport("Football");
	}

	@Test
	public void testGetListeBallons() {
		assertTrue(football.getSetBallons().isEmpty());
	}

	@Test
	public void testAjoutBallonListe() {
		football.ajouterBallon(ballonFootballAdulte, ballonFootballU11);
		assertTrue(football.getSetBallons().contains(ballonFootballAdulte));
		assertTrue(football.getSetBallons().contains(ballonFootballU11));
		assertFalse(football.getSetBallons().contains(ballonFootballU15));
		assertEquals(football, ballonFootballAdulte.getSport());
	}

	@Test
	public void testRetirerBallonListe() {
		football.ajouterBallon(ballonFootballAdulte, ballonFootballU11);
		football.retirerBallon(ballonFootballU11);
		assertFalse(football.getSetBallons().contains(ballonFootballU11));
		assertNull(ballonFootballU11.getSport());
	}

}
