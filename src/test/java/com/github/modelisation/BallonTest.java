package com.github.modelisation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe-test BallonTest.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BallonTest {
	private Ballon ballon;
	private Sport footBall;
	private Sport basketBall;

	/**
	 * Constructeur de la classe-test BallonTest
	 */
	public BallonTest() {
	}

	@BeforeEach
	public void setUp()	{
		ballon = new Ballon();
		footBall = new Sport("Football");
		basketBall = new Sport("BasketBall");
	}

	/**
	 * Supprime les engagements
	 *
	 * Méthode appelée après chaque appel de méthode de test.
	 */
	@AfterEach
	public void tearDown() // throws java.lang.Exception
	{
		// Libérez ici les ressources engagées par setUp()
	}

	@Test
	public void testGetSport() {
		assertNull(ballon.getSport());
	}

	@Test
	public void testSetSport() {
		ballon.setSport(footBall);
		assertEquals(footBall, ballon.getSport());
		assertTrue(footBall.getSetBallons().contains(ballon));
	}

	@Test
	public void testChangerSport() {
		ballon.setSport(footBall);
		ballon.setSport(basketBall);
		assertEquals(basketBall, ballon.getSport());
		assertFalse(footBall.getSetBallons().contains(ballon));
		assertTrue(basketBall.getSetBallons().contains(ballon));
	}

	@Test
	public void testGetPressionBallon() {
		Ballon ballon1 = new Ballon();
		ballon1.changerPressionBallon(3.9);
		assertEquals(3.9, ballon1.getPressionBallon(), 0.1);
	}

}