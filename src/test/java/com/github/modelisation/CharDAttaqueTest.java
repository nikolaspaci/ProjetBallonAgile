package com.github.modelisation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.BallonToMunitionAdapter;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;

public class CharDAttaqueTest {
	private CharDAttaque charDattaque;
	private List<AbstractMunition> munitions;
	MunitionFactory.Of factory;

	@BeforeEach
	public void setUp() {
		factory = new MunitionFactory.Of(TypeMunition.BALLON);
	}

	@Test
	public void testAjouterMunitionBallonCalibreOK() {
		charDattaque = new CharDAttaque("Renault", BallonToMunitionAdapter.TAILLE_BALLON_MUNITION);
		munitions = Stream.generate(factory::get).limit(CharDAttaque.MAX_MUNITION).collect(Collectors.toList());
		assertEquals(0, charDattaque.getMunitionCount());
		munitions.forEach(charDattaque::ajouterMunition);
		assertEquals(CharDAttaque.MAX_MUNITION, charDattaque.getMunitionCount());
	}

	@Test
	public void testAjouterMunitionBallonCalibreNOK() {
		charDattaque = new CharDAttaque("Renault", BallonToMunitionAdapter.TAILLE_BALLON_MUNITION - 1);
		munitions = Stream.generate(factory::get).limit(CharDAttaque.MAX_MUNITION).collect(Collectors.toList());
		assertEquals(0, charDattaque.getMunitionCount());
		for (AbstractMunition munition : munitions) {
			Assertions.assertThrows(IllegalArgumentException.class, () -> charDattaque.ajouterMunition(munition));
		}
		assertEquals(0, charDattaque.getMunitionCount());
	}

	@Test
	public void testTirerMunitions() {
		charDattaque = new CharDAttaque("Renault", BallonToMunitionAdapter.TAILLE_BALLON_MUNITION);
		munitions = Stream.generate(factory::get).limit(CharDAttaque.MAX_MUNITION).collect(Collectors.toList());
		assertEquals(0, charDattaque.getMunitionCount());
		munitions.forEach(charDattaque::ajouterMunition);
		assertEquals(CharDAttaque.MAX_MUNITION, charDattaque.getMunitionCount());
		IntStream.range(0, charDattaque.getMunitionCount() - 1).forEach(x -> charDattaque.tirer());
		assertEquals(1, charDattaque.getMunitionCount());
	}
}
