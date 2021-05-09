package com.github.munitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.modelisation.Ballon;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.BallonToMunitionAdapter;

public class BallonToMunitionAdapterTest {
	private Ballon ballon;
	private AbstractMunition munition;

	@BeforeEach
	public void setUp() {
		ballon = new Ballon();
	}

	@Test
	public void testNewMunitionToBallonAdapter() {
		assertEquals(0, ballon.getPressionBallon());
		assertEquals(0, ballon.getTailleBallon());
		munition = new BallonToMunitionAdapter(ballon);
		assertEquals(BallonToMunitionAdapter.PRESSION_BALLON, ballon.getPressionBallon());
		assertEquals(BallonToMunitionAdapter.TAILLE_BALLON_MUNITION, ballon.getTailleBallon());
		assertEquals(BallonToMunitionAdapter.DEGAT_BALLON, munition.getDegatMunition());
	}

}