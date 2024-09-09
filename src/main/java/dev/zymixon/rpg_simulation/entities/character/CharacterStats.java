package dev.zymixon.rpg_simulation.entities.character;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharacterStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int attack;
    private int maxHealth;
    private int currentHealth;
    private int defense;

//    @OneToOne(mappedBy = "stats")
//    Character character;


    @Override
    public String toString() {
        return "CharacterStats{" +
                "id=" + id +
                ", attack=" + attack +
                ", max Health=" + maxHealth +
                ", current Health=" + maxHealth +
                ", defense=" + defense +
                '}';
    }
}
