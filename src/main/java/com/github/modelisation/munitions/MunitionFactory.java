package com.github.modelisation.munitions;

import com.github.modelisation.Ballon;

public class MunitionFactory {

    private MunitionFactory() {

    }

    public static AbstractMunition getMunition(TypeMunition typeMunition) {
	switch (typeMunition) {
	case BALLON:
	    return new MunitionToBallonAdapter(new Ballon());
	case OBUS_EXPLOSIF:
	    return new ObusExplosif();
	case OBUS_PERFORANT:
	    return new ObusPerforant();
	default:
	    return null;
	}
    }

}
