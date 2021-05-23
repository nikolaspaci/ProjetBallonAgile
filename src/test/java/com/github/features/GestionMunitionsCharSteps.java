package com.github.features;
import com.github.modelisation.gestionchar.CharDAttaque;
import com.github.modelisation.gestionchar.Mecanicien;
import com.github.modelisation.munitions.AbstractMunition;
import com.github.modelisation.munitions.MunitionFactory;
import com.github.modelisation.munitions.TypeMunition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GestionMunitionsCharSteps {
    private Mecanicien mecanicien;
    private CharDAttaque shar;
    AbstractMunition munition;
    @Given("le char de calibre d attaque {int} fabrique par {string}")
    public void le_char_de_calibre_d_attaque_fabrique_par(Integer calibre, String fabriquant) {
        this.shar = new CharDAttaque(fabriquant, calibre);
    }

    @Given("sa caisse de munitions contient deja une munition de type {string}")
    public void sa_caisse_de_munitions_contient_deja_une_munition_de_type(String nomMunition) {
        this.shar.ajouterMunition(MunitionFactory.getMunition(TypeMunition.valueOf(nomMunition)));
    }

    @When("il veut utiliser un {string} en tant que munition")
    public void il_veut_utiliser_un_en_tant_que_munition(String nomMunition) {
        this.munition= MunitionFactory.getMunition(TypeMunition.valueOf(nomMunition));
        this.shar.ajouterMunition(munition);
    }

    @Then("la munition de nouveau type est bien ajoutée dans la caisse a munition du char")
    public void le_est_bien_ajouter_dans_la_caisse_a_munition_du_char() {
        Assertions.assertTrue(this.shar.getMunitions().getLast().equals(munition));
    }
}
