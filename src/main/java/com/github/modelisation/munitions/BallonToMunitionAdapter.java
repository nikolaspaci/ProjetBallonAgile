package com.github.modelisation.munitions;

import com.github.modelisation.Ballon;

public class BallonToMunitionAdapter extends AbstractMunition {
	public static final int TAILLE_BALLON_MUNITION = 10;
	public static final int PRESSION_BALLON = 7;
	public static final int DEGAT_BALLON = 2;

	private Ballon ballon;

	public BallonToMunitionAdapter(Ballon ballon) {
		this.ballon = ballon;
		this.degatMunition = DEGAT_BALLON;
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
