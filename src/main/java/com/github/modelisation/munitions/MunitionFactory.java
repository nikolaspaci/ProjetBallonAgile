package com.github.modelisation.munitions;

import com.github.modelisation.Ballon;

public class MunitionFactory {

	private MunitionFactory() {
	}

	public static AbstractMunition getMunition(TypeMunition typeMunition) {
		switch (typeMunition) {
		case BALLON:
			return new BallonToMunitionAdapter(new Ballon());
		case OBUS_EXPLOSIF:
			return new ObusExplosif();
		case OBUS_PERFORANT:
			return new ObusPerforant();
		default:
			return null;
		}
	}

	public static class Of {
		private TypeMunition type;

		public Of(TypeMunition type) {
			this.type = type;
		}

		public AbstractMunition get() {
			return getMunition(type);
		}
	}
}
