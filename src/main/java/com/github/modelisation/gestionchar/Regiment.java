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

		// On change le régiment associé au mécanicien
		mecanicien.setRegiment(this);
	}

	public boolean removeMecanicien(Mecanicien mecanicien) {
		boolean removed = this.mecaniciens.remove(mecanicien);

		// Si on a bien trouvé et retiré le mécanicien du régiment,
		// alors on propage l'affectation au mécanicien.
		if (removed) {
			mecanicien.setRegiment(null);
		}
		return removed;
	}

	public Set<Mecanicien> getMecaniciens() {
		return Collections.unmodifiableSet(mecaniciens);
	}
}
