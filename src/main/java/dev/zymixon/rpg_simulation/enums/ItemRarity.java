package dev.zymixon.rpg_simulation.enums;

import lombok.Getter;

@Getter
public enum ItemRarity {
    COMMON("Common", "A common item with basic attributes."),
    UNCOMMON("Uncommon", "An item that is slightly better than common."),
    RARE("Rare", "A rare item with special attributes."),
    EPIC("Epic", "An epic item with significant advantages."),
    LEGENDARY("Legendary", "A legendary item of the highest quality.");

    private final String name;
    private final String description;

    ItemRarity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
