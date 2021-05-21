package com.github.features;

import com.github.modelisation.gestionchar.Char;
import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.gestionchar.Mecanicien;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

public class BallonMunitionCharSteps {
    private Mecanicien mecanicien;
    private CharDAttaque shar;
    private AbstractMunition munition;

    @Given("un mecanicien {string}")
    public void un_mecanicien(String nomMecanicien) {
        this.mecanicien = new Mecanicien(nomMecanicien, null);
    }

    @Given("son char d attaque fabrique par {string}")
    public void son_char_d_attaque_fabrique_par(String fabriquant) {
        this.shar = new CharDAttaque(fabriquant, 200);
    }

    @When("il veut utiliser des ballons en tant que munitions")
    public void il_veut_utiliser_des_ballons_en_tant_que_munitions() {
        this.munition = MunitionFactory.getMunition(TypeMunition.BALLON);
        shar.ajouterMunition(munition);
    }

    @Then("le ballon est bien present dans la caisse a munition du char")
    public void le_ballon_est_bien_present_dans_la_caisse_a_munition_du_char() {
        Assertions.assertTrue(!shar.getMunitions().isEmpty()
                && shar.getMunitions().getLast().equals(munition));
    }

}
