package com.github.features;

import org.junit.jupiter.api.Assertions;

import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GestionMunitionsCharSteps {
    private CharDAttaque shar;
    AbstractMunition munition;

    @Given("le char d attaque de calibre {int} fabrique par {string}")
    public void le_char_d_attaque_de_calibre_fabrique_par(Integer calibre, String fabriquant) {
	this.shar = new CharDAttaque(fabriquant, calibre);
    }

    @Given("sa caisse de munitions contient deja une munition de type {string}")
    public void sa_caisse_de_munitions_contient_deja_une_munition_de_type(String nomMunition) {
	this.shar.ajouterMunition(MunitionFactory.getMunition(TypeMunition.valueOf(nomMunition)));
    }

    @When("il veut utiliser un {string} en tant que munition")
    public void il_veut_utiliser_un_en_tant_que_munition(String nomMunition) {
	this.munition = MunitionFactory.getMunition(TypeMunition.valueOf(nomMunition));
	this.shar.ajouterMunition(munition);
    }

    @Then("la munition de nouveau type est bien ajoutee dans la caisse a munition du char")
    public void la_munition_de_nouveau_type_est_bien_ajoutee_dans_la_caisse_a_munition_du_char() {
	Assertions.assertTrue(this.shar.getMunitions().getLast().equals(munition));
    }
}
