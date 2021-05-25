package com.github.modelisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.modelisation.gestionchar.Char;
import com.github.modelisation.gestionchar.Mecanicien;
import com.github.modelisation.gestionchar.Regiment;

public class MecanicienTest {
	private Char shar;
	private Mecanicien mecano;

	@BeforeEach
	public void setUp() {
		shar = new Char("Leclerc", 150);
		mecano = new Mecanicien("SGT Brody", shar);
	}

	@Test
	public void testMecanicien() {
		assertEquals(shar.getCalibre(), 150);
		mecano.modifierCalibre(200);
		assertEquals(shar.getCalibre(), 200);
	}

	@Test
	public void testGetSetRegiment() {
		Regiment regiment = new Regiment();
		assertNull(mecano.getRegiment());
		mecano.setRegiment(regiment);
		assertEquals(regiment, mecano.getRegiment());
	}

	@AfterEach
	public void tearDown() {
	}
}
