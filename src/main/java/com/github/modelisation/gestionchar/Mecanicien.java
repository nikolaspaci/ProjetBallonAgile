package com.github.modelisation.gestionchar;

public class Mecanicien {

	private String name;
	private Char shar;
	private Regiment regiment;

	public Mecanicien(String name, Char shar) {
		this.name = name;
		this.shar = shar;
	}

	public Regiment getRegiment() {
		return regiment;
	}

	public void setRegiment(Regiment regiment) {
		this.regiment = regiment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Char getShar() {
		return shar;
	}

	public void setShar(Char shar) {
		this.shar = shar;
	}

	public void modifierCalibre(int newCalibre) {
		this.shar.setCalibre(newCalibre);
	}
}
