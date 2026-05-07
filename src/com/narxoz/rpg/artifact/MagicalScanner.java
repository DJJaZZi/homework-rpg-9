package com.narxoz.rpg.artifact;

public class MagicalScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println(" [Weapon] " + weapon.getName() + " (Attack bonus: +" + weapon.getAttackBonus() + ")");
    }

    @Override
    public void visit(Potion potion) {
        System.out.println(" [Potion] " + potion.getName() + " (Restore HP: " + potion.getHealing() + ")");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println(" [Scroll] " + scroll.getName() + " (Spell: " + scroll.getSpellName() + ")");
    }

    @Override
    public void visit(Ring ring) {
        System.out.println(" [Ring] " + ring.getName() + " (Magic bonus: +" + ring.getMagicBonus() + ")");
    }

    @Override
    public void visit(Armor armor) {
        System.out.println(" [Armor] " + armor.getName() + " (Defense bonus: +" + armor.getDefenseBonus() + ")");
    }
}