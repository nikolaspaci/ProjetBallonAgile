package com.github.modelisation.munitions;

import com.github.modelisation.Ballon;

public class MunitionToBallonAdapter extends AbstractMunition {
    private Ballon ballon;
    private final int TAILLE_BALLON_MUNITION = 10;
    private final int PRESSION_BALLON = 7;

    public MunitionToBallonAdapter(Ballon ballon) {
	this.ballon = ballon;
	this.degatMunition = 2;
	setPressionBallon();
	setTailleBallon();
    }

    private void setPressionBallon() {
	this.ballon.setPressionBallon(PRESSION_BALLON);
    }

    private void setTailleBallon() {
	this.ballon.setTailleBallon(TAILLE_BALLON_MUNITION);
    }

}
