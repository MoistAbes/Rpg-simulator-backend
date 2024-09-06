package dev.zymixon.rpg_simulation.entities.character;

import dev.zymixon.rpg_simulation.entities.items.Item;
import dev.zymixon.rpg_simulation.enums.EquipmentSlot;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EquipmentSlot slot;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item; // Reference to the item being equipped


}
