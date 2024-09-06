package dev.zymixon.rpg_simulation.entities.items;

import dev.zymixon.rpg_simulation.enums.ItemRarity;
import dev.zymixon.rpg_simulation.enums.ItemType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private float dropChance;
    private int value;
    private ItemRarity rarity;
    private ItemType type;

    @ManyToOne
    @JoinColumn(name = "armor_id")
    private Armor armor; // Optional reference to armor

    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weapon; // Optional reference to weapon
}
