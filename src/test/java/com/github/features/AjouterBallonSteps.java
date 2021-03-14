package com.github.features;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.modelisation.Ballon;
import com.github.modelisation.Sport;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AjouterBallonSteps {
    private Sport sport;
    private Ballon ballon;

    @Given("un sport {string}")
    public void un_sport(String nomSport) {
	this.sport = new Sport(nomSport);
	assertEquals(this.sport.getSport(), nomSport);
    }

    @When("je lui ajoute un ballon")
    public void je_lui_ajoute_un_ballon() {
	this.ballon = new Ballon();
	assertEquals(1, this.ballon.getTailleBallon());
	assertEquals(0., this.ballon.getPressionBallon());
	this.sport.ajouterBallon(ballon);
    }

    @Then("ce ballon est present dans la liste")
    public void ce_ballon_est_present_dans_la_liste() {
	assertTrue(this.sport.getSetBallons().contains(ballon));
    }
}
