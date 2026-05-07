package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n=== Entrance to the Chronomancer's Vault ===");

        Inventory vaultLoot = new Inventory();
        vaultLoot.addArtifact(new Weapon("Time Sword", 500, 10, 50));
        vaultLoot.addArtifact(new Potion("Life Potion", 50, 1, 100));
        vaultLoot.addArtifact(new Scroll("Scroll of Truth", 200, 0, "Dispelling Illusions"));
        vaultLoot.addArtifact(new Ring("Ring of Wisdom", 1000, 0, 20));
        vaultLoot.addArtifact(new Armor("Armor of Eternity", 800, 25, 40));

        System.out.println("\n--- EVALUATION OF ARTIFACTS ---");
        GoldAppraiser goldAppraiser = new GoldAppraiser();
        WeightCalculator weightCalc = new WeightCalculator();
        MagicalScanner magicScanner = new MagicalScanner();

        vaultLoot.accept(goldAppraiser);
        vaultLoot.accept(weightCalc);

        System.out.println("Magic scanning:");
        vaultLoot.accept(magicScanner);

        System.out.println("\nThe total value of the treasures: " + goldAppraiser.getTotalValue() + " gold.");
        System.out.println("Total weight of treasure: " + weightCalc.getTotalWeight() + " kg.");

        Hero mainHero = party.get(0);
        Caretaker caretaker = new Caretaker();

        System.out.println("\n--- TIME RIFT (MEMENTO) ---");
        System.out.println("The hero's state BEFORE the trap: " + mainHero);

        caretaker.save(mainHero.createMemento());
        int mementosCreated = caretaker.size();
        System.out.println(" Time snapshot saved! (Total snapshots: " + mementosCreated + ")");

        System.out.println("\n⚠️ The time trap is triggered!");
        mainHero.takeDamage(80);
        mainHero.spendMana(50);
        mainHero.spendGold(mainHero.getGold());
        System.out.println("The hero's state AFTER the trap: " + mainHero);

        System.out.println("\n⏳ Using the Time Crystal... Rewind!");
        mainHero.restoreFromMemento(caretaker.undo());
        int restoredCount = 1;
        System.out.println("The hero's state AFTER rewinding time: " + mainHero);

        return new VaultRunResult(vaultLoot.size(), mementosCreated, restoredCount);
    }
}