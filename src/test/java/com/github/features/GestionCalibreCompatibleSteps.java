package com.github.features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.gestionchar.Mecanicien;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GestionCalibreCompatibleSteps {

	private Mecanicien mecanicien;
	private CharDAttaque charAttaque;
	AbstractMunition munition;

	@Given("un char d attaque de calibre {int} produit par {string}")
	public void un_char_d_attaque_de_calibre_produit_par(Integer calibre, String fabriquant) {
		this.charAttaque = new CharDAttaque(fabriquant, calibre);
	}

	@When("il veut ajouter une {string} de calibre inferieur ou egal au char")
	public void il_veut_ajouter_une_de_calibre_inferieur_ou_egal_au_char(String nomMunition) {
		this.munition = MunitionFactory.getMunition(TypeMunition.valueOf(nomMunition));
		this.charAttaque.ajouterMunition(munition);
	}

	@Then("la munition est bien ajoutee dans la caisse a munitions du char")
	public void la_munition_est_bien_ajoutee_dans_la_caisse_a_munitions_du_char() {
		assertEquals(1, this.charAttaque.getMunitionCount());
	}
}
