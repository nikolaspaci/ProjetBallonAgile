package com.github.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.github.modelisation.gestionchar.*;

import static org.junit.Assert.*;

public class ModifierCalibreSteps {

	private Mecanicien mecanicien;
	private Char shar;

	@Given("le mecanicien {string}")
	public void leMecanicienNomMecanicien(String nomMecanicien) {
		this.mecanicien = new Mecanicien(nomMecanicien, null);
	}

	@And("le char de calibre {int} fabrique par {string}")
	public void leCharDeCalibreCalibreFabriqueParFabriquant(int calibre, String fabriquant) {
		assertTrue(calibre > 0);
		assertNotNull(fabriquant);
		this.shar = new Char(fabriquant, calibre);
		this.mecanicien.setShar(shar);
		assertEquals(this.shar, this.mecanicien.getShar());
	}

	@When("il change le calibre a {int}")
	public void ilChangeLeCalibreANouveauCalibre(int nouveauCalibre) {
		assertTrue(nouveauCalibre > 0);
		this.mecanicien.modifierCalibre(nouveauCalibre);
	}

	@Then("le calibre du char est bien {int}")
	public void leCalibreDuCharEstBienNouveauCalibre(int nouveauCalibre) {
		assertEquals(nouveauCalibre, this.shar.getCalibre());
	}
}