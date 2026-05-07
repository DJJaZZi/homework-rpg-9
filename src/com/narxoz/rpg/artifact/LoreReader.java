package com.narxoz.rpg.artifact;

public class LoreReader implements ArtifactVisitor {
    @Override
    public void visit(Weapon weapon) {
        System.out.println(" Legend has it that " + weapon.getName() + " forged in dragon fire.");
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(" On the bottle " + potion.getName() + " faded ancient label.");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(" Scroll " + scroll.getName() + " it smells of centuries-old dust.");
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(" On the inside " + ring.getName() + " unknown runes are engraved.");
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(" Armor " + armor.getName() + " covered with traces of great battles of past eras.");
    }
}