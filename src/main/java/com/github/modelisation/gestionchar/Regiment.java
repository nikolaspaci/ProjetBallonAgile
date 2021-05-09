package com.github.modelisation.gestionchar;

import java.util.*;

public class Regiment {

	private final Set<Mecanicien> mecaniciens;

	public Regiment(Mecanicien... mecaniciens) {
		this.mecaniciens = new HashSet<>();
		for (Mecanicien m : mecaniciens) {
			this.addMecanicien(m);
		}
	}

	public void addMecanicien(Mecanicien mecanicien) {
		this.mecaniciens.add(mecanicien);

		// On change le r�giment associ� au m�canicien
		mecanicien.setRegiment(this);
	}

	public boolean removeMecanicien(Mecanicien mecanicien) {
		boolean removed = this.mecaniciens.remove(mecanicien);

		// Si on a bien trouv� et retir� le m�canicien du r�giment,
		// alors on propage l'affectation au m�canicien.
		if (removed) {
			mecanicien.setRegiment(null);
		}
		return removed;
	}

	public Set<Mecanicien> getMecaniciens() {
		return Collections.unmodifiableSet(mecaniciens);
	}
}
