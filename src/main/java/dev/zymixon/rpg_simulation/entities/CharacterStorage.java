package dev.zymixon.rpg_simulation.entities;

import dev.zymixon.rpg_simulation.entities.items.Item;
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
public class CharacterStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item; // Reference to the Item entity

    private int quantity; // To track how many of this item the character has


}
