package dev.zymixon.rpg_simulation.entities.items;

import dev.zymixon.rpg_simulation.entities.character.Character;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item; // Reference to the Item entity

    private int quantity; // To track how many of this item the character has

    private int location; // To track the item's position in the inventory


}
