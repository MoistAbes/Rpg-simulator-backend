package dev.zymixon.rpg_simulation.services;

import dev.zymixon.rpg_simulation.entities.character.CharacterStats;
import dev.zymixon.rpg_simulation.entities.items.Item;

public class StatModifierService {

    private final int attack;
    private final int defense;
    // Add more stats as needed


    public StatModifierService(int attack, int defense) {
        this.attack = attack;
        this.defense = defense;
    }

    public void applyTo(CharacterStats stats, boolean isAdding) {
        int multiplier = isAdding ? 1 : -1;
        stats.setAttack(stats.getAttack() + multiplier * attack);
        stats.setDefense(stats.getDefense() + multiplier * defense);
        // Apply other stats similarly
    }

    // You can also add methods to create StatModifier from an Item
    public static StatModifierService fromItem(Item item) {
        int attack = item.getWeapon() != null ? item.getWeapon().getDamage() : 0;
        int defense = item.getArmor() != null ? item.getArmor().getDefense() : 0;
        // Initialize other stats similarly

        return new StatModifierService(attack, defense /* other stats */);
    }
}
