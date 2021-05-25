package com.github.features;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.gestionchar.Mecanicien;
import com.github.modelisation.gestionchar.UncompatibleCalibreException;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GestionCalibreIncompatibleSteps {

	private Mecanicien mecanicien;
	private CharDAttaque charAttaque;
	AbstractMunition munition;
	boolean calibreCompatible;

	@Given("un char d attaque de calibre {int} construit par {string}")
	public void un_char_d_attaque_de_calibre_construit_par(Integer calibre, String fabriquant) {
		this.charAttaque = new CharDAttaque(fabriquant, calibre);
		this.calibreCompatible = true;
	}

	@When("il veut ajouter une {string} de calibre superieur au char")
	public void il_veut_ajouter_une_de_calibre_superieur_au_char(String nomMunition) {
		this.munition = MunitionFactory.getMunition(TypeMunition.valueOf(nomMunition));
		try {
			this.charAttaque.ajouterMunition(munition);
		} catch (UncompatibleCalibreException e) {
			this.calibreCompatible = false;
		}

	}

	@Then("la munition ne rentre pas dans la caisse a munitions du char")
	public void la_munition_ne_rentre_pas_dans_la_caisse_a_munitions_du_char() {
		assertFalse(calibreCompatible);
	}

}
