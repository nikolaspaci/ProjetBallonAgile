package com.github.munitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.modelisation.Ballon;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.MunitionToBallonAdapter;

public class MunitionToBallonAdapterTest {
	private Ballon ballon;
	private AbstractMunition munition;

	@BeforeEach
	public void setUp() {
		ballon = new Ballon();
	}

	@Test
	public void testNewMunitionToBallonAdapter() {
		ballon = new Ballon();
		assertEquals(0, ballon.getPressionBallon());
		assertEquals(0, ballon.getTailleBallon());
		munition = new MunitionToBallonAdapter(ballon);
		assertEquals(MunitionToBallonAdapter.PRESSION_BALLON, ballon.getPressionBallon());
		assertEquals(MunitionToBallonAdapter.TAILLE_BALLON_MUNITION, ballon.getTailleBallon());
		assertEquals(MunitionToBallonAdapter.DEGAT_BALLON, munition.getDegatMunition());
	}

}