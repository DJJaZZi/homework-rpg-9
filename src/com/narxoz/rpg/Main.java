package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero hero1 = new Hero("Chronos", 100, 50, 20, 10, 500, null);
        Hero hero2 = new Hero("Afina", 80, 100, 15, 5, 200, null);
        List<Hero> party = Arrays.asList(hero1, hero2);


        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(party);


        System.out.println("\n=== STORAGE RESEARCH RESULTS ===");
        System.out.println("Evaluated artifacts: " + result.getArtifactsAppraised());
        System.out.println("Time snapshots created: " + result.getMementosCreated());
        System.out.println("Happy rewinding time!: " + result.getRestoredCount());
    }
}