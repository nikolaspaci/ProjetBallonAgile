package com.github.modelisation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.modelisation.gestionchar.Char;
import com.github.modelisation.gestionchar.Mecanicien;
import com.github.modelisation.gestionchar.Regiment;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class RegimentTest {
    private Regiment regiment;
    private Char char1;
    private Char char2;
    private Mecanicien sergentBrody;
    private Mecanicien chefLoisy;

    @BeforeEach
    public void setUp() {
        this.regiment = new Regiment();
        this.char1 = new Char("MBDA", 120);
        this.char2 = new Char("Nexter", 200);
        this.sergentBrody = new Mecanicien("SGT Brody", char1);
        this.chefLoisy = new Mecanicien("SCH Loisy", char2);
    }

    @Test
    public void testAddMecanicien() {
        addMecanicienToRegiment(sergentBrody, 0, 1);
        addMecanicienToRegiment(chefLoisy, 1, 2);
    }

    private void addMecanicienToRegiment(Mecanicien mecanicien, int initialCount, int expectedCount) {
        assertEquals(initialCount, regiment.getMecaniciens().size());
        regiment.addMecanicien(mecanicien);
        assertEquals(regiment, mecanicien.getRegiment());
        assertEquals(expectedCount, regiment.getMecaniciens().size());
    }

    @Test
    public void testAddDuplicateMecanicien() {
        addMecanicienToRegiment(sergentBrody, 0, 1);
        addMecanicienToRegiment(sergentBrody, 1, 1);
    }

    @Test
    public void testRemoveMecanicien() {
        addMecanicienToRegiment(sergentBrody, 0, 1);
        boolean removed = regiment.removeMecanicien(sergentBrody);
        assertTrue(removed);
        assertNull(sergentBrody.getRegiment());
        assertEquals(0, regiment.getMecaniciens().size());
    }

    @Test
    public void testGetMecaniciens() {
        assertEquals(Collections.EMPTY_SET, regiment.getMecaniciens());
        regiment.addMecanicien(sergentBrody);

        Set<Mecanicien> onlyBrodySet = new HashSet<>();
        onlyBrodySet.add(sergentBrody);

        assertEquals(onlyBrodySet, regiment.getMecaniciens());

        regiment.addMecanicien(chefLoisy);
        Set<Mecanicien> brodyLoisySet = new HashSet<>();
        brodyLoisySet.add(sergentBrody);
        brodyLoisySet.add(chefLoisy);

        assertEquals(brodyLoisySet, regiment.getMecaniciens());

        regiment.removeMecanicien(sergentBrody);
        Set<Mecanicien> onlyLoisySet = new HashSet<>();
        onlyLoisySet.add(chefLoisy);

        assertEquals(onlyLoisySet, regiment.getMecaniciens());
    }

    @AfterEach
    public void tearDown() {
    }
}
